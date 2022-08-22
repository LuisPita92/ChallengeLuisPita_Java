package com.kruger.challenge.luispita.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.kruger.challenge.luispita.model.Vacuna;
import com.kruger.challenge.luispita.repository.VacunaRepository;

@RestController
public class VacunaService {

	@Autowired
	VacunaRepository vacunaRepo;

	public List<Vacuna> getAllVacunas(){
		return vacunaRepo.findAll();
	}
	
	public Optional<Vacuna> getVacunaById(Long Id){
		return vacunaRepo.findById(Id);
	}
	
	public Vacuna create(Vacuna vacuna){
		return vacunaRepo.save(vacuna);
	}
	
	public Vacuna update(Vacuna vacuna){
		return vacunaRepo.save(vacuna);
	}
	
	public void delete(Long id){
		vacunaRepo.deleteById(id);
	}
}
