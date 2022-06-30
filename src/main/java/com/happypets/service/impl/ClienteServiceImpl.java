package com.happypets.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happypets.entity.Cliente;
import com.happypets.repository.ClienteRepository;
import com.happypets.service.ClienteService;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public Cliente insertaActualizaCliente(Cliente cliente) {
		return repository.save(cliente);		
	}

	@Override
	public List<Cliente> listaCliente() {
		return repository.findAll();
	}

	@Override
	public Cliente obtenerCliente(int id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Cliente> listaClientePorNombre(String nombre) {
		return repository.buscarClienteProNombre(nombre);
	}

	
}
