package autonoma.biblioteca.models;

/**
 * Clase que representa a una Persona con atributos básicos.
 */
public class Persona {
    
    private String nombre; // Nombre de la persona
    private String documentoIdentidad; // Documento de identidad
    private String correoElectronico; // Correo electrónico

    /**
     * Constructor que inicializa una persona con sus datos básicos.
     * @param nombre Nombre de la persona.
     * @param documentoIdentidad Documento de identidad de la persona.
     * @param correoElectronico Correo electrónico de la persona.
     */
    public Persona(String nombre, String documentoIdentidad, String correoElectronico) {
        this.nombre = nombre;
        this.documentoIdentidad = documentoIdentidad;
        this.correoElectronico = correoElectronico;
    }

    /**
     * Obtiene el nombre de la persona.
     * @return Nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece un nuevo nombre para la persona.
     * @param nombre Nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el documento de identidad de la persona.
     * @return Documento de identidad.
     */
    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    /**
     * Establece un nuevo documento de identidad.
     * @param documentoIdentidad Nuevo documento de identidad.
     */
    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    /**
     * Obtiene el correo electrónico de la persona.
     * @return Correo electrónico.
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Establece un nuevo correo electrónico.
     * @param correoElectronico Nuevo correo electrónico.
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
