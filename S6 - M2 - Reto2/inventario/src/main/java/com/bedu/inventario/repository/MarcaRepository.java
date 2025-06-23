package com.bedu.inventario.repository;

import com.bedu.inventario.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
    List<Marca> findByNombreContaining(String nombre);
}
