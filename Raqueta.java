package juego;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Raqueta {

    int nivelRaqueta = 650;
    int ancho = 55, alto = 8;
    int posicionRaqueta1 = 0;
    int posicionRaqueta2 = 0;
    Juego juegoRaqueta;

    public Raqueta(Juego juego) {
        juegoRaqueta = juego;
    }

    public void moverRaqueta() {
        if (posicionRaqueta1 + posicionRaqueta2 > 0 && posicionRaqueta1 + posicionRaqueta2 < juegoRaqueta.getWidth() - ancho) {
            posicionRaqueta1 = posicionRaqueta1 + posicionRaqueta2;
        }
    }

    public void pintarRaqueta(Graphics2D gRaqueta) {
        gRaqueta.fillRect(posicionRaqueta1, nivelRaqueta, ancho, alto);
        gRaqueta.setColor(Color.yellow);
    }

    public void keyReleased(KeyEvent e) {
        posicionRaqueta2 = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            posicionRaqueta2 = -1;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            posicionRaqueta2 = 1;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(posicionRaqueta1, nivelRaqueta, ancho, alto);
    }

    public int altoEjeY() {
        return nivelRaqueta - alto;
    }
}
