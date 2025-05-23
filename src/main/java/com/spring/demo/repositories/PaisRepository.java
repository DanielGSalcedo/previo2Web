package com.spring.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.demo.entities.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {

}
