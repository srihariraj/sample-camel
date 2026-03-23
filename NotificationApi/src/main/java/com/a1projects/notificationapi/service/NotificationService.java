package com.a1projects.notificationapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendTo(String to, String message) {
        if (to == null || to.isEmpty()) {
            // Default email address, perhaps from config
            to = "default@example.com"; // Replace with actual default
        }

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject("Notification");
        mailMessage.setText(message);

        mailSender.send(mailMessage);
    }
}
