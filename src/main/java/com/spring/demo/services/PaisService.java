package com.spring.demo.services;


import com.spring.demo.entities.Pais;
import com.spring.demo.repositories.PaisRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisService {
    private final PaisRepository paisRepository;

    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public List<Pais> getPaises() {
        return paisRepository.findAll();
    }

    public Pais save(Pais pais) {
        return paisRepository.save(pais);
    }

    public void delete(int id) {
        paisRepository.deleteById(id);
    }
}