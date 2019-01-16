package com.interswitch.paymentgateway.api.Handlers;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class LoginRequest {
    @NotBlank(message = "required")
    @Length(min =5,max = 20)
    @Pattern(message="The password first character must be a letter,it must contain capital letter", regexp = "^[a-zA-Z]\\w{3,14}$")
    private  String password;
    @Email
    @Length(min =6,max =50)
    @NotBlank(message = "required")
    private  String email;


    public String getEmail() { return email; }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
