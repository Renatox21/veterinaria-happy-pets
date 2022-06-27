package com.happypets.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.happypets.entity.Mascota;
import com.happypets.service.MascotaService;
import com.happypets.util.Constantes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("rest/mascota")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "API Mascota", description = "API con servicios para la gestion de las mascotas")
public class MascotaController {
	
	@Autowired
	private MascotaService service;
			
	@GetMapping("/listarMascotas")
	@ResponseBody
	@Operation(summary = "Listar Mascota por Nombre", description = "Obtener listado de las mascotas por nombre")
	public ResponseEntity<List<Mascota>> listarMascotaPorNombre(){
		List<Mascota> lista = service.listaMascotas();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/listarMascotaPorNombre")
	@ResponseBody
	@Operation(summary = "Listar Mascota", description = "Obtener listado de las mascotas")
	public ResponseEntity<Map<String, Object>> listarMascotas(
			@Parameter(name = "nombre", description = "Nombre o letra del nombre de la mascota")
			@RequestParam(value = "nombre", required = true) String nombre){
		
		Map<String, Object> salida = new HashMap<>();
		try {
		
			List<Mascota> lista = service.listaMascotaPorNombre(nombre);
			if (CollectionUtils.isEmpty(lista)) {
				salida.put("message", "No existen Mascotas en la consulta");
			} else {
				salida.put("list", lista);
				salida.put("message", "Existen " + lista.size() + " mascota(s)");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(salida);
	}	
	
	@PostMapping("/agregarMascota")
	@ResponseBody
	@Operation(summary = "Registra Mascota", description = "Permite registrar el ingreso de una nueva mascota")
	public ResponseEntity<Map<String, Object>> insertaMascota(
			@Parameter(name = "mascota", description = "Ingresa datos de la mascota")
			@RequestBody Mascota mascota){
		
		Map<String, Object> salida = new HashMap<String, Object>();
		
		try {
						
			LocalDateTime ldt = LocalDateTime.now();
			mascota.setFecMascota(Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant()));
						
			Mascota objMascota = service.insertaActualizaMascota(mascota);
			if(objMascota == null){
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
	
	@PutMapping("/actualizarMascota")
	@ResponseBody
	@Operation(summary = "Actualizar mascota", description = "Permite actualizar mascota")
	public ResponseEntity<Map<String, Object>> actualizarMascota(@Parameter(name = "mascota", description = "Envia una entidad de tipo mascota") @RequestBody Mascota masc){
		
		Map<String, Object> salida = new HashMap<String, Object>();
		
		try {						
			Mascota obj = service.obtenerMascota(masc.getId());
			if (obj == null) {
				salida.put("mensaje", "El id de la mascota no existe");
				return ResponseEntity.ok(salida);
			}
			Mascota objMascota = service.insertaActualizaMascota(masc);
			if(objMascota == null){
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
