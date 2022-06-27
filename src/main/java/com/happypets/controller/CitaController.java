package com.happypets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.happypets.entity.Cita;
import com.happypets.service.CitaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("rest/Cita")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "API Cita", description = "API con servicios para la gestion de cita")
public class CitaController {
	
	@Autowired
	private CitaService citaService;
	
	@GetMapping("/listarCita")
	@ResponseBody
	@Operation(summary = "Listar citas", description = "Obtener listado de las citas")
	public List<Cita> listarCita(){
		return citaService.listarCitas();
	}
	
	@PostMapping("/agregarCita")
	@ResponseBody
	@Operation(summary = "Registro cita", description = "Registra citas en la base de datos")
	public Cita guardarCita(@RequestBody Cita cita){
		return citaService.guardarCita(cita);
	}
	
	
	@PutMapping("/actualizarCita/{id}")
	@ResponseBody
	@Operation(summary = "Actualizar cita", description = "Actualiza citas existentes")
	public Cita actualizarCita(@RequestBody Cita cita, @PathVariable int id){
		Cita citaActual = citaService.buscarPorId(id);
		
		return citaService.guardarCita(cita);
	}
	
	@DeleteMapping("/eliminarCita/{id}")
	@ResponseBody
	@Operation(summary = "Elimina cita", description = "Elimina citas existentes")
	public void eliminarCita(@PathVariable("id") int id){
		citaService.eliminarCita(id);
	}

}
