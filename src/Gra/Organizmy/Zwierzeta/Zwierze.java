package Gra.Organizmy.Zwierzeta;

import Gra.Organizmy.Organizm;
import Gra.Organizmy.Wspolrzedne;
import Gra.Swiat;

import java.awt.*;
import java.util.Random;
import java.util.Vector;

public interface Zwierze extends Organizm {
    @Override
    String Rysuj();

    @Override
    default void Kolizja(Swiat swiat, Organizm atakujacy) {
        //sprawdzenie kto ma wieksza sile
        if (atakujacy.getSila() >= getSila()) {
            swiat.zabij(this);
            swiat.moveOrganizm(atakujacy, getPolozenie().getY(), getPolozenie().getX());
        } else {
            swiat.zabij(atakujacy);
        }
    }

    @Override
    default void Akcja(Swiat swiat) {
        Random generator = new Random();
        int py = 0, px = 0, los;
        //losujemy czy porusza sie pionowo, poziomo czy na ukos
        los = generator.nextInt(3);
        switch (los) {
            //pionowo
            case 0: {
                py = getPY(swiat);
                break;
            }
            //posiomo
            case 1: {
                px = getPX(swiat);
                break;
            }
            //na ukos
            case 2: {
                py = getPY(swiat);
                px = getPX(swiat);
                break;
            }
        }
        swiat.moveOrganizm(this, getPolozenie().getY() + py, getPolozenie().getX() + px);
    }

    default int getPX(Swiat swiat) {
        Random generator = new Random();
        int los;
        if (getPolozenie().getX() == 0) {
            return 1;
        } else if (getPolozenie().getX() == swiat.getX() - 1) {
            return -1;
        } else {
            los = generator.nextInt(2);
            if (los == 0) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    default int getPY(Swiat swiat) {
        Random generator = new Random();
        int los;
        if (getPolozenie().getY() == 0) {
            return 1;
        } else if (getPolozenie().getY() == swiat.getY() - 1) {
            return -1;
        } else {
            los = generator.nextInt(2);
            if (los == 0) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    @Override
    int getSila();

    @Override
    void setSila(int sila);

    @Override
    int getInicjatywa();

    @Override
    void setInicjatywa(int inicjatywa);

    @Override
    int getWiek();

    @Override
    void setWiek(int wiek);

    @Override
    Color getColor();

    @Override
    void setColor(Color color);

    @Override
    Wspolrzedne getPolozenie();

    @Override
    void setPolozenie(Wspolrzedne polozenie);
}
