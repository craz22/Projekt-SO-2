package Gra.Organizmy.Rosliny;


import Gra.Organizmy.Organizm;
import Gra.Organizmy.Wspolrzedne;
import Gra.Swiat;

import java.awt.*;
import java.util.Random;
import java.util.Vector;

public interface Roslina extends Organizm {
    @SuppressWarnings("Duplicates")
    @Override
    default void Akcja(Swiat swiat) {
        Random generator = new Random();
        int los;
        //szukanie wolnych miejsc
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
                    }
                }
            }
        }
        //jesli sa wolne miejsca
        if (!tablica.isEmpty()) {
            //szansa na rozmnozenie sie
            los = generator.nextInt(100);
            if (los < 10) {//10% szansy
                los = generator.nextInt(tablica.size());
                int wx = tablica.elementAt(los).getX(), wy = tablica.elementAt(los).getY();
                String klasa = this.getClass().getSimpleName();
                Organizm org;
                switch (klasa) {
                    case "BarszczSosnowskiego": {
                        org = new BarszczSosnowskiego(swiat, wx, wy);
                        break;
                    }
                    case "Guarana": {
                        org = new Guarana(swiat, wx, wy);
                        break;
                    }
                    case "Mlecz": {
                        org = new Mlecz(swiat, wx, wy);
                        break;
                    }
                    case "Trawa": {
                        org = new Trawa(swiat, wx, wy);
                        break;
                    }
                    case "WilczeJagody": {
                        org = new WilczeJagody(swiat, wx, wy);
                        break;
                    }
                    default: {
                        org = new Trawa(swiat, wx, wy);
                        break;
                    }
                }
                swiat.addOrganizm(org);
            }
        }
    }

    @Override
    String Rysuj();

    @Override
    default void Kolizja(Swiat swiat, Organizm atakujacy) {
        if (atakujacy.getSila() >= getSila()) {
            swiat.zabij(this);
            swiat.moveOrganizm(atakujacy, getPolozenie().getY(), getPolozenie().getX());
        } else {
            swiat.zabij(atakujacy);
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
