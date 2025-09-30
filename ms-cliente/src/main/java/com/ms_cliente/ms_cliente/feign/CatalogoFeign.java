package com.ms_cliente.ms_cliente.feign;

import com.ms_cliente.ms_cliente.dto.CategoriaDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "ms-catalogo", path = "/categoria")
public interface CatalogoFeign {
    @GetMapping("/{id}")
    @CircuitBreaker(name = "categoriaListarPorIdCB", fallbackMethod = "fallbackCategoria")
    public CategoriaDto buscarPorId(@PathVariable Integer id);

    default CategoriaDto fallbackCategoria(Integer id, Exception e) {
        CategoriaDto categoriaDto = new CategoriaDto();
        categoriaDto.setId(9000000);
        categoriaDto.setNombre("SERVICIO NO DISPONIBLE");
        return categoriaDto;
    }
}
