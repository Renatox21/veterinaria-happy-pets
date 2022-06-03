package com.happypets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.happypets.entity.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer>{
	
}
