package com.happypets.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.happypets.entity.Cliente;
import com.happypets.service.ClienteService;
import com.happypets.util.Constantes;

@RestController
@RequestMapping("/rest/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@GetMapping("/listarClientes")
	@ResponseBody
	public ResponseEntity<List<Cliente>> listaProducto() {
		List<Cliente> lista = service.listaCliente();
		return ResponseEntity.ok(lista);
	}
		
	@GetMapping("/listarClientesPorNombre")
	@ResponseBody
	public ResponseEntity<List<Cliente>> listarProductoPorNombre(@RequestParam(value = "nombre", required = false) String nombre) {
		List<Cliente> lista = service.listaClientePorNombre(nombre);
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/agregarCliente")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> saveCliente(
			@RequestParam(value="dni", required = false) String dni,
			@RequestParam(value="nombre", required = false) String nombre,
			@RequestParam(value="apellido", required = false) String apellido,
			@RequestParam(value="correo", required = false) String correo,
			@RequestParam(value="telefono", required = false) String telefono,
			@RequestParam(value="direccion", required = false) String direccion,
			@RequestParam(value="sexo", required = false) String sexo) {
		
		Map<String, Object> dispo = new HashMap<>();
		try {
			
			Cliente cli = new Cliente();
			cli.setDni(dni);
			cli.setNombre(nombre);
			cli.setApellido(apellido);
			cli.setCorreo(correo);
			cli.setTelefono(telefono);
			cli.setDireccion(direccion);
			cli.setSexo(sexo);	
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
	
}
