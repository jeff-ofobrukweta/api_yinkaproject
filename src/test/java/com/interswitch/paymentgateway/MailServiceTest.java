package com.interswitch.paymentgateway;


import com.interswitch.paymentgateway.Service.MailSenderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MailServiceTest {


    @Autowired
    private MailSenderService service;
    @Test
    public  void send(){
        service.Send("oghenerukevwejeff@gmail.com","Test the api","What up cow");
    }
}

