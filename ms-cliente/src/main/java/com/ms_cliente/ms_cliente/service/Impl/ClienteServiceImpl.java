package com.ms_cliente.ms_cliente.service.Impl;

import com.ms_cliente.ms_cliente.dto.CategoriaDto;
import com.ms_cliente.ms_cliente.dto.ClienteDto;
import com.ms_cliente.ms_cliente.entity.Cliente;
import com.ms_cliente.ms_cliente.feign.CatalogoFeign;
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
    @Autowired
    private CatalogoFeign catalogoFeign;
    @Override
    public List<Cliente> listar(){return clienteRepository.findAll();}
    @Override
    public ClienteDto buscarPorId(Integer id){
        Cliente cliente = clienteRepository.findById(id).get();
        CategoriaDto categoriaDto = catalogoFeign.buscarPorId(cliente.getIdcategoria());
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setId(cliente.getId());
        clienteDto.setNombre(cliente.getNombre());
        clienteDto.setApellido(cliente.getApellido());
        clienteDto.setCategoria(categoriaDto);
        return clienteDto;
    }
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
