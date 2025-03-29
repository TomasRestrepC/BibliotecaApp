package autonoma.biblioteca.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Clase que representa una Biblioteca con una colección de libros.
 */
public class Biblioteca {

    private ArrayList<Libro> libros; // Lista de libros en la biblioteca

    /**
     * Constructor que inicializa la biblioteca con una lista vacía de libros.
     */
    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    /**
     * Agrega un libro a la biblioteca si no existe un libro con el mismo ID.
     * @param libro El libro a agregar.
     * @return true si el libro se agregó, false si el ID ya existe.
     */
    public boolean agregarLibro(Libro libro) {
        for (Libro l : libros) {
            if (l.getId() == libro.getId()) {
                return false; // Ya existe un libro con ese ID
            }
        }
        libros.add(libro);
        return true;
    }

    /**
     * Elimina un libro de la biblioteca por su ID.
     * @param id ID del libro a eliminar.
     * @return true si el libro fue eliminado, false si no se encontró.
     */
    public boolean eliminarLibro(long id) {
        return libros.removeIf(libro -> libro.getId() == id);
    }

    /**
     * Busca un libro por su ID.
     * @param id ID del libro a buscar.
     * @return El libro encontrado o null si no existe.
     */
    public Libro buscarLibro(long id) {
        for (Libro libro : libros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    /**
     * Actualiza la información de un libro existente.
     * @param id ID del libro a actualizar.
     * @param nuevoLibro Nueva información del libro.
     * @return true si se actualizó, false si no se encontró el libro.
     */
    public boolean actualizarLibro(long id, Libro nuevoLibro) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId() == id) {
                libros.set(i, nuevoLibro);
                return true;
            }
        }
        return false;
    }

    /**
     * Obtiene la lista de libros en la biblioteca.
     * @return Lista de libros.
     */
    public ArrayList<Libro> obtenerLibros() {
        return libros;
    }

    /**
     * Ordena los libros alfabéticamente por título.
     */
    public void ordenarLibrosAlfabeticamente() {
        Collections.sort(libros, Comparator.comparing(Libro::getTitulo));
    }

    /**
     * Muestra todos los libros en la biblioteca.
     * @return Cadena con la lista de libros o un mensaje si está vacía.
     */
    public String mostrarLibros() {
        if (libros.isEmpty()) {
            return "No hay libros en la biblioteca.";
        }
        StringBuilder sb = new StringBuilder();
        for (Libro libro : libros) {
            sb.append("ID: ").append(libro.getId()).append(", Título: ").append(libro.getTitulo()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Verifica si la biblioteca está vacía.
     * @return true si no hay libros, false en caso contrario.
     */
    public boolean estaVacia() {
        return libros.isEmpty();
    }
}
