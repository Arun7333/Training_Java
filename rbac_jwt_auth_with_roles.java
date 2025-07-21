// --- Role.java ---
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name; // ADMIN, DOCTOR, etc.

    // Getters & Setters
}

// --- User.java ---
@Entity
@Table(name = "users")
public class User {
    @Id
    private UUID userId = UUID.randomUUID();

    @Column(nullable = false, unique = true)
    private String email;

    private String fullName;

    private String passwordHash;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    private boolean isActive = true;
    private boolean isLocked = false;
    private Instant createdAt = Instant.now();

    // Getters & Setters
}

// --- RoleRepository.java ---
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}

// --- RegisterRequest.java ---
public class RegisterRequest {
    public String email;
    public String fullName;
    public String password;
    public String role; // role name like "ADMIN"
}

// --- AuthService.java ---
@Service
public class AuthService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void register(RegisterRequest req) {
        if (userRepo.findByEmail(req.email).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        Role role = roleRepo.findByName(req.role)
                .orElseThrow(() -> new RuntimeException("Invalid role"));

        User user = new User();
        user.setEmail(req.email);
        user.setFullName(req.fullName);
        user.setPasswordHash(passwordEncoder.encode(req.password));
        user.setRole(role);

        userRepo.save(user);
    }
}

// --- JwtUtil.java (Partial) ---
public String generateToken(User user) {
    return Jwts.builder()
        .setSubject(user.getUserId().toString())
        .claim("email", user.getEmail())
        .claim("role", user.getRole().getName())
        .setIssuedAt(new Date())
        .setExpiration(Date.from(Instant.now().plusSeconds(3600)))
        .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
        .compact();
}

public String extractUserId(String token) {
    return getClaims(token).getSubject();
}

public Claims getClaims(String token) {
    return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
}

// --- JwtAuthenticationFilter.java ---
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepo;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);
        String userId;

        try {
            userId = jwtUtil.extractUserId(token);
        } catch (Exception e) {
            filterChain.doFilter(request, response);
            return;
        }

        User user = userRepo.findById(UUID.fromString(userId)).orElse(null);
        if (user == null) {
            filterChain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                user.getEmail(), null,
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().getName()))
        );
        SecurityContextHolder.getContext().setAuthentication(auth);
        filterChain.doFilter(request, response);
    }
}

// --- SecurityConfig.java ---
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private JwtAuthenticationFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/api/admin/**").hasRole("ADMIN")
                .requestMatchers("/api/doctor/**").hasAnyRole("DOCTOR", "ADMIN")
                .anyRequest().authenticated()
            )
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
