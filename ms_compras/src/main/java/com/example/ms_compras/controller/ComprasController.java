package com.example.ms_compras.controller;

import com.example.ms_compras.entity.Compras;
import com.example.ms_compras.service.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class ComprasController {
    @Autowired
    private ComprasService compraService;

    // Crear una nueva compra
    @PostMapping
    public Compras crearCompra(@RequestBody Compras compra) {
        return compraService.guardarCompra(compra);
    }

    // Listar todas las compras
    @GetMapping
    public List<Compras> obtenerCompras() {
        return compraService.listarCompras();
    }

    // Obtener compra por ID
    @GetMapping("/{id}")
    public ResponseEntity<Compras> obtenerCompra(@PathVariable Long id) {
        return compraService.obtenerCompraPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar compra por ID
    @PutMapping("/{id}")
    public Compras actualizarCompra(@PathVariable Long id, @RequestBody Compras compra) {
        return compraService.actualizarCompra(id, compra);
    }

    // Eliminar compra por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCompra(@PathVariable Long id) {
        compraService.eliminarCompra(id);
        return ResponseEntity.noContent().build();
    }
}
