package com.spring.demo.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "favoritos")
public class Favorito {

    @EmbeddedId
    private FavoritoId id = new FavoritoId();

    @ManyToOne
    @MapsId("usuarioUsername")
    @JoinColumn(name = "usuario_username")
    private Usuario usuario;

    @ManyToOne
    @MapsId("mangaId")
    @JoinColumn(name = "manga_id")
    private Manga manga;


    public Favorito() {}

    public Favorito(Usuario usuario, Manga manga) {
        this.usuario = usuario;
        this.manga = manga;
        this.id = new FavoritoId(usuario.getUsername(), manga.getId());
    }

	public FavoritoId getId() {
		return id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Manga getManga() {
		return manga;
	}

	public void setId(FavoritoId id) {
		this.id = id;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setManga(Manga manga) {
		this.manga = manga;
	}


}