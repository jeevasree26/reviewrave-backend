package com.example.Reviewrave.Dto;

import com.example.Reviewrave.Enum.Role;

public class RegisterUserDto {
    private String email;
    private String password;
    private String fullname;
    private String organization;
    private Role role;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getOrganization() {
        return organization;
    }
    public void setOrganization(String organization) {
        this.organization = organization;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    public RegisterUserDto(){
        
    }
    public RegisterUserDto(String email, String password, String fullname, String organization, Role role) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.organization = organization;
        this.role = role;
    }
}
