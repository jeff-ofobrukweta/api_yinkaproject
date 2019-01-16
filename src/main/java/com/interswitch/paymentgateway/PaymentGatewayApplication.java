package com.interswitch.paymentgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
@EnableAsync
public class PaymentGatewayApplication {
    public static void main(String[] args){
        SpringApplication.run(PaymentGatewayApplication.class,args);
    }

}
