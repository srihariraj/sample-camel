package com.tutorials.ktvideos.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tutorials.ktvideos.service.AsciiArtProducer;

@RestController
@RequestMapping("/ascii")
public class AsciiArtController {

	private final AsciiArtProducer producer;

	public AsciiArtController(AsciiArtProducer producer) {
		this.producer = producer;
	}

	@PostMapping("/send")
	public String send(@RequestParam String name, @RequestParam String art) {
		producer.sendAsciiArt(name, art);
		return "Sent ASCII Art: " + name;
	}
}
