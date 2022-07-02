package com.happypets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.happypets.entity.Cita;
import com.happypets.entity.Comprobante;
import com.happypets.service.ComprobanteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("rest/Comprobante")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "API Comprobante", description = "API con servicios para la gestion de comprobante")
public class ComprobanteController {

	@Autowired
	private ComprobanteService comprobanteService;
	
	@GetMapping("/listarComprobante")
	@ResponseBody
	@Operation(summary = "Listar comprobante", description = "Obtener listado de los comprobantes")
	public List<Comprobante> listarComprobante(){
		return comprobanteService.listarComprobante();
	}
	
	@PostMapping("/agregarComprobante")
	@ResponseBody
	@Operation(summary = "Registro comprobante", description = "Registra comprobantes en la base de datos")
	public Comprobante guardarComprobante(@RequestBody Comprobante comprobante){
		return comprobanteService.guardarComprobante(comprobante);
	}
	
	@PutMapping("/actualizarComprobante/{num}")
	@ResponseBody
	@Operation(summary = "Actualizar comprobante", description = "Actualiza comprobantes existentes")
	public Comprobante actualizarComprobante(@RequestBody Comprobante comprobante, @PathVariable String num){
		Comprobante c = comprobanteService.buscarPorNum(num);
		
		return comprobanteService.guardarComprobante(comprobante);
	}
	
}
