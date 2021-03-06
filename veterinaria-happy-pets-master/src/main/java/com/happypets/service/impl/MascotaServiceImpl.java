package com.happypets.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.happypets.entity.Mascota;
import com.happypets.repository.MascotaRepository;
import com.happypets.service.MascotaService;

@Service
public class MascotaServiceImpl implements MascotaService{

	@Autowired
	private MascotaRepository repository;

	@Override
	public Mascota insertaActualizaMascota(Mascota mascota) {
		return repository.save(mascota);
	}
	
}
