package com.spring.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.demo.entities.Favorito;
import com.spring.demo.entities.FavoritoId;

public interface FavoritoRepository extends JpaRepository<Favorito, FavoritoId> {
    List<Favorito> findByUsuarioUsername(String username);
}
