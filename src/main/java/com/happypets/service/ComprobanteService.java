package com.happypets.service;

import java.util.List;

import com.happypets.entity.Comprobante;
import com.happypets.entity.Mascota;

public interface ComprobanteService {

	
	public List<Comprobante> listarComprobante();
	
	public Comprobante guardarComprobante(Comprobante comprobante);
	
	public Comprobante buscarPorNum(String num);
}
