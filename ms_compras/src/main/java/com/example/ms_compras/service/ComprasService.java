package com.example.ms_compras.service;

import com.example.ms_compras.entity.Compras;

import java.util.List;
import java.util.Optional;

public interface ComprasService {

    Compras guardarCompra(Compras compra);

    List<Compras> listarCompras();

    Optional<Compras> obtenerCompraPorId(Long id);

    Compras actualizarCompra(Long id, Compras compra);

    void eliminarCompra(Long id);
}
