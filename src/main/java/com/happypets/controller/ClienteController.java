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

import com.happypets.entity.Cliente;
import com.happypets.service.ClienteService;
import com.happypets.util.Constantes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/rest/cliente")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "API Cliente", description = "API con servicios para la gestion de clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@GetMapping("/listarClientes")
	@ResponseBody
	@Operation(summary = "Listar Cliente", description = "Permite registrar el ingreso de una nueva mascota")
	public ResponseEntity<List<Cliente>> listaCliente() {
		List<Cliente> lista = service.listaCliente();
		return ResponseEntity.ok(lista);
	}
		
	@GetMapping("/listarClientesPorNombre")
	@ResponseBody
	@Operation(summary = "Listar Cliente por Nombre", description = "Permite listar el cliente por nombre o una letra de su nombre")
	public ResponseEntity<Map<String, Object>> listarClientePorNombre(
			@Parameter(name = "Nombre", description = "Ingresa un nombre o una letra")
			@RequestParam(value = "nombre", required = false) String nombre) {
		
		Map<String, Object> salida = new HashMap<>();
				
		try {
			List<Cliente> lista = service.listaClientePorNombre(nombre);
			if (CollectionUtils.isEmpty(lista)) {
				salida.put("message", "No existen Clientes en la consulta");
			} else {
				salida.put("list", lista);
				salida.put("message", "Existen " + lista.size() + " cliente(s)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(salida);
	}
	
	@PostMapping("/agregarCliente")
	@ResponseBody
	@Operation(summary = "Registro cliente", description = "Registra los clientes en la base de datos")
	public ResponseEntity<Map<String, Object>> saveCliente(@RequestBody Cliente cli) {
		Map<String, Object> dispo = new HashMap<>();
		try {
			LocalDateTime ldt = LocalDateTime.now();			
			cli.setFRegistro(Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant()));
			Cliente objCli = service.insertaActualizaCliente(cli);
			if (objCli == null) {
				dispo.put("message", Constantes.MENSAJE_REG_ERROR);
			} else {
				dispo.put("message", Constantes.MENSAJE_REG_EXITOSO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			dispo.put("message", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(dispo);
	}
	
	@PutMapping("/actualizaCliente")
	@ResponseBody
	@Operation(summary = "Actualiza cliente", description = "Actulaizaa los clientes en la base de datos")
	public ResponseEntity<Map<String, Object>> updateProducto(@RequestBody Cliente cliente){
				
		Map<String, Object> salida = new HashMap<String, Object>();
		
		try {						
			
			if (cliente.getIdCliente() == 0) {
				salida.put("mensaje", "El idProducto del Producto debe ser diferente 0");
				return ResponseEntity.ok(salida);
			}
			Cliente objCliente = service.insertaActualizaCliente(cliente);
			if(objCliente == null){
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
