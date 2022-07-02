package com.happypets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.happypets.entity.Comprobante;

@Repository
public interface ComprobanteRepository extends JpaRepository<Comprobante, String>{
	
}
