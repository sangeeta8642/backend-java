package com.scrub.pro.scrubPro.DTOs.UserDTOs;

import com.scrub.pro.scrubPro.Models.Role;

public class UserResDTO {
    private int user_id;
    private String userName;
    private String email;
    private Role role;

    public int getId() {
        return user_id;
    }

    public void setId(int id) {
        this.user_id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserResDTO(int id, String userName, String email, Role role) {
        this.user_id = id;
        this.userName = userName;
        this.email = email;
        this.role = role;
    }
}
