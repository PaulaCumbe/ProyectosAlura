package com.aluracursos.literalurapaulacumbe.principal;
import com.aluracursos.literalurapaulacumbe.modelos.Datos;
import com.aluracursos.literalurapaulacumbe.modelos.DatosAutor;
import com.aluracursos.literalurapaulacumbe.modelos.DatosLibros;
import com.aluracursos.literalurapaulacumbe.servicios.ConsumoAPI;
import com.aluracursos.literalurapaulacumbe.servicios.ConvierteDatos;
import com.aluracursos.literalurapaulacumbe.servicios.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class PrincipalMenu {

    @Autowired
    private ConsumoAPI consumoAPI;

    @Autowired
    private ConvierteDatos conversor;

    @Autowired
    private LibroService libroService;

    private final Scanner teclado = new Scanner(System.in);

    public void mostrarMenu() {
        while (true) {
            System.out.println("""

                    Bienvenido a LiterAlura!
                    A continuación escriba el número correspondiente
                    a la opción que desea escoger:
                    """);

            System.out.println("0. Top 10 libros más recomendados");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Lista de libros registrados");
            System.out.println("3. Lista de autores por libro");
            System.out.println("4. Lista de autores vivos en un año determinado");
            System.out.println("5. Lista de libros por idioma");
            System.out.println("6. Salir de la aplicación");
            int opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 0:
                    mostrarTop10Libros();
                    break;
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    listarLibrosRegistrados();
                    break;
                case 3:
                    listarAutoresPorLibro();
                    break;
                case 4:
                    listarAutoresVivosEnAno();
                    break;
                case 5:
                    listarLibrosPorIdioma();
                    break;
                case 6:
                    System.out.println("Saliendo de la plataforma... Gracias por utilizar LiterAlura");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void mostrarTop10Libros() {
        System.out.println("Top 10 libros más descargados:");
        List<DatosLibros> top10Libros = libroService.obtenerTop10Libros();
        top10Libros.stream()
                .sorted(Comparator.comparingInt(DatosLibros::getNumeroDeDescargas).reversed())
                .limit(10)
                .forEach(this::imprimirLibro);
    }

    private void buscarLibroPorTitulo() {
        System.out.println("Ingrese el nombre del libro que desea buscar:");
        String titulo = teclado.nextLine();
        String json = consumoAPI.obtenerDatos("?search=" + titulo.replace(" ", "+"));
        Datos datos = conversor.obtenerDatos(json, Datos.class);
        if (datos.resultados().isEmpty()) {
            System.out.println("Libro no encontrado");
        } else {
            DatosLibros libro = datos.resultados().get(0);
            imprimirLibro(libro);
            if (!libroService.existeLibroConTitulo(libro.getTitulo())) {
                libroService.guardarLibro(libro);
                System.out.println("Libro registrado automáticamente.");
            } else {
                System.out.println("El libro ya está registrado.");
            }
        }
    }

    private void listarLibrosRegistrados() {
        System.out.println("Libros registrados:");
        libroService.obtenerTodosLosLibros().forEach(this::imprimirLibro);
    }

    private void listarAutoresPorLibro() {
        System.out.println("Ingrese el título del libro:");
        String titulo = teclado.nextLine();
        Optional<DatosLibros> libro = libroService.buscarPorTitulo(titulo);
        if (libro.isPresent()) {
            libro.get().getAutor().stream()
                    .sorted(Comparator.comparing(DatosAutor::getNombre))
                    .forEach(this::imprimirAutor);
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    private void listarAutoresVivosEnAno() {
        System.out.println("Ingrese el año:");
        String ano = teclado.nextLine();
        libroService.obtenerTodosLosLibros().stream()
                .flatMap(libro -> libro.getAutor().stream())
                .filter(autor -> autor.getFechaDeNacimiento() != null && autor.getFechaDeNacimiento().equals(ano))
                .forEach(this::imprimirAutor);
    }

    private void listarLibrosPorIdioma() {
        System.out.println("Ingrese el idioma para buscar los libros:");
        System.out.println("es - Español");
        System.out.println("en - Inglés");
        System.out.println("fr - Francés");
        System.out.println("pt - Portugués");
        String idioma = teclado.nextLine();
        libroService.obtenerTodosLosLibros().stream()
                .filter(libro -> libro.getIdiomas().contains(idioma))
                .forEach(this::imprimirLibro);
    }

    private void imprimirLibro(DatosLibros libro) {
        System.out.println("------ LIBRO -----");
        System.out.println("Título: " + libro.getTitulo());
        libro.getAutor().forEach(autor ->
                System.out.println("Autor: " + autor.getNombre()));
        System.out.println("Idioma: " + libro.getIdiomas().stream().findFirst().orElse("Desconocido"));
        System.out.println("Número de descargas: " + libro.getNumeroDeDescargas());
        System.out.println("--------------------------");
    }

    private void imprimirAutor(DatosAutor autor) {
        System.out.println("------ AUTOR -----");
        System.out.println("Autor: " + autor.getNombre());
        System.out.println("Fecha de nacimiento: " + autor.getFechaDeNacimiento());
        System.out.println("Fecha de fallecimiento: " + autor.getFechaDeFallecimiento());

        System.out.println("Libros: " + libroService.obtenerLibrosPorAutor(autor.getNombre()));
        System.out.println("--------------------------");
    }

}