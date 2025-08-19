package com.ms_cliente.ms_cliente.controller;

import com.ms_cliente.ms_cliente.entity.Cliente;
import com.ms_cliente.ms_cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService categoriaService;

    @GetMapping
    public List<Cliente> listar() {
        return categoriaService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> buscarPorId(@PathVariable Integer id) {
        return categoriaService.buscarPorId(id);
    }

    @PostMapping
    public Cliente guardar(Cliente categoria) {
        return categoriaService.guardar(categoria);
    }

    @PutMapping
    public Cliente actualizar(Cliente categoria) {
        return categoriaService.actualizar(categoria);
    }

    @DeleteMapping
    public String eliminar(@PathVariable Integer id) {
        categoriaService.borrarPorId(id);
        return "Categoria eliminada";
    }
}
