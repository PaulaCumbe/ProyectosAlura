package com.example.aluracursos.foro.forohubpau.datos;

import com.example.aluracursos.foro.forohubpau.modelos.NombreCurso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTop(@NotBlank
                               String titulo,
                               @NotBlank
                               String mensaje,
                               @NotNull @Valid
                               NombreCurso curso) {
}

