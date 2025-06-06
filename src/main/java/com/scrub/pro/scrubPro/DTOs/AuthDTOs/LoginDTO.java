package com.scrub.pro.scrubPro.DTOs.AuthDTOs;

public class LoginDTO {

    private String Email;
    //    private String username;
    private String password;

    public LoginDTO(String email, String password) {
        this.Email = email;
        this.password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
