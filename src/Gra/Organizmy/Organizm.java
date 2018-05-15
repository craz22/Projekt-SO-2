package Gra.Organizmy;

import Gra.Swiat;

import java.awt.*;

public interface Organizm {
    void Akcja(Swiat swiat);

    void Kolizja(Swiat swiat, Organizm atakujacy);

    String Rysuj();

    int getSila();

    void setSila(int sila);

    int getInicjatywa();

    void setInicjatywa(int inicjatywa);

    int getWiek();

    void setWiek(int wiek);

    Color getColor();

    void setColor(Color color);

    Wspolrzedne getPolozenie();

    void setPolozenie(Wspolrzedne polozenie);

}
