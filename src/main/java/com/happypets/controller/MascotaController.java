package com.happypets.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.happypets.entity.Mascota;
import com.happypets.service.MascotaService;
import com.happypets.util.Constantes;

@RestController
@RequestMapping("rest/mascota")
public class MascotaController {
	
	@Autowired
	private MascotaService service;
	
	@PostMapping("/agregarMascota")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaMascota(@RequestBody Mascota masc){
		
		Map<String, Object> salida = new HashMap<String, Object>();
		
		try {
						
			Mascota objMascota = service.insertaActualizaMascota(masc);
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
	public ResponseEntity<List<Mascota>> listarMascotaPorNombre(@PathVariable(value = "nombre", required = true) String nombre){
		List<Mascota> lista = service.listaMascotaPorNombre(nombre);
		return ResponseEntity.ok(lista);
	}
	//endpoint: http://localhost:8090/rest/mascota/listarMascotaPorNombre/
}
