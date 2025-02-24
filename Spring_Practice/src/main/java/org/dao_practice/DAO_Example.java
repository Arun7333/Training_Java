package org.dao_practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DAO_Example {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    public JdbcTemplate getJdbcTemplate(){
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedTemplate){
        this.namedJdbcTemplate = namedTemplate;
    }

    public void clearTable(){
        jdbcTemplate.execute("truncate table users");
        System.out.println("Table data cleared");
    }

    public void addUser(int id, String name, String email, int mark){

        //using update method
//        String query = "insert into users values(?, ?, ?, ?);";
//        jdbcTemplate.update(query, new Object[]{id, name, email, mark});

        //using named Parameter Template
        String query = "insert into users values(:id, :name, :email, :mark);";
        SqlParameterSource params = new MapSqlParameterSource().addValue("id", id)
                .addValue("name", name)
                .addValue("email", email)
                .addValue("mark", mark);
        namedJdbcTemplate.update(query, params);

        System.out.println("user added!");
    }

    public void addBatch(List<Object[]> params){
        String query = "insert into users values(?, ?, ?, ?);";
        jdbcTemplate.batchUpdate(query, params);

        System.out.println("batches updated!");
    }

    public void deleteById(int id){
        String cmd = "delete from users where id = ?";
        jdbcTemplate.update(cmd, id);
        System.out.println("deleted successfully!");
    }

    public List<User> getUsers(){
        List<User> users = jdbcTemplate.query(
                "select * from users",
//                (res, rowNum)->{
//                    User user = new User();
//                    user.id = res.getInt("id");
//                    user.name = res.getString("name");
//                    user.email = res.getString("email");
//                    user.mark = res.getInt("mark");
//                    return user;
//                }
                new BeanPropertyRowMapper<User>(User.class)
        );

        return users;
    }

    public User getById(String email){
        return (User) jdbcTemplate.queryForObject(
                "select * from users where email = ?",
                new Object[]{email},
                new BeanPropertyRowMapper<User>(User.class)
        );
    }

    public void setName(String email, String name){

    }


}
