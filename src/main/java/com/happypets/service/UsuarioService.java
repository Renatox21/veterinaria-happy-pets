package com.happypets.service;

import java.util.List;

import com.happypets.entity.Usuario;

public interface UsuarioService {

	public Usuario insertaUsuario(Usuario usuario);
	public Usuario actualizaUsuario(Usuario usuario);
	public abstract List<Usuario> listaUsuario();
	public Usuario obtenerUsuario(String user);
	
}
