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

    @SuppressWarnings("Duplicates")
    @Override
    default void Kolizja(Swiat swiat, Organizm atakujacy) {
        //jesli jest tego samego gatunku
        String komentarz;
        if (atakujacy.getClass().getSimpleName().equals(getClass().getSimpleName())) {
            Random generator = new Random();
            int los;
            //szukanie wolnych miejsc
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
                    Organizm org;
                    switch (this.getClass().getSimpleName()) {
                        case "Antylopa": {
                            org = new Antylopa(swiat, wx, wy);
                            break;
                        }
                        case "Lis": {
                            org = new Lis(swiat, wx, wy);
                            break;
                        }
                        case "Owca": {
                            org = new Owca(swiat, wx, wy);
                            break;
                        }
                        case "Wilk": {
                            org = new Wilk(swiat, wx, wy);
                            break;
                        }
                        case "Zolw": {
                            org = new Zolw(swiat, wx, wy);
                            break;
                        }
                        default: {
                            org = new Owca(swiat, wx, wy);
                            break;
                        }
                    }
                    komentarz = "Urodzil sie " + org.getClass().getSimpleName();
                    swiat.addKomentarz(komentarz);
                    swiat.addOrganizm(org);
                }
            }
        }
        //jesli nie jest
        else {
            //sprawdzenie kto ma wieksza sile
            if (atakujacy.getSila() >= getSila()) {
                komentarz = atakujacy.getClass().getSimpleName() + " zabil " + this.getClass().getSimpleName();
                swiat.zabij(this);
                swiat.moveOrganizm(atakujacy, getPolozenie().getY(), getPolozenie().getX());
            } else {
                komentarz = this.getClass().getSimpleName() + " zabil " + atakujacy.getClass().getSimpleName();
                swiat.zabij(atakujacy);
            }
            swiat.addKomentarz(komentarz);
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
