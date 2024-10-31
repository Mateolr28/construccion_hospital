package com.hospital.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.hospital.entity.Cliente;
import com.hospital.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.obtenerTodosLosClientes());
        return "clientes";
    }

    @PostMapping("/guardar")
    public String guardarCliente(Cliente cliente) {
        clienteService.guardarCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/editar/{id}")
public String editarCliente(@PathVariable Long id, Model model) {
    Optional<Cliente> clienteOpt = clienteService.buscarClientePorId(id);
    if (clienteOpt.isPresent()) {
        model.addAttribute("cliente", clienteOpt.get());
        return "editar_clientes"; // Asegúrate de que esta vista existe
    } else {
        return "redirect:/clientes"; // Redirigir si el cliente no se encuentra
    }
}

    @PostMapping("/actualizar")
    public String actualizarCliente(Cliente cliente) {
        clienteService.guardarCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
        return "redirect:/clientes";
    }
}