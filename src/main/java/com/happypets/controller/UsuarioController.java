package com.happypets.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.happypets.entity.Usuario;
import com.happypets.service.UsuarioService;
import com.happypets.util.Constantes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/rest/usuario")
@Tag(name = "API Usuario", description = "API con servicios para la gestion de usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	
	@GetMapping("/listarUsuarios")
	@ResponseBody
	@Operation(summary = "Listado de usuarios", description = "Obtener listado de usuarios")
	public ResponseEntity<List<Usuario>> listaUsuario() {
		List<Usuario> lista = service.listaUsuario();
		return ResponseEntity.ok(lista);
	}
	
	
	@PostMapping("/agregarUsuario")
	@ResponseBody
	@Operation(summary = "Registro usuario", description = "Registra nuevos usuarios")
	public ResponseEntity<Map<String, Object>> insertaUsuario(@RequestBody Usuario usu){
		
		Map<String, Object> salida = new HashMap<String, Object>();
		
		try {
						
			Usuario objUsuario = service.insertaUsuario(usu);
			if(objUsuario == null){
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			}else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	@PutMapping("/actualizarUsuario")
	@ResponseBody
	@Operation(summary = "Actualiza usuario", description = "Actualiza los usuarios existentes")
	public ResponseEntity<Map<String, Object>> actualizarUsuario(@RequestBody Usuario usu){
		
		Map<String, Object> salida = new HashMap<String, Object>();
		
		try {						
			Usuario obj = service.obtenerUsuario(usu.getUser());
			if (obj == null) {
				salida.put("mensaje", "El usuario no existe");
				return ResponseEntity.ok(salida);
			}
			Usuario objUsuario = service.actualizaUsuario(usu);
			if(objUsuario == null){
				salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
			}else {
				salida.put("mensaje", Constantes.MENSAJE_ACT_EXITOSO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}
	
	
	
}
