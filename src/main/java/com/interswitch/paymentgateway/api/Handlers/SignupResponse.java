package com.interswitch.paymentgateway.api.Handlers;

import java.util.List;

public class SignupResponse extends Response {
    private final String accountNo;

    public SignupResponse(String code, String description, List<Error> errors, String accountNo) {
        super(code, description, errors);
        this.accountNo = accountNo;
    }

    public String getAccountNo() {
        return accountNo;
    }
}
