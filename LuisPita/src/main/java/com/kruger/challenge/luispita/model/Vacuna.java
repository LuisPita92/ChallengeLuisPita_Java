package com.kruger.challenge.luispita.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Entity
@Data
@Table(name = "vacuna")
public class Vacuna implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@Pattern(regexp = "[A-Za-z]+",message = "Por favor, ingresar solo letras en el nombre.")
	//@NotEmpty(message = "Nombre es requerido.")
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "estado")
	private Boolean estado = true;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
}
