package juego;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Pelota {

    int diametroPelota = 31;
    int posicionXPelota = 0, posicionYPelota = 0;
    int direccionX = 1; // 1,1 se mueve hacia abajo y hacia la izquierda
    int direccionY = 1; // si es negativo se mueve hacia arriba
    private Juego juegoPelota;

    public Pelota(Juego juego) {
        juegoPelota = juego;
    }

    public void moverPelota() {
        if (posicionXPelota + direccionX < 0) {
            direccionX = 1;
        }
        if (posicionXPelota + direccionX > juegoPelota.getWidth() - diametroPelota) {
            direccionX = -1;
        }
        if (posicionYPelota + direccionY < 0) {
            direccionY = 1;
        }
        if (posicionYPelota + direccionY > juegoPelota.getHeight() - diametroPelota) {
            juegoPelota.errar();
        }
        if (impactoPelotaConRaqueta()) {
            direccionY = -1;
            posicionYPelota = juegoPelota.raqueta.altoEjeY() - diametroPelota;
        }
        if (impactoPelotaConObstaculo()) {
            direccionY *= -1;
        }
        posicionXPelota = posicionXPelota + direccionX;
        posicionYPelota = posicionYPelota + direccionY;
    }

    public boolean impactoPelotaConRaqueta() {
        return juegoPelota.raqueta.getBounds().intersects(getBounds());
    }

    public boolean impactoPelotaConObstaculo() {
        return juegoPelota.obstaculo.getBounds().intersects(getBounds());
    }

    public void pintarPelota(Graphics2D gPelota) {
        gPelota.fillOval(posicionXPelota, posicionYPelota, diametroPelota, diametroPelota);
        gPelota.setColor(Color.RED);
    }

    public Rectangle getBounds() {
        return new Rectangle(posicionXPelota, posicionYPelota, diametroPelota, diametroPelota);
    }
}
