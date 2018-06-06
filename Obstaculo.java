import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.concurrent.ThreadLocalRandom;

public class Obstaculo {

    int posicionObstaculoX = ThreadLocalRandom.current().nextInt(110, 250);
    int posicionSegundoObstaculoX = ThreadLocalRandom.current().nextInt(30, 99);
    int posicionTercerObstaculoX = ThreadLocalRandom.current().nextInt(100, 211);
    int ancho = 6, alto = 3;
    int anchoTercero = 33;
    int posicionObstaculoY = 390;
    int posicionSegundoObstaculoY = 403;
    int posicionTercerObstaculoY = 10;
    Juego juegoObstaculo;

    public Obstaculo(Juego juego) {
        juegoObstaculo = juego;
    }

    public void pintarObstaculo(Graphics2D gObstaculo) {
        gObstaculo.setColor(Color.blue);
        gObstaculo.fillRect(posicionObstaculoX, posicionObstaculoY, ancho, alto);
    }

    public void pintarSegundoObstaculo(Graphics2D gObstaculo) {
        gObstaculo.setColor(Color.green);
        gObstaculo.fillRect(posicionSegundoObstaculoX, posicionSegundoObstaculoY, ancho, alto);
    }

    public void pintarTercerObstaculo(Graphics2D gObstaculo) {
        gObstaculo.setColor(Color.white);
        gObstaculo.fillRect(posicionObstaculoX, posicionTercerObstaculoY, anchoTercero, alto);
    }

    public Rectangle interseccionObstaculo() {
        return new Rectangle(posicionObstaculoX, posicionObstaculoY, ancho, alto);
    }

    public Rectangle interseccionSegundoObstaculo() {
        return new Rectangle(posicionSegundoObstaculoX, posicionSegundoObstaculoY, ancho, alto);
    }

    public Rectangle interseccionTercerObstaculo() {
        return new Rectangle(posicionObstaculoX, posicionTercerObstaculoY, anchoTercero, alto);
    }
}
