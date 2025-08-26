package com.example.ms_compras.repository;

import com.example.ms_compras.entity.Compras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprasRepository extends JpaRepository <Compras, Long> {
}
