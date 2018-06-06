package juego;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Pelota {

    int diametroPelota = 31;
    int diametroSegundaPelota = 25;
    int diametroTerceraPelota = 15;
    int posicionXPelota = 0, posicionYPelota = 0;
    int direccionX = 1; // 1,1 se mueve hacia abajo y hacia la izquierda
    int direccionY = 1; // si es negativo se mueve hacia arriba
    int primerImpacto = 0;
    int impactoEnSegundoObjeto = 0;
    int segundoImpactoEnSegundoObjeto = 0;
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
        if (impactoSegundaPelotaConRaqueta()) {
            direccionY = -1;
            posicionYPelota = juegoPelota.raqueta.altoEjeY() - diametroSegundaPelota;
        }
        if (impactoTerceraPelotaConRaqueta()) {
            direccionY = -1;
            posicionYPelota = juegoPelota.raqueta.altoEjeY() - diametroTerceraPelota;
        }
        if (impactoPelotaConObstaculo()) {
            direccionY *= -1;
            primerImpacto = 1;
        }
        if (impactoPelotaConSegundoObstaculo()) {
            direccionY *= -1;
            impactoEnSegundoObjeto = 1;
        }
        if (impactoPelotaConTercerObstaculo()) {
            direccionY *= -1;
            segundoImpactoEnSegundoObjeto = 1;
        }
        posicionXPelota = posicionXPelota + direccionX;
        posicionYPelota = posicionYPelota + direccionY;
    }

    public boolean impactoPelotaConRaqueta() {
        return juegoPelota.raqueta.getBoundsRaquetaDimension().intersects(interseccionPelota());
    }
    public boolean impactoSegundaPelotaConRaqueta() {
        return juegoPelota.raqueta.getBoundsRaquetaDimension().intersects(interseccionSegundaPelota());
    }
    public boolean impactoTerceraPelotaConRaqueta() {
        return juegoPelota.raqueta.getBoundsRaquetaDimension().intersects(interseccionTeceraPelota());
    }

    public boolean impactoPelotaConObstaculo() {
        return juegoPelota.obstaculo.interseccionObstaculo().intersects(interseccionPelota());
    }

    public boolean impactoPelotaConSegundoObstaculo() {
        return juegoPelota.segundoObstaculo.interseccionSegundoObstaculo().intersects(interseccionSegundaPelota());
    }

    public boolean impactoPelotaConTercerObstaculo() {
        return juegoPelota.tercerObstaculo.interseccionTercerObstaculo().intersects(interseccionTeceraPelota());
    }

    public void pintarPelota(Graphics2D gPelota) {
        gPelota.setColor(Color.RED);
        gPelota.fillOval(posicionXPelota, posicionYPelota, diametroPelota, diametroPelota);
    }

    public void pintarSegundaPelota(Graphics2D gPelota) {
        gPelota.setColor(Color.gray);
        gPelota.fillOval(posicionXPelota, posicionYPelota, diametroSegundaPelota, diametroSegundaPelota);
    }

    public void pintarTerceraPelota(Graphics2D gPelota) {
        gPelota.setColor(Color.black);
        gPelota.fillOval(posicionXPelota, posicionYPelota, diametroTerceraPelota, diametroTerceraPelota);
    }

    public Rectangle interseccionPelota() {
        return new Rectangle(posicionXPelota, posicionYPelota, diametroPelota, diametroPelota);
    }

    public Rectangle interseccionSegundaPelota() {
        return new Rectangle(posicionXPelota, posicionYPelota, diametroSegundaPelota, diametroSegundaPelota);
    }

    public Rectangle interseccionTeceraPelota() {
        return new Rectangle(posicionXPelota, posicionYPelota, diametroTerceraPelota, diametroTerceraPelota);
    }
}
