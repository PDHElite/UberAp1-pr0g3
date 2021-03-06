package com.uberapi.demo.controllers;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uberapi.demo.entities.Piloto;
import com.uberapi.demo.entities.Viaje;
import com.uberapi.demo.repositories.Pilotorepository;
import com.uberapi.demo.repositories.Viajerepository;

@RestController
@RequestMapping(value="pilotos")
public class Pilotocontroller {

	@Autowired
	Pilotorepository repository;
	@Autowired
	Viajerepository viajeRepository;
	
	//GET 
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public Collection<Piloto> getListaPilotos(){
		Iterable<Piloto> listaPilotos = repository.findAll();
		
		return (Collection<Piloto>) listaPilotos;
		}
	
	//Piloto 
	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Piloto getCliente(@PathVariable(name = "id") Long id) {
		
		Optional<Piloto> Piloto = repository.findById(id);
		Piloto result = null;
		if(Piloto.isPresent()) {
			result = Piloto.get();
		}
		return result;	
	}
	
	//POST
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Piloto createPiloto(@RequestBody Piloto piloto ) {
		Piloto nuevoPiloto = repository.save(piloto);
		return nuevoPiloto;
	}
	
	//PUT 
	@PutMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Piloto updatePiloto(@PathVariable(name = "id") Long id, 
			@RequestBody Piloto piloto) {
			Optional<Piloto> oPiloto = repository.findById(id);
			if(oPiloto.isPresent()) {
				Piloto actual = oPiloto.get();
				
				
				actual.setId(id);
				actual.setNombre(piloto.getNombre());
				actual.setApellido(piloto.getApellido());
				actual.setLicencia(piloto.getLicencia()); //
				actual.setTelefono(piloto.getTelefono());
				actual.setMatricula(piloto.getMatricula());//
				
				
				Piloto updatedPiloto = repository.save(actual);
				
				return updatedPiloto;
			}
			return null;
		}
	
	@RequestMapping(value = "/{id}/viajes")
	public ResponseEntity<List<Viaje>> getviaje(@PathVariable(name = "id" )long id){
		List<Viaje> viaje = com.uberapi.demo.repositories.Viajerepository.findByIdPiloto(id);
		return ResponseEntity.ok(viaje);
	}
	
	
}
