package com.happypets.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.happypets.entity.Producto;
import com.happypets.service.ProductoService;
import com.happypets.util.Constantes;

@RestController
@RequestMapping("rest/producto")
public class ProductoController {

	@Autowired
	private ProductoService service;
	
	@GetMapping("/listarProductos")
	@ResponseBody
	public ResponseEntity<List<Producto>> listaProducto() {
		List<Producto> lista = service.listaProducto();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/listarProductosPorNombre")
	@ResponseBody
	public ResponseEntity<List<Producto>> listarProductoPorNombre(@PathVariable(name = "nombre", requerid = true), String nombre) {
		List<Producto> lista = service.listaProductoPorNombre(nombre);
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/agregarProducto")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaProducto(@RequestBody Producto prod){
		
		Map<String, Object> salida = new HashMap<String, Object>();
		
		try {
						
			Producto objProducto = service.insertaActualizaProducto(prod);
			if(objProducto == null){
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
