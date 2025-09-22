package com.ms_cliente.ms_cliente.service;

import com.ms_cliente.ms_cliente.dto.ClienteDto;
import com.ms_cliente.ms_cliente.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> listar();
    ClienteDto buscarPorId(Integer id);
    Cliente guardar(Cliente cliente);
    Cliente actualizar(Cliente cliente);
    void borrarPorId(Integer id);


}
