package com.interswitch.paymentgateway.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class MailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    // Use it to send Simple text emails
    public void sendSimpleMail(SimpleMail mail) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(mail.getTo());
        message.setSubject(mail.getSubject());
        message.setText(mail.getContent());

        mailSender.send(message);
    }
    public  void Send(String email,String subject,String message){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailSender.send(mailMessage);

    }

}