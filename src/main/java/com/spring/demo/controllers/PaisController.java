package com.spring.demo.controllers;


import com.spring.demo.entities.Pais;
import com.spring.demo.services.PaisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("paises")
public class PaisController {
    private final PaisService paisService;

    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    @GetMapping
    public List<Pais> getAll() {
        return paisService.getPaises();
    }

    @PostMapping
    public Pais create(@RequestBody Pais pais) {
        return paisService.save(pais);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        paisService.delete(id);
    }
}