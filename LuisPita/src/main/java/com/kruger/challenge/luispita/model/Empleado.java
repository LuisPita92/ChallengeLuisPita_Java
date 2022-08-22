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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "empleado")
public class Empleado implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@Pattern(regexp = "[0-9]+",message = "Por favor, ingresar cedula con solo números.")
	//@NotEmpty(message = "Campo requerido.")
	@Column(unique=true, length = 10)
	private String cedula;
	
	//@Pattern(regexp = "[A-Za-z]+",message = "Por favor, ingresar nombre con solo letras.")
	//@NotEmpty(message = "Nombre es requerido.")
	@Column(name = "nombre")
	private String nombre;
	
	//@Pattern(regexp = "[A-Za-z]+",message = "Por favor, ingresar apellido con solo letras.")
	//@NotEmpty(message = "Apellido es requerido.")
	@Column(name = "apellido")
	private String apellido;
	
	//@NotEmpty(message = "Correo es requerido.")
	//@Email(message = "El e-mail no tiene formato correcto.")
	@Column(unique = true, name = "correo")
	private String correo;
	
	//@NotEmpty(message = "Usuario es requerido.")
	@Column(unique = true, name = "usuario")
	private String usuario;
	
	//@NotEmpty(message = "Clave es requerido.")
	@Column(unique = true, name = "clave")
	private String clave;

	@Column(name = "fecha_nacimiento")
	private Date fecha_nacimiento;

	@Column(name = "direccion")
	private String direccion;
	
	//@Pattern(regexp = "[0-9]+",message = "Por favor, ingresar cedula con solo números.")
	@Column(name = "celular")
	private String celular;
	
	@Column(name = "vacunado")
	private Boolean vacunado = false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Boolean getVacunado() {
		return vacunado;
	}

	public void setVacunado(Boolean vacunado) {
		this.vacunado = vacunado;
	}
	
	
	
}
