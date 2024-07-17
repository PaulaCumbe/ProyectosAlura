package com.example.aluracursos.foro.forohubpau.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "cursos")
public class NombreCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String categoria;

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }
}
