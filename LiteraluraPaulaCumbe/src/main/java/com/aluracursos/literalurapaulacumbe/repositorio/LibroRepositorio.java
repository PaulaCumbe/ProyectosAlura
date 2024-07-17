package com.aluracursos.literalurapaulacumbe.repositorio;
import com.aluracursos.literalurapaulacumbe.modelos.DatosLibros;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibroRepositorio extends JpaRepository<DatosLibros, Long> {
    Optional<DatosLibros> findByTitulo(String titulo);

    boolean existsByTitulo(String titulo);
}

