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

import com.uberapi.demo.entities.Cliente;
import com.uberapi.demo.repositories.Clienterepository;

@RestController
@RequestMapping(value="/clientes")
public class Clientecontroller {
	
	@Autowired
	Clienterepository repository;
	
	//GET 
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public Collection<Cliente> getListaClientes(){
		Iterable<Cliente> listaClientes = repository.findAll();
		
		return (Collection<Cliente>) listaClientes;
		}
	
	
	//Cliente
	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Cliente getCliente(@PathVariable(name = "id") Long id) {
		
		Optional<Cliente> Cliente = repository.findById(id);
		Cliente result = null;
		if(Cliente.isPresent()) {
			result = Cliente.get();
		}
		return result;	
	}
	
	//POST 
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cliente createCliente(@RequestBody Cliente cliente ) {
		Cliente nuevoCliente = repository.save(cliente);
		return nuevoCliente;
	}
	
	//PUT 
	@PutMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Cliente updateCliente(@PathVariable(name = "id") Long id, 
			@RequestBody Cliente cliente) {
			Optional<Cliente> oCliente = repository.findById(id);
			if(oCliente.isPresent()) {
				Cliente actual = oCliente.get(); 
				actual.setId(id);
				actual.setNombre(cliente.getNombre());
				actual.setApellido(cliente.getApellido());
				actual.setCorreo(cliente.getCorreo());
				actual.setTelefono(cliente.getTelefono());
				Cliente updatedCliente = repository.save(actual);
				return updatedCliente;
			}
			return null;
		}

}
