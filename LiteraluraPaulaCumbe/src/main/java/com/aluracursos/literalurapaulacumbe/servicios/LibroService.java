package com.aluracursos.literalurapaulacumbe.servicios;
import com.aluracursos.literalurapaulacumbe.modelos.DatosLibros;
import com.aluracursos.literalurapaulacumbe.repositorio.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibroService {

    @Autowired
    private LibroRepositorio libroRepository;

    public DatosLibros guardarLibro(DatosLibros libro) {
        libroRepository.save(libro);
        return libro;
    }

    public boolean existeLibroConTitulo(String titulo) {
        return libroRepository.existsByTitulo(titulo);
    }

    public List<DatosLibros> obtenerTodosLosLibros() {
        return libroRepository.findAll();
    }

    public Optional<DatosLibros> buscarPorTitulo(String titulo) {
        return libroRepository.findByTitulo(titulo);
    }

    public List<String> obtenerLibrosPorAutor(String nombreAutor) {
        return libroRepository.findAll().stream()
                .filter(libro -> libro.getAutor().stream()
                        .anyMatch(autor -> autor.getNombre().equalsIgnoreCase(nombreAutor)))
                .map(DatosLibros::getTitulo)
                .collect(Collectors.toList());
    }

    public List<DatosLibros> obtenerTop10Libros() {
        return libroRepository.findAll().stream()
                .sorted((libro1, libro2) -> Integer.compare(libro2.getNumeroDeDescargas(), libro1.getNumeroDeDescargas()))
                .limit(10)
                .collect(Collectors.toList());
    }
}



