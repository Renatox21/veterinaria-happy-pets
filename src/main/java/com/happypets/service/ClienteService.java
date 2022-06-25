package com.happypets.service;

import java.util.List;

import com.happypets.entity.Cliente;


public interface ClienteService {

	public abstract Cliente insertaActualizaCliente(Cliente cliente);
	
	public abstract List<Cliente> listaCliente();
	
	public abstract Cliente obtenerCliente(int id);
	
	public abstract List<Cliente> listaClientePorNombre(String nombre);
	
}
