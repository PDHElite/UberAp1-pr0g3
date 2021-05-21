package com.uberapi.demo.controllers;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	
    //POST

    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public Viaje crearViaje(@RequestBody Viaje viaje){
        return viajeRepository.save(viaje);
    }
	
	
}
