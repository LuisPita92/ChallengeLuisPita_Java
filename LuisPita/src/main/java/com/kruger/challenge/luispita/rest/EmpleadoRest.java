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

import com.kruger.challenge.luispita.model.Empleado;
import com.kruger.challenge.luispita.repository.EmpleadoRepository;
import com.kruger.challenge.luispita.service.EmpleadoService;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoRest {

	@Autowired
	EmpleadoService empleadoService;
	
	@GetMapping(path = "listAll")
	public ResponseEntity<List<Empleado>> list(){
		return ResponseEntity.ok(empleadoService.getAllEmpleado());
	}
	
	@GetMapping(path = "listById")
	public ResponseEntity<Optional<Empleado>> listById(@PathVariable Long id){
		return ResponseEntity.ok(empleadoService.getEmpleadoById(id));
	}
	
	@PostMapping("create")
	public ResponseEntity<Empleado> create(@RequestBody Empleado empleado){
		Empleado temporal = empleadoService.create(empleado);
		try {
			return ResponseEntity.created(new URI("api/empleado"+temporal.getId())).body(temporal);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping("update")
	public ResponseEntity<?> update(@RequestBody Empleado empleado){
		Map<String, Object> response = new HashMap<>();
		Optional<Empleado> temporal = empleadoService.getEmpleadoById(empleado.getId());
		Empleado nuevoEmpleado = new Empleado();
		try {
			if (temporal == null) {
				response.put("mensaje", "No existe el empleado");
				return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
			}
			nuevoEmpleado = temporal.get();
			nuevoEmpleado.setCedula(empleado.getCedula());
			nuevoEmpleado.setNombre(empleado.getNombre());
			nuevoEmpleado.setApellido(empleado.getApellido());
			nuevoEmpleado.setCorreo(empleado.getCorreo());
						
			return ResponseEntity.created(new URI("api/empleado/update")).body(temporal);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping("delete")
	public ResponseEntity<?> delete(@RequestBody Empleado empleado){
		Map<String, Object> response = new HashMap<>();
		try {
			empleadoService.delete(empleado.getId());
			response.put("mensaje", "Empleado eliminado con éxito.");
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
