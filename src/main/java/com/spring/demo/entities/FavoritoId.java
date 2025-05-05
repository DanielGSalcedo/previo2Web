package com.spring.demo.entities;
import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Embeddable
public class FavoritoId implements Serializable {

    private String usuarioUsername;
    private Integer mangaId;

    public FavoritoId() {}

    public FavoritoId(String usuarioUsername, Integer mangaId) {
        this.usuarioUsername = usuarioUsername;
        this.mangaId = mangaId;
    }

    // equals() y hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FavoritoId)) return false;
        FavoritoId that = (FavoritoId) o;
        return Objects.equals(usuarioUsername, that.usuarioUsername) &&
               Objects.equals(mangaId, that.mangaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioUsername, mangaId);
    }

	public String getUsuarioUsername() {
		return usuarioUsername;
	}

	public void setUsuarioUsername(String usuarioUsername) {
		this.usuarioUsername = usuarioUsername;
	}

	public Integer getMangaId() {
		return mangaId;
	}

	public void setMangaId(Integer mangaId) {
		this.mangaId = mangaId;
	}

}