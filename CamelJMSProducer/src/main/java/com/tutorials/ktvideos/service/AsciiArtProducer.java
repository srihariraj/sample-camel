package com.tutorials.ktvideos.service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AsciiArtProducer {

    private final JmsTemplate jmsTemplate;
    public AsciiArtProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
        System.out.println("Constructing AsciiArtProducer");
    }
    public void sendAsciiArt(String name, String art) {
        // Format: "name|art"
		String message = name + ":" + art;
        log.info("MESSAGE SENT TO QUEUE {}", name+art);// jmsTemplate.convertAndSend("end.user.notify", message);

    }
}
