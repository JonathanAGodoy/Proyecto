package juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Juego extends JPanel {

    Pelota pelota = new Pelota(this);
    Raqueta raqueta = new Raqueta(this);
    Obstaculo obstaculo = new Obstaculo(this);

    public Juego() {
        setBackground(Color.PINK);
        addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) { // cuando la suelta
                raqueta.keyReleased(e);
            }

            public void keyPressed(KeyEvent e) { // cuando la oprime
                raqueta.keyPressed(e);
            }
        });
        setFocusable(true);
    }

    public void moverObjetos() {
        pelota.moverPelota();
        raqueta.moverRaqueta();
    }

    public void paint(Graphics g) {
        super.paint(g); // borra
        Graphics2D g2d = (Graphics2D) g;
        Graphics2D g2d1 = (Graphics2D) g;
        Graphics2D g2d2 = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // bordes
        raqueta.pintarRaqueta(g2d1);
        pelota.pintarPelota(g2d);
        obstaculo.pintarObstaculo(g2d2);
    }

    public void errar() {
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame ventana = new JFrame();
        ventana.setTitle("Ping Pong");
        Juego juego = new Juego();
        ventana.add(juego);
        ventana.setSize(300, 700);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            juego.moverObjetos();
            juego.repaint();
            Thread.sleep(3);
        }
    }
}
