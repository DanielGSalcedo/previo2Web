package com.spring.demo.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manga {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	private String nombre;
	private Date fecha_lanzamiento;
	private Integer temporadas;
	
	private Integer anime;
	private Integer juego;
	private Integer pelicula;
	
	@ManyToOne
	@JoinColumn(name = "pais_id")
	@JsonIgnoreProperties({"id"})
	private Pais pais;

	@ManyToOne
	@JoinColumn(name = "tipo_id")
	@JsonIgnoreProperties({"id"})
	private Tipo tipo;
	

}
