package Gra.Organizmy.Zwierzeta;


import Gra.Organizmy.Organizm;
import Gra.Organizmy.Wspolrzedne;
import Gra.Swiat;

import java.awt.*;

public class Owca implements Zwierze {
    private int sila, inicjatywa, wiek;
    private Wspolrzedne polozenie;
    private Swiat swiat;
    private Color color;

    public Owca(Swiat swiat, int x, int y) {
        this.sila = 4;
        this.inicjatywa = 4;
        this.wiek = 0;
        this.polozenie = new Wspolrzedne(x, y);
        this.swiat = swiat;
        this.color = Color.LIGHT_GRAY;
    }

    @Override
    public String Rysuj() {
        return "O";
    }

    @Override
    public void Kolizja(Swiat swiat, Organizm atakujacy) {
        Zwierze.super.Kolizja(swiat, atakujacy);
    }

    @Override
    public void Akcja(Swiat swiat) {
        Zwierze.super.Akcja(swiat);
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    public int getSila() {
        return sila;
    }

    public void setSila(int sila) {
        this.sila = sila;
    }

    public int getInicjatywa() {
        return inicjatywa;
    }

    public void setInicjatywa(int inicjatywa) {
        this.inicjatywa = inicjatywa;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    @Override
    public Wspolrzedne getPolozenie() {
        return this.polozenie;
    }

    @Override
    public void setPolozenie(Wspolrzedne polozenie) {
        this.polozenie = polozenie;
    }
}
