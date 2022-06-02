package com.happypets.service;

import java.util.List;
import com.happypets.entity.Mascota;

public interface MascotaService {
	
	public List<Mascota> listarMascotas();
	
	public Mascota actualizarMascota(Mascota mascota);	
}
