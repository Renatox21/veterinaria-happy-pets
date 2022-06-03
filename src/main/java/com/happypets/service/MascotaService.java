package com.happypets.service;

import java.util.List;

import com.happypets.entity.Mascota;

public interface MascotaService {

	public abstract List<Mascota> listaMascotaPorNombre(String nombre);
}
