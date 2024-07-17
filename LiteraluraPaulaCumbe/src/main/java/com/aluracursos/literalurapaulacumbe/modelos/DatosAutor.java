package com.aluracursos.literalurapaulacumbe.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Embeddable;

@Embeddable
@JsonIgnoreProperties(ignoreUnknown = true)
public class DatosAutor {

    @JsonAlias("name")
    private String nombre;

    @JsonAlias("birth_year")
    private String fechaDeNacimiento;

    @JsonAlias("death_year")
    private String fechaDeFallecimiento;

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getFechaDeFallecimiento() {
        return fechaDeFallecimiento;
    }

    public void setFechaDeFallecimiento(String fechaDeFallecimiento) {
        this.fechaDeFallecimiento = fechaDeFallecimiento;
    }
}
