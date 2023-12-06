package com.chaima.livres.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chaima.livres.entities.Image;

public interface ImageRepository extends JpaRepository<Image , Long> {
}
