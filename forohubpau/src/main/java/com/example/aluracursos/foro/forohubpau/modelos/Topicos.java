package com.example.aluracursos.foro.forohubpau.modelos;

import com.example.aluracursos.foro.forohubpau.datos.DatosRegistroTop;
import com.example.aluracursos.foro.forohubpau.datos.DatoscheckTop;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
public class Topicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private NombreCurso curso;

    public Topicos() {
    }

    public Topicos(DatosRegistroTop datosRegistroTop) {
        this.titulo = datosRegistroTop.titulo();
        this.mensaje = datosRegistroTop.mensaje();
        this.curso = datosRegistroTop.curso();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public NombreCurso getCurso() {
        return curso;
    }

    public void actualizarInformacion(DatoscheckTop datoscheckTop) {
        if (datoscheckTop.titulo() != null) {
            this.titulo = datoscheckTop.titulo();
        }
        if (datoscheckTop.mensaje() != null) {
            this.mensaje = datoscheckTop.mensaje();
        }
    }
}
