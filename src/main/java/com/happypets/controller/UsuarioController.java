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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.happypets.entity.Usuario;
import com.happypets.service.UsuarioService;
import com.happypets.util.Constantes;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;

@RestController
@RequestMapping(path="/rest/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    // endpoint: http://localhost:8090/usuario/cargar
    @GetMapping("/cargarUsuario")
    public String cargarPag(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }
    
    /*@PostMapping("/validar")
    public String grabarPag(@ModelAttribute Usuario usuario, Model model) {
        System.out.println(usuario);
        //validar
        Usuario u = service.findByCorreoAndClave(usuario.getCorreo(), usuario.getClave());
        System.out.println(u);
        if(u==null) {
            model.addAttribute("usuario" , new Usuario());
            model.addAttribute("mensaje" , "usuario clave incorrecto");
            return "login";
        }else {
            model.addAttribute("lstProductos", repo.findAll());
            model.addAttribute("lstCategorias", repoc.findAll());
            model.addAttribute("lstEstado", repe.findAll());
             model.getAttribute("usuario");
                if(u.getIdtipo()==1) {

                    return "administrador";
                }
                else {

                    return "principal";
                }
        }
    }*/

    // url: http://localhost:9090/web/inicio
/*    @GetMapping("/inicio")
    public String pagPrincipal(Model model) {
        model.addAttribute("usuarios", service.findByUser(null));
        return "principal";
    }

    @GetMapping("/listarUsuarios")
    @ResponseBody
    public ResponseEntity<List<Usuario>> listaUsuario() {
        List<Usuario> lista = service.listaUsuario();
        return ResponseEntity.ok(lista);
    }
*/
    @PostMapping("/agregarUsuario")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> insertaUsuario(@RequestBody Usuario usu) {

        Map<String, Object> salida = new HashMap<String, Object>();

        try {

            Usuario objUsuario = service.insertaUsuario(usu);
            if (objUsuario == null) {
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

    @PutMapping("/actualizarUsuario")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizarUsuario(@RequestBody Usuario usu) {

        Map<String, Object> salida = new HashMap<String, Object>();

        try {
            Usuario obj = service.obtenerUsuario(usu.getUser());
            if (obj == null) {
                salida.put("mensaje", "El usuario no existe");
                return ResponseEntity.ok(salida);
            }
            Usuario objUsuario = service.actualizaUsuario(usu);
            if (objUsuario == null) {
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


    @GetMapping("/agregar")
    public String agregar(Usuario usuario) {

        return "registrarUsuario";

    }
/*
    @PostMapping("/guardar")
    public String guardar(@Validated Usuario usuario, Errors errores) {

        if (errores.hasErrors()) {
            return "actualizarUsuario";
        }

        service.guardarUsuario(usuario);

        return "redirect:/";

    }
*/
    /*@GetMapping("/editar/{idPersona}")
    public String editar(Usuario usuario, Model model) {
        usuario = service.obtenerUsuario(usuario);

        model.addAttribute("persona", persona);

        return "modificar";

    }

    @GetMapping("/eliminar/{idPersona}")
    public String eliminar(Usuario usuario) {

        service.eliminar(usuario);
        return "redirect:/";

    }*/
}
