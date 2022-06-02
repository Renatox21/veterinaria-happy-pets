package com.happypets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.happypets.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

	@Query("select p from Producto p where desc_producto like %:nombre%")
	public List<Producto> buscarProductoProNombre(String nombre);

}
