package com.uberapi.demo.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uberapi.demo.entities.Viaje;
import com.uberapi.demo.repositories.Viajerepository;

@RestController
@RequestMapping(value="/viajes")
public class Viajecontroller {
    @Autowired
    Viajerepository viajeRepository;

	//GET 
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public Collection<Viaje> getListaViajes(){
		Iterable<Viaje> listaViajes = viajeRepository.findAll();
		
		return (Collection<Viaje>) listaViajes;
		}
	
	
	//Viaje 
	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Viaje getViaje(@PathVariable(name = "id") Long id) {
		Optional<Viaje> Viaje = viajeRepository.findById(id);
		Viaje result = null;
		if(Viaje.isPresent()) {
			result = Viaje.get();
			}
			return result;	
		}
	
	
    //POST

    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public Viaje crearViaje(@RequestBody Viaje viaje){
		Viaje nuevoViaje = viajeRepository.save(viaje);
		return nuevoViaje;
    }
	
	//PUT 
	@PutMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Viaje updateCliente(@PathVariable(name = "id") Long id, 
			@RequestBody Viaje viaje) {
			Optional<Viaje> oViaje = viajeRepository.findById(id);
			if(oViaje.isPresent()) {
				Viaje actual = oViaje.get(); 
				actual.setId(id);
				actual.setOrigen(viaje.getOrigen());
				actual.setDestino(viaje.getDestino());
				actual.setEstado(viaje.getEstado());
				actual.setMonto(viaje.getMonto());
				Viaje updatedViaje = viajeRepository.save(actual);
				return updatedViaje;
			}
			return null;
		}
	
}
