package com.example.ms_compras.service.impl;

import com.example.ms_compras.entity.Compras;
import com.example.ms_compras.repository.ComprasRepository;
import com.example.ms_compras.service.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComprasServiceImpl implements ComprasService {
    @Autowired
    private ComprasRepository compraRepository;

    @Override
    public Compras guardarCompra(Compras compra) {
        return compraRepository.save(compra);
    }

    @Override
    public List<Compras> listarCompras() {
        return compraRepository.findAll();
    }

    @Override
    public Optional<Compras> obtenerCompraPorId(Long id) {
        return compraRepository.findById(id);
    }

    @Override
    public Compras actualizarCompra(Long id, Compras compra) {
        return compraRepository.findById(id).map(c -> {
            c.setNombreProducto(compra.getNombreProducto());
            c.setDescripcion(compra.getDescripcion());
            return compraRepository.save(c);
        }).orElseThrow(() -> new RuntimeException("Compra no encontrada con id: " + id));
    }

    @Override
    public void eliminarCompra(Long id) {
        compraRepository.deleteById(id);
    }
}
