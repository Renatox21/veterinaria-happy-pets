package com.happypets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.happypets.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

	@Query("select p from Producto p where desc_producto like %:nombre%")
	public abstract List<Producto> buscarProductoProNombre(@Param("nombre")String nombre);
	
}
