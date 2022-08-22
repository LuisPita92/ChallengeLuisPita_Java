package com.kruger.challenge.luispita.rest;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.kruger.challenge.luispita.model.Vacuna;
import com.kruger.challenge.luispita.service.VacunaService;

@RestController
@RequestMapping("/api/vacuna")
public class VacunaRest {

	@Autowired
	VacunaService vacunaService;
	
	@GetMapping(path = "listAll")
	public ResponseEntity<List<Vacuna>> list(){
		return ResponseEntity.ok(vacunaService.getAllVacunas());
	}
	
	@GetMapping(path = "listById")
	public ResponseEntity<Optional<Vacuna>> listById(@PathVariable Long id){
		return ResponseEntity.ok(vacunaService.getVacunaById(id));
	}
	
	@PostMapping("create")
	public ResponseEntity<Vacuna> create(@RequestBody Vacuna vacuna){
		Vacuna temporal = vacunaService.create(vacuna);
		try {
			return ResponseEntity.created(new URI("api/vacuna"+temporal.getId())).body(temporal);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping("update")
	public ResponseEntity<?> update(@RequestBody Vacuna vacuna){
		Map<String, Object> response = new HashMap<>();
		Optional<Vacuna> temporal = vacunaService.getVacunaById(vacuna.getId());
		Vacuna nuevaVacuna = new Vacuna();
		try {
			if (temporal == null) {
				response.put("mensaje", "No existe la vacuna.");
				return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
			}
			nuevaVacuna = temporal.get();
			nuevaVacuna.setNombre(vacuna.getNombre());
			nuevaVacuna.setEstado(vacuna.getEstado());
						
			return ResponseEntity.created(new URI("api/vacuna/update")).body(temporal);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping("delete")
	public ResponseEntity<?> delete(@RequestBody Vacuna vacuna){
		Map<String, Object> response = new HashMap<>();
		try {
			vacunaService.delete(vacuna.getId());
			response.put("mensaje", "Vacuna eliminada con éxito.");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
