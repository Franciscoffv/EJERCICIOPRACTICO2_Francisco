/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioII.Francisco.controller;

import EjercicioII.Francisco.domain.Pelicula;
import EjercicioII.Francisco.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import EjercicioII.Francisco.service.PeliculaService;

/**
 *
 * @author Francisco
 */
@Controller
@RequestMapping("/Pelicula")
public class PeliculaController {
  
    @Autowired
    private PeliculaService peliculaService;
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/listado")
    private String listado(Model model) {
        var peliculas = peliculaService.getPelicula(false);
        model.addAttribute("peliculas", peliculas);
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalPeliculas",peliculas.size());
        return "/pelicula/listado";
    }
    
     @GetMapping("/nuevo")
    public String peliculaNuevo(Pelicula pelicula) {
        return "/pelicula/modifica";
    }
    
    @PostMapping("/guardar")
    public String peliculaGuardar(Pelicula pelicula) {        
        peliculaService.save(pelicula);
        return "redirect:/pelicula/listado";
    }

    @GetMapping("/eliminar/{idPelicula}")
    public String peliculaEliminar(Pelicula pelicula) {
        peliculaService.delete(pelicula);
        return "redirect:/pelicula/listado";
    }

    @GetMapping("/modificar/{idPelicula}")
    public String peliculaModificar(Pelicula pelicula, Model model) {
        pelicula = peliculaService.getPelicula(pelicula);
        model.addAttribute("pelicula", pelicula);
        
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        
        return "/pelicula/modifica";
    }   
}

