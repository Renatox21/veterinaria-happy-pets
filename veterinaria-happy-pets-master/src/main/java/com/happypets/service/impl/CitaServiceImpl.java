package com.happypets.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happypets.entity.Cita;
import com.happypets.repository.CitaRepository;
import com.happypets.service.CitaService;

@Service
public class CitaServiceImpl implements CitaService {

	@Autowired
	private CitaRepository citaRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Cita> listarCitas() {
		return citaRepository.findAll();
	}

	@Override
	@Transactional
	public void guardarCita(Cita cita) {
		citaRepository.save(cita);
	}

	@Override
	@Transactional
	public void eliminarCita(int id) {
		citaRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Cita obtenerCitaId(Cita cita) {
		return citaRepository.findById(cita.getId_consulta()).orElse(null);
	}
	
}
