package com.happypets.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happypets.entity.Usuario;
import com.happypets.repository.UsuarioRepository;
import com.happypets.service.UsuarioService;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public Usuario insertaUsuario(Usuario usuario) {		
		return repository.save(usuario);
	}

	@Override
	public List<Usuario> listaUsuario() {		
		return repository.findAll();
	}

	@Override
	public Usuario actualizaUsuario(Usuario usuario) {
		Usuario usu = obtenerUsuario(usuario.getUser());
		if (usu == null) {
			return null;
		}

		return repository.save(usuario);
	}

	@Override
	public Usuario obtenerUsuario(String user) {		
		return repository.findById(user).orElse(null);
	}

}
