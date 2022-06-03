package com.happypets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.happypets.entity.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer>{

	@Query("select m from Mascota m where nombre_mascota like %:nombre%")
	public List<Mascota> buscarMascotaPorNombre(String nombre);
}
