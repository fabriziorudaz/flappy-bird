import javax.swing.*;
import java.awt.event.*;

public class Juego extends JFrame {
    private boolean isPaused = false;
    private JPanel panelJuego;

    public Juego() {
        setTitle("Mi Juego");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panelJuego = new JPanel();
        add(panelJuego);
        
        // Añadir un listener para la tecla de pausa
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_P) { // Cambiar a la tecla que desees
                    togglePause();
                }
            }
        });
    }

    private void togglePause() {
        isPaused = !isPaused;
        if (isPaused) {
            mostrarMenuPausa();
        } else {
            // Reanudar lógica del juego
            System.out.println("Juego reanudado.");
        }
    }

    private void mostrarMenuPausa() {
        String[] opciones = {"Reanudar", "Guardar", "Salir"};
        int seleccion = JOptionPane.showOptionDialog(this, 
            "Juego en pausa", 
            "Menú de Pausa", 
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.INFORMATION_MESSAGE, 
            null, 
            opciones, 
            opciones[0]);

        switch (seleccion) {
            case 0: // Reanudar
                togglePause();
                break;
            case 1: // Salir
                System.exit(0);
                break;
        }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Juego juego = new Juego();
            juego.setVisible(true);
        });
      }
    }
   
