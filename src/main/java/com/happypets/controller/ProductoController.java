package com.happypets.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.happypets.entity.Producto;
import com.happypets.entity.Usuario;
import com.happypets.service.ProductoService;
import com.happypets.service.UsuarioService;
import com.happypets.util.Constantes;

@RestController
@RequestMapping("/rest/producto")
public class ProductoController {

	@Autowired
	private ProductoService pservice;
	private UsuarioService uservice;

	@GetMapping("/cargarProducto")
	public String cargarPag(Model model) {
		model.addAttribute("producto", new Producto());
		return "agregarProducto";
	}

	@PostMapping("/grabar")
	public String grabarPag(@ModelAttribute Producto producto) {
		System.out.println(producto);
		pservice.guardarProducto(producto);
		return "agregarProducto";
	}

	@GetMapping("/listarProductos")
	@ResponseBody
	public ResponseEntity<List<Producto>> listaProducto() {
		List<Producto> lista = pservice.listaProducto();
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/listarProductosPorNombre")
	@ResponseBody
	public ResponseEntity<List<Producto>> listarProductoPorNombre(
			@RequestParam(value = "nombre", required = false) String nombre) {
		List<Producto> lista = pservice.listaProductoPorNombre(nombre);
		return ResponseEntity.ok(lista);
	}

	@PostMapping("/agregarProducto")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaProducto(
			@RequestParam(value = "desc_product", required = false) String desc_product,
			@RequestParam(value = "stock", required = false) int stock,
			@RequestParam(value = "pre_uni", required = false) double pre_uni,
			@RequestParam(value = "id_categoria", required = false) int id_categoria) {

		Map<String, Object> salida = new HashMap<String, Object>();

		try {

			Producto p = new Producto();
			p.setDesc_product(desc_product);
			p.setStock(stock);
			p.setPre_uni(pre_uni);
			p.setId_categoria(id_categoria);

			Producto objProducto = pservice.insertaProducto(p);
			if (objProducto == null) {
				salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
			}

		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

	@PostMapping("/guardarProducto")
	public String save(Producto producto, Model model) {
		System.out.println(producto.toString());
		pservice.insertaProducto(producto);
		return "redirect:/productos";
	}

	@PutMapping("/actualizarProducto")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizarProducto(@RequestBody Producto pord) {

		Map<String, Object> salida = new HashMap<String, Object>();

		try {
			Producto obj = pservice.obtenerProducto(pord.getId_producto());
			if (obj == null) {
				salida.put("mensaje", "El producto no existe");
				return ResponseEntity.ok(salida);
			}
			Producto objProducto = pservice.actualizaProducto(pord);
			if (objProducto == null) {
				salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
			} else {
				salida.put("mensaje", Constantes.MENSAJE_ACT_EXITOSO);
			}

		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
		}
		return ResponseEntity.ok(salida);
	}

}
