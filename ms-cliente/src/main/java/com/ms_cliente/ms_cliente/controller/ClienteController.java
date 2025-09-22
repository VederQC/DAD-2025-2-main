package com.ms_cliente.ms_cliente.controller;

import com.ms_cliente.ms_cliente.dto.ClienteDto;
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
    ClienteService clienteService;

    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listar();
    }

    @GetMapping("/{id}")
    public ClienteDto buscarPorId(@PathVariable Integer id) {
        return clienteService.buscarPorId(id);
    }

    @PostMapping
    public Cliente guardar(@RequestBody Cliente cliente) {
        return clienteService.guardar(cliente);
    }

    @PutMapping
    public Cliente actualizar(@RequestBody Cliente cliente) {

        return clienteService.actualizar(cliente);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {
        clienteService.borrarPorId(id);
        return "Categoria eliminada";
    }
}
