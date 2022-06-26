package com.happypets.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@Tag(name = "API Producto", description = "API con servicios para la gestion de productos")
public class ProductoController {

	@Autowired
	private ProductoService service;
	
	@GetMapping("/cargarProducto")
    public String cargarPag(Model model) {
        model.addAttribute("producto", new Producto());
        return "agregarProducto";
    }

    @PostMapping("/grabar")
    public String grabarPag(@ModelAttribute Producto producto, Model model) {
    	if(producto !=null && producto.getId_producto() > 0) {		
			model.addAttribute("msj", "Producto "+producto.getId_producto()+" agregado");			
			service.insertaProducto(producto);
			return "agregarProducto";	
		}else {
			model.addAttribute("msj", "Error al registrar producto");			
		return "agregarProducto";
		}        
    }
    
    @GetMapping("/listarProductos")
	public String listadoProductos(@ModelAttribute Producto p, Model model) {		
		model.addAttribute("lstProductos", service.listaProducto()); 
		return "listadoproductos";  
	}
    /*
	@GetMapping("/listarProductos")
	@ResponseBody
	@Operation(summary = "Listar productos", description = "Obtener listado de productos")
	public ResponseEntity<List<Producto>> listaProducto() {
		List<Producto> lista = service.listaProducto();
		return ResponseEntity.ok(lista);
	}*/
	
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
			@Parameter(name = "descripcion", description = "Descripcion del parametro")
			@RequestParam(value = "desc_product", required = false) String desc_product,
			@Parameter(name = "stock", description = "Cantidad del producto que ingresa")
			@RequestParam(value = "stock", required = false) int stock,
			@Parameter(name = "precio", description = "Precio unitario del producto")
			@RequestParam(value = "pre_uni", required = false) double pre_uni,
			@Parameter(name = "id de la categoria", description = "Ingresa el id de la categoria")
			@RequestParam(value = "id_categoria", required = false) int id_categoria
			){
		
		Map<String, Object> salida = new HashMap<String, Object>();
		
		try {
			
			Producto p = new Producto();
			p.setDesc_product(desc_product);
			p.setStock(stock);
			p.setPre_uni(pre_uni);
			p.setId_categoria(id_categoria);
						
			Producto objProducto = service.insertaProducto(p);
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
			Producto obj = service.obtenerProducto(pord.getId_producto());
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
