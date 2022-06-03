package com.happypets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.happypets.entity.Mascota;
import com.happypets.service.MascotaService;

@RestController
@RequestMapping("rest/mascota")
public class MascotaController {
	
	@Autowired
	private MascotaService service;
	
	@GetMapping("/listarMascotaPorNombre")
	@ResponseBody
	public ResponseEntity<List<Mascota>> listarMascotaPorNombre(@PathVariable(value = "nombre", required = true) String nombre){
		List<Mascota> lista = service.listaMascotaPorNombre(nombre);
		return ResponseEntity.ok(lista);
	}
	//endpoint: http://localhost:8090/rest/mascota/listarMascotaPorNombre/
}
