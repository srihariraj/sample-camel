package com.tutorials.ktvideos.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.tutorials.ktvideos.service.AsciiArtService;

@Component
public class AsciiArtConsumerRoute {

	@Autowired
	private AsciiArtService service;

	@JmsListener(destination = "${spring.artemis.embedded.queues}")
	public void receive(String message) {

		service.validateAndSave(message);

	}
}
