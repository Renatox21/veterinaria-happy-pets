package com.happypets.service;


import java.util.List;

import com.happypets.entity.Cita;

public interface CitaService {
	
	public List<Cita> listarCitas();
	
	public void guardarCita(Cita cita);
	
	public void eliminarCita(int id);
	
	public Cita obtenerCitaId(Cita cita);

}
