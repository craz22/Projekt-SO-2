package Gra.Organizmy.Zwierzeta;


import Gra.Organizmy.Organizm;
import Gra.Organizmy.Wspolrzedne;
import Gra.Swiat;

import java.awt.*;
import java.util.Random;
import java.util.Vector;

public class Lis implements Zwierze {
    private int sila, inicjatywa, wiek;
    private Wspolrzedne polozenie;
    private Swiat swiat;
    private Color color;

    public Lis(Swiat swiat, int x, int y) {
        this.swiat = swiat;
        this.sila = 3;
        this.inicjatywa = 7;
        this.wiek = 0;
        this.polozenie = new Wspolrzedne(x, y);
        this.color = Color.PINK;
    }

    @Override
    public String Rysuj() {
        return "L";
    }

    @Override
    public void Kolizja(Swiat swiat, Organizm atakujacy) {
        Zwierze.super.Kolizja(swiat, atakujacy);
    }

    @Override
    public void Akcja(Swiat swiat) {
        //szukanie mozliwych pol do ruszenia sie
        Vector<Wspolrzedne> tablica = new Vector<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) ;
                else {
                    if (getPolozenie().getY() + 1 - i >= 0
                            && getPolozenie().getY() + 1 - i <= swiat.getY() - 1
                            && getPolozenie().getX() + 1 - j >= 0
                            && getPolozenie().getX() + 1 - j <= swiat.getX() - 1) {
                        //jesli jest puste
                        if (swiat.getOrganizm(getPolozenie().getY() + 1 - i, getPolozenie().getX() + 1 - j) == null) {
                            tablica.add(new Wspolrzedne(getPolozenie().getX() + 1 - j, getPolozenie().getY() + 1 - i));
                        }
                        //jesli przeciwnik jest slabszy
                        else if (swiat.getOrganizm(getPolozenie().getY() + 1 - i, getPolozenie().getX() + 1 - j).getSila() <= getSila()) {
                            tablica.add(new Wspolrzedne(getPolozenie().getX() + 1 - j, getPolozenie().getY() + 1 - i));
                        }
                    }
                }
            }
        }
        //wylosowanie wspolrzednych
        if (!tablica.isEmpty()) {
            Random generator = new Random();
            int los = generator.nextInt(tablica.size());
            swiat.moveOrganizm(this, tablica.elementAt(los).getY(), tablica.elementAt(los).getX());
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

    }
}
