package com.happypets.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.happypets.entity.Mascota;
import com.happypets.repository.MascotaRepository;
import com.happypets.service.MascotaService;

public class MascotaServicelmpl implements MascotaService{

	@Autowired
	private MascotaRepository repository;
	
	@Override
	public List<Mascota> listaMascotaPorNombre(String nombre) {
		return repository.buscarMascotaPorNombre(nombre);
	}
	
}
