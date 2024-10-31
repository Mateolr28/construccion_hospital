package com.hospital.controller;

import com.hospital.entity.Articulo;
import com.hospital.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/articulos")
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @GetMapping
    public String listarArticulos(Model model) {
        model.addAttribute("articulos", articuloService.obtenerTodosLosArticulos());
        return "articulos";
    }

    @PostMapping("/guardar")
    public String guardarArticulo(Articulo articulo) {
        articuloService.guardarArticulo(articulo);
        return "redirect:/articulos";
    }

    @GetMapping("/editar/{id}")
    public String editarArticulo(@PathVariable Long id, Model model) {
        model.addAttribute("articulo", articuloService.buscarArticuloPorId(id).orElse(new Articulo()));
        return "editar_articulo";
    }

    @PostMapping("/actualizar")
    public String actualizarArticulo(Articulo articulo) {
        articuloService.guardarArticulo(articulo);
        return "redirect:/articulos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarArticulo(@PathVariable Long id) {
        articuloService.eliminarArticulo(id);
        return "redirect:/articulos";
    }
}