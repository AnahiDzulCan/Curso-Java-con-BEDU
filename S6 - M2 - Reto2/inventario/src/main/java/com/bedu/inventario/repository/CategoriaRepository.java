package com.bedu.inventario.repository;

import com.bedu.inventario.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository  extends JpaRepository<Categoria, Long> {
    List<Categoria> findByNombreContaining(String nombre);

}
