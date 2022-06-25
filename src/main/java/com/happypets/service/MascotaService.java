package com.happypets.service;

import java.util.List;

import com.happypets.entity.Mascota;


public interface MascotaService {

	public Mascota insertaActualizaMascota(Mascota mascota);
	
	public abstract List<Mascota> listaMascotaPorNombre(String nombre);
	public abstract List<Mascota> listaMascotas();
	public Mascota obtenerMascota(int idMascota);
}
