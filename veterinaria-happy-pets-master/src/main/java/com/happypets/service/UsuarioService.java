package com.happypets.service;

import java.util.List;

import com.happypets.entity.Usuario;

public interface UsuarioService {

	public abstract Usuario insertaActualizaUsuario(Usuario usuario);
	
	public abstract List<Usuario> listaUsuario();
	
}
