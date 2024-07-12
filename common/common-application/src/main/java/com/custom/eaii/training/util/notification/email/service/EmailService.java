package com.custom.eaii.training.util.notification.email.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailService {
    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendTo(String emailTo, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailTo);
        message.setSubject(subject);
        message.setText(body);
        this.javaMailSender.send(message);
    }
}
