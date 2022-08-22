package com.kruger.challenge.luispita.model;

import java.io.Serializable;
import java.util.Date;
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
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Entity
@Data
@Table(name = "empleado_vacuna")
public class EmpleadoVacuna implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//@NotEmpty(message = "Fecha de vacunación es requerida.")
	@Column(name = "fecha_vacunacion")
	private Date fecha_vacunacion;

	//@NotEmpty(message = "Número de dosis es requerido.")
	@Column(name = "numero_dosis")
	private String numero_dosis;
	
	@OneToMany(targetEntity = EmpleadoVacuna.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "empleado", referencedColumnName = "id")
	private List<Empleado> listEmpleado;
	
	@OneToMany(targetEntity = EmpleadoVacuna.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "vacuna", referencedColumnName = "id")
	private List<Vacuna> listVacuna;
}