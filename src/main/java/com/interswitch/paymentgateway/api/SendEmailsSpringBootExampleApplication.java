package com.interswitch.paymentgateway.api;

import com.interswitch.paymentgateway.Service.MailSenderService;
import com.interswitch.paymentgateway.Service.SimpleMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SendEmailsSpringBootExampleApplication implements CommandLineRunner {

    @Autowired
    private MailSenderService senderService;

    @Override
    public void run(String... args) throws Exception {

        // send a simple mail
        senderService.sendSimpleMail(new SimpleMail("oghenerukevwejeff@gmail.com"));

    }
}