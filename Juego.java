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
    Pelota segundaPelota = new Pelota(this);
    Pelota tercerPelota = new Pelota(this);
    Raqueta raqueta = new Raqueta(this);
    Obstaculo obstaculo = new Obstaculo(this);
    Obstaculo segundoObstaculo = new Obstaculo(this);
    Obstaculo tercerObstaculo = new Obstaculo(this);
    int moverSegundaPelota = 0;
    int moverTercerPelota = 0;

    public void paint(Graphics g) {
        super.paint(g); // borra
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // bordes
        raqueta.pintarRaqueta(g2d);
        pelota.pintarPelota(g2d);
        obstaculo.pintarObstaculo(g2d);
        if (pelota.primerImpacto == 1) {
            segundoObstaculo.pintarSegundoObstaculo(g2d);
        }
        if ((pelota.impactoEnSegundoObjeto == 1) || (segundaPelota.impactoEnSegundoObjeto == 1)) {
            segundaPelota.pintarSegundaPelota(g2d);
            moverSegundaPelota = 1;
        }
        if ((pelota.segundoImpactoEnSegundoObjeto == 1) || (segundaPelota.segundoImpactoEnSegundoObjeto == 1)) {
            tercerPelota.pintarTerceraPelota(g2d);
            moverTercerPelota = 1;
        }
    }

    public void moverObjetos() {
        pelota.moverPelota();
        raqueta.moverRaqueta();
        if (moverSegundaPelota == 1) {
            segundaPelota.moverPelota();
        }
        if (moverTercerPelota == 1) {
            tercerPelota.moverPelota();
        }
    }

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

    public void errar() {
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
        // agregar un duraste tantos segundos
        pelota = null;
        segundaPelota = null;
        tercerPelota = null;
        raqueta = null;
        obstaculo = null;
        segundoObstaculo = null;
        tercerObstaculo = null;
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
