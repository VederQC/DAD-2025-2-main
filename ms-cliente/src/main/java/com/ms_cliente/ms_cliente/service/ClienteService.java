package com.ms_cliente.ms_cliente.service;

import com.ms_cliente.ms_cliente.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> listar();
    Optional<Cliente> buscarPorId(Integer Id);
    Cliente guardar(Cliente cliente);
    Cliente actualizar(Cliente cliente);
    void borrarPorId(Integer id);


}
