package com.scrub.pro.scrubPro.DTOs.UserDTOs;

public class CreateUserDTO {
    private String UserName;
    private String Email;
    private String Password;
    private String RoleId;

    public CreateUserDTO() {
    }

    public CreateUserDTO(String userName, String email, String password, String roleId) {
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

    public String getRoleId() {
        return RoleId;
    }

    public void setRoleId(String roleId) {
        RoleId = roleId;
    }
}
