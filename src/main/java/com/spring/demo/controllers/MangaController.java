package com.spring.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.entities.Manga;
import com.spring.demo.services.MangaService;

@RestController
@RequestMapping("/mangas")
public class MangaController {

	@Autowired
	private MangaService service;
	
	@GetMapping("/{id}")
	public Manga getManga(@PathVariable int id) {
		
		return service.getManga(id);
	}
	
	@GetMapping
	public List<Manga> getMangas(){
		return service.getMangas();
	}
	
	@PostMapping
	public void createContinete(@RequestBody Manga manga) {
	
		service.creteaManga(manga);
	}
	
	@DeleteMapping("/{id}")
	public void deleteManga(@PathVariable int id) {
	
		service.deleteManga(id);
	}
	
	@DeleteMapping("/deleteMangas")
	public void deleteMangas() {
		service.deleteMangas();
	}
	
	@PutMapping("/{id}")
	public void  actualizarManga(@PathVariable int id, @RequestBody Manga manga) {
		service.actualizarManga(id,manga);
	}
	
}
