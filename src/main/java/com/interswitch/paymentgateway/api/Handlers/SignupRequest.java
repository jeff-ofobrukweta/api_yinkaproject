package com.interswitch.paymentgateway.api.Handlers;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class SignupRequest extends LoginRequest {
    @Length(min =3,max =50)
    @NotBlank(message = "required")
    private  String firstname;
    @Length(min =3,max =50)
    @NotBlank(message = "required")
    private  String lastname;


    @Length(min =11,max =15)
    @NotBlank(message = "required")
    private  String mobileNo;

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "SignupRequest{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + getPassword() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                '}';
    }


}
