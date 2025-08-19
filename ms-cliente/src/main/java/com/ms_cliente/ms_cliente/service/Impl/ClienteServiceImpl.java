package com.ms_cliente.ms_cliente.service.Impl;

import com.ms_cliente.ms_cliente.entity.Cliente;
import com.ms_cliente.ms_cliente.repository.ClienteRepository;
import com.ms_cliente.ms_cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public List<Cliente> listar(){return clienteRepository.findAll();}
    @Override
    public Optional<Cliente> buscarPorId(Integer id){return clienteRepository.findById(id);}
    @Override
    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente actualizar(Cliente categoria) {
        return clienteRepository.save(categoria);
    }

    @Override
    public void borrarPorId(Integer id) {
        clienteRepository.deleteById(id);
    }

}
