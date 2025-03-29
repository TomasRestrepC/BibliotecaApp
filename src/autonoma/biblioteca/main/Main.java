package autonoma.biblioteca.main;

import autonoma.biblioteca.views.BibliotecaGUI;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Ejecuta la interfaz gráfica en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> new BibliotecaGUI());
    }
}
