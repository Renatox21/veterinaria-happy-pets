package com.happypets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("rest/apiCita")
public class CitaController {
	
	@Autowired
	private CitaService citaService;
	
	@GetMapping("/listarCita")
	@ResponseBody
	public List<Cita> listarCita(){
		return citaService.listarCitas();
	}
	
	@PostMapping("/agregarCita")
	@ResponseBody
	public void guardarCita(@RequestBody Cita cita){
		citaService.guardarCita(cita);
	}
	
	@PutMapping("/actualizarCita")
	@ResponseBody
	public void actualizarCita(@RequestBody Cita cita){
		citaService.guardarCita(cita);
	}
	
	@DeleteMapping("/eliminarCita/{id}")
	@ResponseBody
	public void eliminarCita(@PathVariable("id") int id){
		citaService.eliminarCita(id);
	}

}
