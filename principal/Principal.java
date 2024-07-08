package com.aluracursos.desafio.principal;

import com.aluracursos.desafio.model.Datos;
import com.aluracursos.desafio.model.DatosAutor;
import com.aluracursos.desafio.model.DatosLibros;
import com.aluracursos.desafio.service.ConsumoAPI;
import com.aluracursos.desafio.service.ConvierteDatos;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private Scanner teclado = new Scanner(System.in);

    // Lista para almacenar los libros buscados
    private List<DatosLibros> librosBuscados = new ArrayList<>();

    public void mostrarMenuInteractivo() {
        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Búsqueda de libro por título");
            System.out.println("2. Listar libros registrados");
            System.out.println("3. Listar autores registrados");
            System.out.println("4. Listar autores vivos en un determinado año de los libros registrados");
            System.out.println("5. Listar libros por idiomas");
            System.out.println("0. Salir");

            int opcion = obtenerOpcionValida();

            switch (opcion) {
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    listarLibrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivosEnAno();
                    break;
                case 5:
                    listarLibrosPorIdiomas();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione nuevamente.");
            }
        }
    }

    private int obtenerOpcionValida() {
        while (true) {
            try {
                System.out.print("Ingrese su opción: ");
                int opcion = Integer.parseInt(teclado.nextLine());
                if (opcion < 0 || opcion > 5) {
                    System.out.println("Opción inválida. Por favor, ingrese un número entre 0 y 5.");
                } else {
                    return opcion;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
            }
        }
    }

    private void buscarLibroPorTitulo() {
        System.out.println("Ingrese el nombre del libro que desea buscar:");
        var tituloLibro = teclado.nextLine().trim().toLowerCase();

        // Verificar si el título ya está registrado
        boolean tituloYaRegistrado = librosBuscados.stream()
                .anyMatch(libro -> libro.titulo().toLowerCase().equals(tituloLibro));

        if (tituloYaRegistrado) {
            System.out.println("El título ya se encuentra registrado en la base de datos.");
            return;
        }

        var json = consumoAPI.obtenerDatos(URL_BASE + "?search=" + tituloLibro.replace(" ", "+"));
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);
        var librosEncontrados = datosBusqueda.resultados();

        if (librosEncontrados.isEmpty()) {
            System.out.println("No se encontraron libros con ese título.");
        } else {
            // Seleccionar el primer libro encontrado
            DatosLibros libro = librosEncontrados.get(0);
            librosBuscados.add(libro);
            System.out.println("\nTítulo: " + libro.titulo());
            System.out.println("Autor: " + libro.autor().stream().map(DatosAutor::nombre).collect(Collectors.joining(", ")));
            System.out.println("Idiomas: " + String.join(", ", libro.idiomas()));
            System.out.println("Número de Descargas: " + libro.numeroDeDescargas());
        }
    }

    private void listarLibrosRegistrados() {
        if (librosBuscados.isEmpty()) {
            System.out.println("No hay libros registrados en la búsqueda actual.");
            return;
        }

        System.out.println("Libros registrados:");
        for (DatosLibros libro : librosBuscados) {
            System.out.println("\nTítulo: " + libro.titulo());
            System.out.println("Autor: " + libro.autor().stream().map(DatosAutor::nombre).collect(Collectors.joining(", ")));
            System.out.println("Idiomas: " + String.join(", ", libro.idiomas()));
            System.out.println("Número de Descargas: " + libro.numeroDeDescargas());
        }
    }

    private void listarAutoresRegistrados() {
        if (librosBuscados.isEmpty()) {
            System.out.println("No hay libros registrados en la búsqueda actual.");
            return;
        }

        System.out.println("Autores registrados:");
        librosBuscados.stream()
                .flatMap(libro -> libro.autor().stream())
                .distinct()
                .forEach(autor -> System.out.println(autor.nombre()));
    }

    private void listarAutoresVivosEnAno() {
        System.out.println("Ingrese el año para listar los autores vivos en ese año:");
        int ano = obtenerAnoValido();

        if (librosBuscados.isEmpty()) {
            System.out.println("No hay libros registrados en la búsqueda actual.");
            return;
        }

        System.out.println("Autores vivos en el año " + ano + ":");
        librosBuscados.stream()
                .flatMap(libro -> libro.autor().stream())
                .filter(autor -> {
                    try {
                        int anoNacimiento = Integer.parseInt(autor.fechaDeNacimiento());
                        return anoNacimiento <= ano;
                    } catch (NumberFormatException e) {
                        return false;
                    }
                })
                .distinct()
                .forEach(autor -> System.out.println(autor.nombre()));
    }

    private int obtenerAnoValido() {
        while (true) {
            try {
                System.out.print("Ingrese el año: ");
                return Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
            }
        }
    }

    private void listarLibrosPorIdiomas() {
        if (librosBuscados.isEmpty()) {
            System.out.println("No hay libros registrados en la búsqueda actual.");
            return;
        }

        System.out.println("Libros por idioma:");
        Map<String, List<DatosLibros>> librosPorIdioma = librosBuscados.stream()
                .collect(Collectors.groupingBy(libro -> libro.idiomas().get(0)));

        librosPorIdioma.forEach((idioma, libros) -> {
            System.out.println(idioma + ": " + libros.size() + " libros");
            libros.forEach(libro -> System.out.println("  Título: " + libro.titulo()));
        });
    }
}
