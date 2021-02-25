package com.breinercorrea.crud.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.breinercorrea.crud.app.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

	Optional<Producto> findByNombre(String nombre);
    boolean existsByNombre(String nombre);

}
