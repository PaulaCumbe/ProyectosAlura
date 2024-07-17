package com.example.aluracursos.foro.forohubpau.datos;

import com.example.aluracursos.foro.forohubpau.modelos.NombreCurso;
import com.example.aluracursos.foro.forohubpau.modelos.Topicos;

import java.time.LocalDateTime;

public record DatosTop(String titulo, String mensaje, LocalDateTime fechaElaborado, NombreCurso curso) {
    public DatosTop(Topicos topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getNombreCurso());
    }
}
