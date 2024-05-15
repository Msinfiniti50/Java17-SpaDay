package org.launchcode.spaday.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class User {

    @NotBlank(message="verify cannot be blank")
    private String verify;

    @NotBlank(message="username cannot be blank")
    @Size(min = 5, max = 15, message="Username must be between 5 and 15 characters")
    private String username;

    @NotBlank(message="password cannot be blank")
    @Size(min = 6, message="Password must be at least 6 characters long")
    private String password;

    @Email(message = "Invalid email. Try again.")
    private String email;

    public User() {
    }

    public User(String username, String verify, String password) {
        this.username =username;
        this.verify = verify;
        this.password = password;

    }
    public User (String username, String verify, String password, String email) {
        this.username = username;
        this.verify = verify;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public String getVerify() {
        return verify;
    }

}
