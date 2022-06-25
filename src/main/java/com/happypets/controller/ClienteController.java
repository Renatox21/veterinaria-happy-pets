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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/rest/cliente")
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
	public ResponseEntity<List<Cliente>> listarClientePorNombre(
			@Parameter(name = "Nombre", description = "Ingresa un nombre o una letra")
			@RequestParam(value = "nombre", required = false) String nombre) {
		List<Cliente> lista = service.listaClientePorNombre(nombre);
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/agregarCliente")
	@ResponseBody
	@Operation(summary = "Registro cliente", description = "Registra los clientes en la base de datos")
	public ResponseEntity<Map<String, Object>> saveCliente(
			@Parameter(name = "dni", description = "Ingresa el dni del cliente")
			@RequestParam(value="dni", required = false) String dni,
			@Parameter(name = "nombre", description = "Ingresa el nombre del cliente")
			@RequestParam(value="nombre", required = false) String nombre,
			@Parameter(name = "apellido", description = "Ingresa el apellido del cliente")
			@RequestParam(value="apellido", required = false) String apellido,
			@Parameter(name = "correo", description = "Ingresa el correo del cliente")
			@RequestParam(value="correo", required = false) String correo,
			@Parameter(name = "telefono", description = "Ingresa el telefono del cliente")
			@RequestParam(value="telefono", required = false) String telefono,
			@Parameter(name = "direccion", description = "Ingresa el direccion del cliente")
			@RequestParam(value="direccion", required = false) String direccion,
			@Parameter(name = "sexo", description = "Ingresa el sexo del cliente")
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
