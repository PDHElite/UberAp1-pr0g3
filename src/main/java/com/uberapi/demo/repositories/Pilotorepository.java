package com.uberapi.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.uberapi.demo.entities.Piloto;
import com.uberapi.demo.entities.Viaje;

public interface Pilotorepository extends CrudRepository<Piloto, Long> {
	
	static List<Viaje>findByIdPiloto(Long id) {
		// TODO Auto-generated method stub
		return null;
}

}
