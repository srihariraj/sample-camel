package com.tutorials.ktvideos.service;

import org.springframework.stereotype.Service;

import com.tutorials.ktvideos.entity.AsciiArt;
import com.tutorials.ktvideos.repo.AsciiArtRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AsciiArtService {

	private final AsciiArtRepository repository;
    public AsciiArtService(AsciiArtRepository repository) {
        this.repository = repository;
    }
    public void validateAndSave(String message) {


		log.info("Validating message: {}", message);
		String[] parts = message.split(":");
        String name = parts[0];
        String art = parts.length > 1 ? parts[1] : "";

		AsciiArt entity = new AsciiArt();
        entity.setName(name);
        entity.setArt(art);
        repository.save(entity);

		System.out.println("Saved ASCII Art: " + name + " : " + art);
    }
}
