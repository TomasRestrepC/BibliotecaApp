/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.biblioteca.views;

/**
 *
 * @author tomas
 */

import autonoma.biblioteca.models.Biblioteca;
import autonoma.biblioteca.models.Libro;
import javax.swing.*;
import java.awt.event.*;

public class BibliotecaGUI extends JFrame {

    private Biblioteca biblioteca = new Biblioteca();

    private JTextField idField = new JTextField();
    private JTextField tituloField = new JTextField();
    private JTextArea displayArea = new JTextArea();

    public BibliotecaGUI() {
        setTitle("Biblioteca");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel idLabel = new JLabel("ID:");
        JLabel tituloLabel = new JLabel("Título:");

        JButton agregarBtn = new JButton("Agregar");
        JButton eliminarBtn = new JButton("Eliminar");
        JButton buscarBtn = new JButton("Buscar");
        JButton actualizarBtn = new JButton("Actualizar");
        JButton mostrarBtn = new JButton("Mostrar Todos");
        JButton ordenarBtn = new JButton("Ordenar Alfabéticamente");

        // Posicionamiento
        idLabel.setBounds(20, 20, 100, 20);
        idField.setBounds(120, 20, 150, 20);

        tituloLabel.setBounds(20, 50, 100, 20);
        tituloField.setBounds(120, 50, 150, 20);

        agregarBtn.setBounds(300, 20, 150, 25);
        eliminarBtn.setBounds(300, 50, 150, 25);
        buscarBtn.setBounds(300, 80, 150, 25);
        actualizarBtn.setBounds(300, 110, 150, 25);
        mostrarBtn.setBounds(300, 140, 150, 25);
        ordenarBtn.setBounds(300, 170, 150, 25);

        displayArea.setBounds(20, 200, 440, 240);
        displayArea.setEditable(false);

        // Agregar componentes
        add(idLabel);
        add(idField);
        add(tituloLabel);
        add(tituloField);
        add(agregarBtn);
        add(eliminarBtn);
        add(buscarBtn);
        add(actualizarBtn);
        add(mostrarBtn);
        add(ordenarBtn);
        add(displayArea);

        // Eventos de botón
        agregarBtn.addActionListener(e -> agregarLibro());
        eliminarBtn.addActionListener(e -> eliminarLibro());
        buscarBtn.addActionListener(e -> buscarLibro());
        actualizarBtn.addActionListener(e -> actualizarLibro());
        mostrarBtn.addActionListener(e -> mostrarLibros());
        ordenarBtn.addActionListener(e -> ordenarLibros());

        setVisible(true);
    }

    private void agregarLibro() {
        try {
            long id = Long.parseLong(idField.getText());
            String titulo = tituloField.getText();
            Libro libro = new Libro(id, titulo);
            boolean agregado = biblioteca.agregarLibro(libro);
            if (agregado) {
                displayArea.setText("Libro agregado correctamente.");
            } else {
                displayArea.setText("Ya existe un libro con ese ID.");
            }
        } catch (NumberFormatException e) {
            displayArea.setText("ID inválido.");
        }
    }

    private void eliminarLibro() {
        try {
            long id = Long.parseLong(idField.getText());
            boolean eliminado = biblioteca.eliminarLibro(id);
            if (eliminado) {
                displayArea.setText("Libro eliminado correctamente.");
            } else {
                displayArea.setText("No se encontró el libro con ese ID.");
            }
        } catch (NumberFormatException e) {
            displayArea.setText("ID inválido.");
        }
    }

    private void buscarLibro() {
        try {
            long id = Long.parseLong(idField.getText());
            Libro libro = biblioteca.buscarLibro(id);
            if (libro != null) {
                displayArea.setText("Libro encontrado:\nID: " + libro.getId() + ", Título: " + libro.getTitulo());
            } else {
                displayArea.setText("Libro no encontrado.");
            }
        } catch (NumberFormatException e) {
            displayArea.setText("ID inválido.");
        }
    }

    private void actualizarLibro() {
        try {
            long id = Long.parseLong(idField.getText());
            String titulo = tituloField.getText();
            Libro nuevoLibro = new Libro(id, titulo);
            boolean actualizado = biblioteca.actualizarLibro(id, nuevoLibro);
            if (actualizado) {
                displayArea.setText("Libro actualizado correctamente.");
            } else {
                displayArea.setText("No se encontró el libro con ese ID.");
            }
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

