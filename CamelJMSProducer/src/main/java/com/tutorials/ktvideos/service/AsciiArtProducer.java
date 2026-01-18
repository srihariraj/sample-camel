package com.tutorials.ktvideos.service;
import org.apache.camel.ProducerTemplate;
import org.springframework.stereotype.Service;

@Service
public class AsciiArtProducer {

    private final ProducerTemplate producerTemplate;

    public AsciiArtProducer(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    public void sendAsciiArt(String name, String art) {
        // Format: "name|art"
		String message = name + ":" + art;
        producerTemplate.sendBody("direct:sendToQueue", message);
        System.out.println("Sent ASCII Art: " + name);
    }
}
