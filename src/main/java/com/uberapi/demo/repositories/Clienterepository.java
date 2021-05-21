package com.uberapi.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.uberapi.demo.entities.Cliente;

public interface Clienterepository extends CrudRepository<Cliente, Long> {

}
