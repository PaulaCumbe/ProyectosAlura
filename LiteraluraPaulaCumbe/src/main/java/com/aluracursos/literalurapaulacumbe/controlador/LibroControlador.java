package com.aluracursos.literalurapaulacumbe.controlador;
import com.aluracursos.literalurapaulacumbe.modelos.DatosLibros;
import com.aluracursos.literalurapaulacumbe.servicios.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libros")
public class LibroControlador {

    @Autowired
    private LibroService libroService;

    @GetMapping("/buscar")
    public Optional<DatosLibros> buscarLibroPorTitulo(@RequestParam String titulo) {
        return libroService.buscarPorTitulo(titulo);
    }

    @GetMapping("/todos")
    public List<DatosLibros> obtenerTodosLosLibros() {
        return libroService.obtenerTodosLosLibros();
    }

    @PostMapping("/guardar")
    public DatosLibros guardarLibro(@RequestBody DatosLibros libro) {
        if (libroService.existeLibroConTitulo(libro.getTitulo())) {
            throw new IllegalArgumentException("El libro ya está registrado.");
        }
        return libroService.guardarLibro(libro);
    }
}

