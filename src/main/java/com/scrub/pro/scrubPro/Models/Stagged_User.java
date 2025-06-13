package com.scrub.pro.scrubPro.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "Stagged_users")
public class Stagged_User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserId;

    public Stagged_User() {
    }

    @NotNull
    @Size(max = 100)
    private String UserName;

    @jakarta.validation.constraints.Email(message = "Please enter valid email")
    @NotNull
    @Size(max = 50)
    private String Email;

//    public String getDefPassword() {
//        return DefPassword;
//    }
//
//    public void setDefPassword(String defPassword) {
//        DefPassword = defPassword;
//    }

    @NotNull
    @Size(max = 255)
    private String Password;

//    @NotNull
//    @Size(max = 255)
//    private String DefPassword;

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    @ManyToOne
    @JoinColumn(name = "RoleId", nullable = false)
    @com.fasterxml.jackson.annotation.JsonBackReference
    private Role role;

    public Stagged_User(int id, String userName, String email, String password, Role role) {
        UserId = id;
        UserName = userName;
        Email = email;
        Password = password;
        this.role = role;
    }

    public int getId() {
        return UserId;
    }

    public void setId(int id) {
        UserId = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
