package com.spring.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.demo.entities.Manga;

@Repository
public interface MangaRepository extends JpaRepository<Manga, Integer>{

}
