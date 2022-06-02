package com.happypets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.happypets.entity.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer>{

}
