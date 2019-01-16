package com.interswitch.paymentgateway.api.Handlers;
import java.util.List;


public class Response {
    private String code;
    private String description;
    private List<Error> errors;



    public String getCode() {
        return code;
    }
    public String getDescription() {
        return description;
    }
    public List<Error> getErrors() {
        return errors;
    }

    public Response(String code, String description, List<Error> errors) {
        this.code = code;
        this.description = description;
        this.errors = errors;
    }
}

