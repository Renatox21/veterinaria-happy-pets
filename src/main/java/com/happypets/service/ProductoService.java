package com.happypets.service;

import java.util.List;

import com.happypets.entity.Producto;

public interface ProductoService {

	public abstract Producto insertaProducto(Producto producto);
	public abstract Producto actualizaProducto(Producto producto);
	public abstract List<Producto> listaProducto();
	
	public abstract Producto obtenerProducto(int id);
	
	public abstract List<Producto> listaProductoPorNombre(String nombre);
	
}
