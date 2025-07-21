package com.example.hospital_management_system.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotNull
    public String email;
    @NotNull
    public String name;
    @NotNull
    public String password;
    public String role;
}