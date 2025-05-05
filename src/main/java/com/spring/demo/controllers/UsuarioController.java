package com.spring.demo.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.entities.Manga;
import com.spring.demo.entities.Usuario;
import com.spring.demo.repositories.MangaRepository;
import com.spring.demo.repositories.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private MangaRepository mangaRepository;

    @GetMapping("/{username}/favoritos")
    public ResponseEntity<?>  obtenerFavoritos(@PathVariable String username) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByUsername(username);
        if (!usuarioOpt.isPresent()) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", true);
            error.put("msg", "Usuario no encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }

        Usuario usuario = usuarioOpt.get();

        List<Map<String, Object>> favoritos = usuario.getFavoritos().stream().map(manga -> {
            Map<String, Object> m = new HashMap<>();
            m.put("id", manga.getId());
            m.put("nombre", manga.getNombre());
            m.put("fechaLanzamiento", manga.getFecha_lanzamiento());
            m.put("temporadas", manga.getTemporadas());
            m.put("anime", manga.getAnime());
            m.put("juego", manga.getJuego());
            m.put("pelicula", manga.getPelicula());
            m.put("pais", manga.getPais().getNombre());
            m.put("tipo", manga.getTipo().getNombre());
            return m;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(favoritos);
    }
    

@DeleteMapping("/{username}/favoritos/{mangaId}")
public ResponseEntity<?> eliminarFavorito(@PathVariable String username, @PathVariable Integer mangaId) {
    Optional<Usuario> usuarioOpt = usuarioRepository.findByUsername(username);
    if (!usuarioOpt.isPresent()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
            "error", true,
            "msg", "Usuario no encontrado"
        ));
    }

    Optional<Manga> mangaOpt = mangaRepository.findById(mangaId);
    if (!mangaOpt.isPresent()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
            "error", true,
            "msg", "Manga no encontrado"
        ));
    }

    Usuario usuario = usuarioOpt.get();
    Manga manga = mangaOpt.get();

    if (!usuario.getFavoritos().contains(manga)) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of(
            "error", true,
            "msg", "El manga no está en los favoritos del usuario"
        ));
    }

    usuario.getFavoritos().remove(manga);
    usuarioRepository.save(usuario);

    return ResponseEntity.ok(Map.of(
        "error", false,
        "msg", "Manga eliminado de favoritos"
    ));
}
}