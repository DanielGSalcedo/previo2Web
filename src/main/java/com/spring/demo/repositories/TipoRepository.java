package com.spring.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.demo.entities.Tipo;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Integer> {

}
