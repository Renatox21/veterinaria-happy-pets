package com.happypets.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happypets.entity.Producto;
import com.happypets.repository.ProductoRepository;
import com.happypets.service.ProductoService;

@Service
@Transactional
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository repository;
	
	@Override
	public Producto insertaProducto(Producto producto) {		
		return repository.save(producto);
	}

	@Override
	public Producto actualizaProducto(Producto producto) {		
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

	@Override
	public Producto obtenerProducto(int id) {
		return repository.findById(id).orElse(null);
	}

}