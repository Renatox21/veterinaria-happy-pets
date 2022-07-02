package com.happypets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.happypets.entity.DetalleComprobante;

@Repository
public interface DetalleComprobanteRepository extends JpaRepository<DetalleComprobante, Integer>{

}
