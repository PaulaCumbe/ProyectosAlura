package com.example.aluracursos.foro.forohubpau.datos;
import com.example.aluracursos.foro.forohubpau.modelos.NombreCurso;
import com.example.aluracursos.foro.forohubpau.modelos.Topicos;

public record DatosListaTop(Long id, String titulo, String mensaje, NombreCurso curso) {
    public DatosListaTop(Topicos topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getCurso());
    }
}
