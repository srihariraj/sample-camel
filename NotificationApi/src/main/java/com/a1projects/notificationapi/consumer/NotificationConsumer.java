package com.a1projects.notificationapi.consumer;

import com.a1projects.notificationapi.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {

    @Autowired
    private NotificationService notificationService;

    @JmsListener(destination = "end.user.notify")
    public void receiveMessage(String message) {
       notificationService.sendTo("",message);
    }
}
