package com.happypets.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.happypets.entity.Mascota;
import com.happypets.entity.Producto;
import com.happypets.service.MascotaService;
import com.happypets.util.Constantes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("rest/mascota")
@Tag(name = "API Mascota", description = "API con servicios para la gestion de las mascotas")
public class MascotaController {
	
	@Autowired
	private MascotaService service;
	
	@PostMapping("/saveMascota")
    public String guardarMascota(Mascota mascota) {
        System.out.println(mascota.toString());

        service.insertaActualizaMascota(mascota);

        return "listarMascota";
    }
	
	@PostMapping("/agregarMascota")
	@ResponseBody
	@Operation(summary = "Registra Mascota", description = "Permite registrar el ingreso de una nueva mascota")
	public ResponseEntity<Map<String, Object>> insertaMascota(
			@Parameter(name = "nombre", description = "Ingresa nombre de la mascota")
			@RequestParam(value = "nombre", required = false) String nombre,
			@Parameter(name = "tipo", description = "Ingresa tipo de mascota")
			@RequestParam(value = "tipo", required = false) String tipo,
			@Parameter(name = "raza", description = "Ingresa raza de la mascota")
			@RequestParam(value = "raza", required = false) String raza,
			@Parameter(name = "vacuna", description = "Ingresa codigo de la vacuna de la mascota")
			@RequestParam(value = "vacuna", required = false) int vacuna,
			@Parameter(name = "fec_nac", description = "Ingresa fecha de nacimineto de la mascota")
			@RequestParam(value = "fec_nac", required = false) Date fec_nac
			){
		
		Map<String, Object> salida = new HashMap<String, Object>();
		
		try {
						
			Mascota mascota = new Mascota();
			mascota.setNombre_mascota(nombre);
			mascota.setTipo_mascota(tipo);
			mascota.setRaza_mascota(raza);
			mascota.setId_vacunas(vacuna);
			LocalDateTime ldt = LocalDateTime.now();
			mascota.setFec_mascota(Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant()));
			mascota.setFec_nac(fec_nac);
			
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
	
	@GetMapping("/listarMascotaPorNombre")
	@ResponseBody
	@Operation(summary = "Listar Mascota", description = "Obtener listado de las mascotas")
	public ResponseEntity<List<Mascota>> listarMascotas(
			@Parameter(name = "nombre", description = "Nombre o letra del nombre de la mascota")
			@RequestParam(value = "nombre", required = true) String nombre){
		List<Mascota> lista = service.listaMascotaPorNombre(nombre);
		return ResponseEntity.ok(lista);
	}

	
	@GetMapping("/listarMascotas")
	@ResponseBody
	@Operation(summary = "Listar Mascota por Nombre", description = "Obtener listado de las mascotas por nombre")
	public ResponseEntity<List<Mascota>> listarMascotaPorNombre(){
		List<Mascota> lista = service.listaMascotas();
		return ResponseEntity.ok(lista);
	}
	
	@PutMapping("/actualizarMascota")
	@ResponseBody
	@Operation(summary = "Actualizar mascota", description = "Permite actualizar mascota")
	public ResponseEntity<Map<String, Object>> actualizarMascota(@Parameter(name = "mascota", description = "Envia una entidad de tipo mascota") @RequestBody Mascota masc){
		
		Map<String, Object> salida = new HashMap<String, Object>();
		
		try {						
			Mascota obj = service.obtenerMascota(masc.getId_mascota());
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
