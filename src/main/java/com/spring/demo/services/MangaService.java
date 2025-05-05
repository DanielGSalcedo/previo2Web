package com.spring.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.demo.entities.Manga;
import com.spring.demo.entities.Pais;
import com.spring.demo.entities.Tipo;
import com.spring.demo.repositories.MangaRepository;
import com.spring.demo.repositories.PaisRepository;
import com.spring.demo.repositories.TipoRepository;

@Service
public class MangaService {
	@Autowired
	private MangaRepository repository;
	private PaisRepository paisRepository;
	private TipoRepository tipoRepository;
	
	public Manga getManga(int id) {
		
		return repository.findById(id).orElse(null);
	}
	
	public List<Manga> getMangas(){
		
		return repository.findAll();
	}
	
	public void creteaManga(Manga coninente) {
		
		repository.save(coninente);
	}
	
    public boolean deleteManga(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
	public void deleteMangas() {
		repository.deleteAll();
	}
	

    public Manga actualizarManga(int id, Manga mangaDetalles) {
   
        if (mangaDetalles.getNombre() == null || mangaDetalles.getNombre().isEmpty()) {
            throw new RuntimeException("El campo nombre es obligatorio");
        }
        if (mangaDetalles.getFecha_lanzamiento() == null) {
            throw new RuntimeException("El campo fechaLanzamiento es obligatorio");
        }
        if (mangaDetalles.getTemporadas() == null) {
            throw new RuntimeException("El campo temporadas es obligatorio");
        }
        if (mangaDetalles.getPais() == null || mangaDetalles.getPais().getId() == null) {
            throw new RuntimeException("El campo paisId es obligatorio");
        }
        if (mangaDetalles.getTipo() == null || mangaDetalles.getTipo().getId() == null) {
            throw new RuntimeException("El campo tipoId es obligatorio");
        }

      
        Optional<Pais> paisOptional = paisRepository.findById(mangaDetalles.getPais().getId());
        if (!paisOptional.isPresent()) {
            throw new RuntimeException("Pais no existe");
        }

        Optional<Tipo> tipoOptional = tipoRepository.findById(mangaDetalles.getTipo().getId());
        if (!tipoOptional.isPresent()) {
            throw new RuntimeException("Tipo no existe");
        }


        Manga manga = repository.findById(id).orElseThrow(() -> new RuntimeException("Manga no encontrado"));

        manga.setNombre(mangaDetalles.getNombre());
        manga.setFecha_lanzamiento(mangaDetalles.getFecha_lanzamiento());
        manga.setTemporadas(mangaDetalles.getTemporadas());
        manga.setAnime(mangaDetalles.getAnime());
        manga.setJuego(mangaDetalles.getJuego());
        manga.setPelicula(mangaDetalles.getPelicula());
        manga.setTipo(tipoOptional.get());
        manga.setPais(paisOptional.get());

        return repository.save(manga);
    }
	
}
