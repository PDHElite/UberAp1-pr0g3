package com.uberapi.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.uberapi.demo.entities.Viaje;

public interface Viajerepository extends CrudRepository<Viaje, Long> {
	
	static List<Viaje>findByIdCliente(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	static List<Viaje> findByIdPiloto(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
