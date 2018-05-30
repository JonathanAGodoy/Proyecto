package juego;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.concurrent.ThreadLocalRandom;

public class Obstaculo {

    int posicionObstaculoX = ThreadLocalRandom.current().nextInt(2, 290);
    int ancho = 6, alto = 3;
    int posicionObstaculoY = 400;
    Juego juegoObstaculo;

    public Obstaculo(Juego juego) {
        juegoObstaculo = juego;
    }

    public void pintarObstaculo(Graphics2D gObstaculo) {
        gObstaculo.fillRect(posicionObstaculoX, posicionObstaculoY, ancho, alto);
        gObstaculo.setColor(Color.blue);
    }

    public Rectangle getBounds() {
        return new Rectangle(posicionObstaculoX, posicionObstaculoY, ancho, alto);
    }
}
