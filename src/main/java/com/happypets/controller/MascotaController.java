package com.happypets.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.happypets.entity.Mascota;
import com.happypets.entity.Usuario;
import com.happypets.service.MascotaService;
import com.happypets.util.Constantes;

@RestController
@RequestMapping("rest/mascota")
public class MascotaController {

	@Autowired
	private MascotaService service;
	
	//http://localhost:8090/rest/mascota/listarMascota
	@GetMapping("/listarMascota")
	public List<Mascota> obtenerMascotas(){			
		return service.listarMascotas();
	}
	
	
	//request
	/*El formato JSON es el siguiente:
	* 
	  {
       "id_mascota": 2,
       "nombre_mascota": "Kazzu",
       "tipo_mascota": "Perro",
       "raza_mascota": "Golden",
       "id_vacunas": 1,
       "fec_mascota": "2022-01-02",
       "fec_nac": "2021-05-03"
      }
	* */
	//http://localhost:8090/rest/mascota/actualizarMascota	
	@PutMapping("/actualizarMascota")
	public ResponseEntity<Map<String, Object>> actualizarMascota(@RequestBody Mascota mascota){
		
		Map<String, Object> salida = new HashMap<String, Object>();
		
		try {
			
			Mascota objMascota = service.actualizarMascota(mascota);
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
	
}
