package com.scrub.pro.scrubPro.DTOs.UserDTOs;

public class CreateUserDTO {
    private String UserName;
    private String Email;
    private String Password;
    private int RoleId;

    public CreateUserDTO(String userName, String email, String password, int roleId) {
        UserName = userName;
        Email = email;
        Password = password;
        RoleId = roleId;
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

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int roleId) {
        RoleId = roleId;
    }
}
