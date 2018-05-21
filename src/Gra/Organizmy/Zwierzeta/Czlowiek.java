package Gra.Organizmy.Zwierzeta;


import Gra.Organizmy.Organizm;
import Gra.Organizmy.Wspolrzedne;
import Gra.Swiat;

import java.awt.*;

public class Czlowiek implements Zwierze {
    private int sila, inicjatywa, wiek;
    private Wspolrzedne polozenie;
    private Swiat swiat;
    private Color color;

    public Czlowiek(Swiat swiat, int x, int y) {
        this.sila = 5;
        this.inicjatywa = 4;
        this.wiek = 0;
        this.polozenie = new Wspolrzedne(x, y);
        this.swiat = swiat;
        this.color = Color.WHITE;
    }

    @Override
    public String Rysuj() {
        return "C";
    }

    @Override
    public void Kolizja(Swiat swiat, Organizm atakujacy) {
        Zwierze.super.Kolizja(swiat, atakujacy);
    }

    @Override
    public void Akcja(Swiat swiat) {
        //jesli jest umiejetnosc specjalna
        int px = 0, py = 0;
        if (swiat.getLicznikSpecjalny() > 0 && swiat.getLicznikSpecjalny() < 6) {
            switch (swiat.getKierunek()) {
                case "lewa": {
                    if (getPolozenie().getX() > 2) {
                        px = -2;
                    } else if (getPolozenie().getX() == 1) {
                        px = -1;
                    }
                    break;
                }
                case "prawa": {
                    if (getPolozenie().getX() <= swiat.getX() - 3) {
                        px = 2;
                    } else if (getPolozenie().getX() == swiat.getX() - 2) {
                        px = 1;
                    }
                    break;
                }
                case "gora": {
                    if (getPolozenie().getY() >= 2) {
                        py = -2;
                    } else if (getPolozenie().getY() == 1) {
                        py = -1;
                    }
                    break;
                }
                case "dol": {
                    if (getPolozenie().getY() <= swiat.getY() - 3) {
                        py = 2;
                    } else if (getPolozenie().getY() == swiat.getY() - 2) {
                        py = 1;
                    }
                    break;
                }
            }
        } else {
            switch (swiat.getKierunek()) {
                case "lewa": {
                    if (getPolozenie().getX() >= 1) {
                        px = -1;
                    }
                    break;
                }
                case "prawa": {
                    if (getPolozenie().getX() <= swiat.getX() - 2) {
                        px = 1;
                    }
                    break;
                }
                case "gora": {
                    if (getPolozenie().getY() >= 1) {
                        py = -1;
                    }
                    break;
                }
                case "dol": {
                    if (getPolozenie().getY() <= swiat.getY() - 2) {
                        py = 1;
                    }
                    break;
                }
            }
        }
        py += getPolozenie().getY();
        px += getPolozenie().getX();
        swiat.moveOrganizm(this, py, px);
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

    public Wspolrzedne getPolozenie() {
        return this.polozenie;
    }

    public void setPolozenie(Wspolrzedne polozenie) {
        this.polozenie = polozenie;
    }
}
