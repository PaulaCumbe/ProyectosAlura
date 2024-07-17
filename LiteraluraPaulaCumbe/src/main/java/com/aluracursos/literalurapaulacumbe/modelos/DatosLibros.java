package com.aluracursos.literalurapaulacumbe.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class DatosLibros {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @JsonAlias("title")
        private String titulo;

        @JsonAlias("authors")
        @ElementCollection
        private List<DatosAutor> autor;

        @JsonAlias("languages")
        @ElementCollection
        private List<String> idiomas;

        @JsonAlias("download_count")
        private int numeroDeDescargas;

        public DatosLibros() {
        }

        public DatosLibros(String titulo, List<DatosAutor> autor, List<String> idiomas, int numeroDeDescargas) {
                this.titulo = titulo;
                this.autor = autor;
                this.idiomas = idiomas;
                this.numeroDeDescargas = numeroDeDescargas;
        }

        // Getters y setters
        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getTitulo() {
                return titulo;
        }

        public void setTitulo(String titulo) {
                this.titulo = titulo;
        }

        public List<DatosAutor> getAutor() {
                return autor;
        }

        public void setAutor(List<DatosAutor> autor) {
                this.autor = autor;
        }

        public List<String> getIdiomas() {
                return idiomas;
        }

        public void setIdiomas(List<String> idiomas) {
                this.idiomas = idiomas;
        }

        public int getNumeroDeDescargas() {
                return numeroDeDescargas;
        }

        public void setNumeroDeDescargas(int numeroDeDescargas) {
                this.numeroDeDescargas = numeroDeDescargas;
        }
}
