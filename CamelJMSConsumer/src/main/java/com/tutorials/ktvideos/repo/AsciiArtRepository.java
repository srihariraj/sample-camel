package com.tutorials.ktvideos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorials.ktvideos.entity.AsciiArt;

@Repository
public interface AsciiArtRepository extends JpaRepository<AsciiArt, Long> {

    //  built in implementations
}
