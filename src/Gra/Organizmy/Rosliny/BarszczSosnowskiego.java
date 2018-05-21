package Gra.Organizmy.Rosliny;


import Gra.Organizmy.Organizm;
import Gra.Organizmy.Wspolrzedne;
import Gra.Organizmy.Zwierzeta.Zwierze;
import Gra.Swiat;

import java.awt.*;
import java.util.Random;
import java.util.Vector;

public class BarszczSosnowskiego implements Roslina {
    private int sila, inicjatywa, wiek;
    private Wspolrzedne polozenie;
    private Swiat swiat;
    private Color color;

    public BarszczSosnowskiego(Swiat swiat, int x, int y) {
        this.inicjatywa = 0;
        this.sila = 10;
        this.wiek = 0;
        this.polozenie = new Wspolrzedne(x, y);
        this.swiat = swiat;
        this.color = Color.RED;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void Akcja(Swiat swiat) {
        Random generator = new Random();
        int los;
        //szukanie zwierzat dookola
        Vector<Wspolrzedne> tablica = new Vector<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //noinspection StatementWithEmptyBody
                if (i == 1 && j == 1) ;
                else {
                    if (getPolozenie().getY() + 1 - i >= 0
                            && getPolozenie().getY() + 1 - i <= swiat.getY() - 1
                            && getPolozenie().getX() + 1 - j >= 0
                            && getPolozenie().getX() + 1 - j <= swiat.getX() - 1) {
                        //jesli jest zwierzeciem
                        Class<?> interf = Zwierze.class;

                        if (swiat.getOrganizm(getPolozenie().getY() + 1 - i, getPolozenie().getX() + 1 - j) != null) {
                            Class<?> obj = swiat.getOrganizm(getPolozenie().getY() + 1 - i,
                                    getPolozenie().getX() + 1 - j)
                                    .getClass();

                            if (interf.isAssignableFrom(obj)) {
                                tablica.add(new Wspolrzedne(getPolozenie().getX() + 1 - j,
                                        getPolozenie().getY() + 1 - i)
                                );
                            }
                        }
                    }
                }
            }
        }
        //zabicie organizmow dookola
        if (!tablica.isEmpty()) {
            for (Wspolrzedne wsp : tablica) {
                String komentarz = "Barszcz Sosnowskiego zabil " + swiat.getOrganizm(wsp.getY(), wsp.getX()).getClass().getSimpleName();
                swiat.addKomentarz(komentarz);
                swiat.zabij(swiat.getOrganizm(wsp.getY(), wsp.getX()));
            }
        }
        //rozprzestrzenianie sie
        Roslina.super.Akcja(swiat);
    }

    @Override
    public String Rysuj() {
        return "B";
    }

    @Override
    public void Kolizja(Swiat swiat, Organizm atakujacy) {
        String komentarz = atakujacy.getClass().getSimpleName() + " zjadl Barszcz Sosnowskiego";
        swiat.addKomentarz(komentarz);
        Roslina.super.Kolizja(swiat, atakujacy);
        swiat.zabij(this);
    }

    public Swiat getSwiat() {
        return swiat;
    }

    public void setSwiat(Swiat swiat) {
        this.swiat = swiat;
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
