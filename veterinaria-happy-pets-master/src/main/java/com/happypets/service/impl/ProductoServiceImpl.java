package com.happypets.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.happypets.entity.Producto;
import com.happypets.repository.ProductoRepository;
import com.happypets.service.ProductoService;

public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository repository;
	
	@Override
	public Producto insertaActualizaProducto(Producto producto) {		
		return repository.save(producto);
	}

	@Override
	public List<Producto> listaProducto() {		
		return repository.findAll();
	}

	@Override
	public List<Producto> listaProductoPorNombre(String nombre) {		
		return repository.buscarProductoProNombre(nombre);
	}

}