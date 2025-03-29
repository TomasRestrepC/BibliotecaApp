package autonoma.biblioteca.models;

/**
 * Clase que representa un Autor, que hereda de Persona.
 */
public class Autor extends Persona {
    
    private String editorial; // Editorial a la que pertenece el autor
    private String profesion; // Profesión del autor

    /**
     * Constructor que inicializa un Autor sin información de editorial y profesión.
     */
    public Autor(String nombre, String documentoIdentidad, String correoElectronico) {
        super(nombre, documentoIdentidad, correoElectronico);
    }

    /**
     * Constructor que inicializa un Autor con todos sus atributos.
     */
    public Autor(String editorial, String profesion, String nombre, String documentoIdentidad, String correoElectronico) {
        super(nombre, documentoIdentidad, correoElectronico);
        this.editorial = editorial;
        this.profesion = profesion;
    }

    // Métodos getter y setter
    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
}
