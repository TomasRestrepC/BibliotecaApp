package autonoma.biblioteca.views;

import autonoma.biblioteca.models.Biblioteca;
import autonoma.biblioteca.models.Libro;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BibliotecaGUI extends JFrame {

    private Biblioteca biblioteca = new Biblioteca();

    // Campos de entrada
    private JTextField idField = new JTextField();
    private JTextField tituloField = new JTextField();
    private JTextArea displayArea = new JTextArea();

    public BibliotecaGUI() {
        setTitle("Biblioteca");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(210, 180, 140)); // Fondo café claro

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2, 10, 10));
        inputPanel.setBackground(new Color(210, 180, 140));

        JLabel idLabel = new JLabel("ID:");
        JLabel tituloLabel = new JLabel("Título:");

        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(tituloLabel);
        inputPanel.add(tituloField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 2, 10, 10));
        buttonPanel.setBackground(new Color(210, 180, 140));

        JButton agregarBtn = createStyledButton("Agregar");
        JButton eliminarBtn = createStyledButton("Eliminar");
        JButton buscarBtn = createStyledButton("Buscar");
        JButton actualizarBtn = createStyledButton("Actualizar");
        JButton mostrarBtn = createStyledButton("Mostrar Todos");
        JButton ordenarBtn = createStyledButton("Ordenar Alfabéticamente");

        buttonPanel.add(agregarBtn);
        buttonPanel.add(eliminarBtn);
        buttonPanel.add(buscarBtn);
        buttonPanel.add(actualizarBtn);
        buttonPanel.add(mostrarBtn);
        buttonPanel.add(ordenarBtn);

        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Eventos de botón con expresiones lambda
        agregarBtn.addActionListener(e -> agregarLibro());
        eliminarBtn.addActionListener(e -> eliminarLibro());
        buscarBtn.addActionListener(e -> buscarLibro());
        actualizarBtn.addActionListener(e -> actualizarLibro());
        mostrarBtn.addActionListener(e -> mostrarLibros());
        ordenarBtn.addActionListener(e -> ordenarLibros());

        setVisible(true);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(139, 69, 19)); // Color café oscuro
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(100, 50, 15), 2),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        button.setOpaque(true);
        return button;
    }

    // Métodos de funcionalidad
    private void agregarLibro() {
        try {
            long id = Long.parseLong(idField.getText());
            String titulo = tituloField.getText().trim();

            if (titulo.isEmpty()) {
                displayArea.setText("El título no puede estar vacío.");
                return;
            }

            Libro libro = new Libro(id, titulo);
            boolean agregado = biblioteca.agregarLibro(libro);
            displayArea.setText(agregado ? "Libro agregado correctamente." : "Ya existe un libro con ese ID.");
        } catch (NumberFormatException e) {
            displayArea.setText("ID inválido.");
        }
    }

    private void eliminarLibro() {
        try {
            long id = Long.parseLong(idField.getText());
            boolean eliminado = biblioteca.eliminarLibro(id);
            displayArea.setText(eliminado ? "Libro eliminado correctamente." : "No se encontró el libro con ese ID.");
        } catch (NumberFormatException e) {
            displayArea.setText("ID inválido.");
        }
    }

    private void buscarLibro() {
        try {
            long id = Long.parseLong(idField.getText());
            Libro libro = biblioteca.buscarLibro(id);
            displayArea.setText(libro != null ? "Libro encontrado:\nID: " + libro.getId() + ", Título: " + libro.getTitulo() : "Libro no encontrado.");
        } catch (NumberFormatException e) {
            displayArea.setText("ID inválido.");
        }
    }

    private void actualizarLibro() {
        try {
            long id = Long.parseLong(idField.getText());
            String titulo = tituloField.getText().trim();
            if (titulo.isEmpty()) {
                displayArea.setText("El título no puede estar vacío.");
                return;
            }
            boolean actualizado = biblioteca.actualizarLibro(id, new Libro(id, titulo));
            displayArea.setText(actualizado ? "Libro actualizado correctamente." : "No se encontró el libro con ese ID.");
        } catch (NumberFormatException e) {
            displayArea.setText("ID inválido.");
        }
    }

    private void mostrarLibros() {
        displayArea.setText(biblioteca.mostrarLibros());
    }

    private void ordenarLibros() {
        biblioteca.ordenarLibrosAlfabeticamente();
        displayArea.setText("Libros ordenados alfabéticamente.\n\n" + biblioteca.mostrarLibros());
    }
}
