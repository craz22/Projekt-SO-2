package Gra.Organizmy.Zwierzeta;

import Gra.Organizmy.Organizm;
import Gra.Organizmy.Wspolrzedne;
import Gra.Swiat;

import java.awt.*;
import java.util.Random;

public class Zolw implements Zwierze {
    private int sila, inicjatywa, wiek;
    private Wspolrzedne polozenie;
    private Swiat swiat;
    private Color color;

    public Zolw(Swiat swiat, int x, int y) {
        this.sila = 2;
        this.inicjatywa = 1;
        this.wiek = 0;
        this.polozenie = new Wspolrzedne(x, y);
        this.swiat = swiat;
        this.color = Color.DARK_GRAY;
    }

    @Override
    public String Rysuj() {
        return "Z";
    }

    @Override
    public void Kolizja(Swiat swiat, Organizm atakujacy) {
        //sprawdzenie czy odbije atak
        if (atakujacy.getSila() > 5) {
            Zwierze.super.Kolizja(swiat,atakujacy);
        }
    }

    @Override
    public void Akcja(Swiat swiat) {
        Random generator = new Random();
        int los = generator.nextInt(4);
        if (los == 0) {
            Zwierze.super.Akcja(swiat);
        }
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public int getSila() {
        return sila;
    }

    @Override
    public void setSila(int sila) {
        this.sila = sila;
    }

    @Override
    public int getInicjatywa() {
        return inicjatywa;
    }

    @Override
    public void setInicjatywa(int inicjatywa) {
        this.inicjatywa = inicjatywa;
    }

    @Override
    public int getWiek() {
        return wiek;
    }

    @Override
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
