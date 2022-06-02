package com.happypets.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.happypets.entity.Usuario;
import com.happypets.repository.UsuarioRepository;
import com.happypets.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public Usuario insertaActualizaUsuario(Usuario usuario) {		
		return repository.save(usuario);
	}

	@Override
	public List<Usuario> listaUsuario() {		
		return repository.findAll();
	}

}
