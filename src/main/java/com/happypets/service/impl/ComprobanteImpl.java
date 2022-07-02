package com.happypets.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happypets.entity.Comprobante;
import com.happypets.repository.ComprobanteRepository;
import com.happypets.service.ComprobanteService;

@Service
@Transactional
public class ComprobanteImpl implements ComprobanteService{

	@Autowired
	private ComprobanteRepository repository;
	
	@Override
	public List<Comprobante> listarComprobante() {
		return repository.findAll();
	}

	@Override
	public Comprobante guardarComprobante(Comprobante comprobante) {
		return repository.save(comprobante);
	}


	@Override
	public Comprobante buscarPorNum(String num) {
		return repository.findById(num).orElse(null);
	}

}
