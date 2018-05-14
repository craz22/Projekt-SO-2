package Gra.Organizmy;

import java.awt.*;

public interface Organizm {
    void Akcja();

    void Kolizja();

    String Rysuj();

    int getSila();

    void setSila(int sila);

    int getInicjatywa();

    void setInicjatywa(int inicjatywa);

    int getWiek();

    void setWiek(int wiek);

    Wspolrzedne getPolozenie();

    void setPolozenie(Wspolrzedne polozenie);

}
