package com.happypets.service;

import java.util.List;

import com.happypets.entity.Producto;

public interface ProductoService {

	public abstract Producto insertaActualizaProducto(Producto producto);
	
	public abstract List<Producto> listaProducto();
	
	public abstract List<Producto> listaProductoPorNombre(String nombre);
	
}
