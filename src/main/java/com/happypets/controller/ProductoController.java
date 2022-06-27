package com.happypets.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.happypets.entity.Producto;
import com.happypets.service.ProductoService;
import com.happypets.util.Constantes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/rest/producto")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "API Producto", description = "API con servicios para la gestion de productos")
public class ProductoController {

	@Autowired
	private ProductoService service;
	
	@GetMapping("/listarProductos")
	@ResponseBody
	@Operation(summary = "Listar productos", description = "Obtener listado de productos")
	public ResponseEntity<List<Producto>> listaProducto() {
		List<Producto> lista = service.listaProducto();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/listarProductosPorNombre")
	@ResponseBody
	@Operation(summary = "Listar producto por nombre", description = "Obtener listado de productos filtrado por su nombre")
	public ResponseEntity<List<Producto>> listarProductoPorNombre(@RequestParam(value = "nombre", required = false) String nombre) {
		List<Producto> lista = service.listaProductoPorNombre(nombre);
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/agregarProducto")
	@ResponseBody
	@Operation(summary = "Registrar productos", description = "Permite registrar productos")
	public ResponseEntity<Map<String, Object>> insertaProducto(
			@Parameter(name = "producto", description = "Datos del producto")
			@RequestBody Producto producto){
		
		Map<String, Object> salida = new HashMap<String, Object>();
		
		try {
								
			Producto objProducto = service.insertaProducto(producto);
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
	
	@PutMapping("/actualizarProducto")
	@ResponseBody
	@Operation(summary = "Actualizar productos", description = "Permite actualizar productos")
	public ResponseEntity<Map<String, Object>> actualizarProducto(@Parameter(name = "producto", description = "Envia una entidad de tipo Producto") @RequestBody Producto pord){
		
		Map<String, Object> salida = new HashMap<String, Object>();
		
		try {						
			Producto obj = service.obtenerProducto(pord.getId());
			if (obj == null) {
				salida.put("mensaje", "El producto no existe");
				return ResponseEntity.ok(salida);
			}
			Producto objProducto = service.actualizaProducto(pord);
			if(objProducto == null){
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
