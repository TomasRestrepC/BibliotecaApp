package autonoma.biblioteca.models;

/**
 * Clase que representa un Libro en la biblioteca.
 */
public class Libro {

    private long id; // Identificador único del libro
    private String titulo; // Título del libro

    /**
     * Constructor para inicializar un libro con su ID y título.
     * @param id Identificador único del libro.
     * @param titulo Título del libro.
     */
    public Libro(long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    /**
     * Obtiene el ID del libro.
     * @return ID del libro.
     */
    public long getId() {
        return id;
    }

    /**
     * Establece un nuevo ID para el libro.
     * @param id Nuevo ID del libro.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Obtiene el título del libro.
     * @return Título del libro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece un nuevo título para el libro.
     * @param titulo Nuevo título del libro.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
