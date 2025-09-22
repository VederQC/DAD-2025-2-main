package com.ms_cliente.ms_cliente.feign;

import com.ms_cliente.ms_cliente.dto.CategoriaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "ms-catalogo", path = "/categoria")
public interface CatalogoFeign {
    @GetMapping("/{id}")
    public CategoriaDto buscarPorId(@PathVariable Integer id);
}
