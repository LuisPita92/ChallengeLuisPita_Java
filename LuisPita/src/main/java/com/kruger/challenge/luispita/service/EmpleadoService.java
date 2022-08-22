package com.kruger.challenge.luispita.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.kruger.challenge.luispita.model.Empleado;
import com.kruger.challenge.luispita.repository.EmpleadoRepository;

@RestController
public class EmpleadoService {

	@Autowired
	EmpleadoRepository empleadoRepo;

	public List<Empleado> getAllEmpleado(){
		return empleadoRepo.findAll();
	}
	
	public Optional<Empleado> getEmpleadoById(Long Id){
		return empleadoRepo.findById(Id);
	}
	
	public Empleado create(Empleado empleado){
		return empleadoRepo.save(empleado);
	}
	
	public Empleado update(Empleado empleado){
		return empleadoRepo.save(empleado);
	}
	
	public void delete(Long id){
		empleadoRepo.deleteById(id);
	}
}
