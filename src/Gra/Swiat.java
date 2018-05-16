package Gra;

import Gra.Organizmy.Organizm;
import Gra.Organizmy.Rosliny.*;
import Gra.Organizmy.Wspolrzedne;
import Gra.Organizmy.Zwierzeta.*;

import java.util.Collections;
import java.util.Random;
import java.util.Vector;

public class Swiat {
    private int x, y;
    private String kierunek;
    private Vector<Organizm> organizmy = new Vector<>();
    private int[][] pole;
    private Czlowiek czlowiek;
    private Vector<String> komentarze = new Vector<>();

    public Swiat(int x, int y) {
        this.x = x;
        this.y = y;
        pole = new int[y][x];
        this.kierunek = "prawa";
        randOrganizm(this);
    }

    //TODO czlowiek umiejetnosc specjalna, czlowiek poruasznie sie, przeprowadzanie tur, sprawdzenie czy wszedzie sa komentarze

    public Czlowiek getCzlowiek() {
        return czlowiek;
    }

    private void setCzlowiek(Czlowiek czlowiek) {
        this.czlowiek = czlowiek;
        addOrganizm(this.czlowiek);
    }

    public String getKierunek() {
        return kierunek;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        randOrganizm(this);
    }

    public Vector<String> getKomentarze() {
        return komentarze;
    }

    public void addKomentarz(String komentarz) {
        this.komentarze.add(komentarz);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        randOrganizm(this);
    }

    public int getPole(int y, int x) {
        return pole[y][x];
    }

    private void setPole(int y, int x, int ID) {
        this.pole[y][x] = ID;
    }

    public void addOrganizm(Organizm org) {
        organizmy.add(org);
        setPole(org.getPolozenie().getY(), org.getPolozenie().getX(), org.hashCode());
    }

    public Organizm getOrganizm(int y, int x) {
        for (Organizm org : organizmy) {
            if (org.getPolozenie().getY() == y && org.getPolozenie().getX() == x) {
                return org;
            }
        }
        return null;
    }

    public void moveOrganizm(Organizm org, int y, int x) {
        if (getOrganizm(y, x) == null) {
            setPole(org.getPolozenie().getY(), org.getPolozenie().getX(), 0);
            setPole(y, x, org.hashCode());
            org.setPolozenie(new Wspolrzedne(x, y));
        } else {
            getOrganizm(y, x).Kolizja(this, org);
        }
    }

    private void sortujOrganizmy() {
        if (organizmy.size() != 0) {
            for (int i = 0; i < organizmy.size(); i++)
                for (int j = 1; j < organizmy.size() - i; j++)
                    if (organizmy.get(j - 1).getInicjatywa() < organizmy.get(j).getInicjatywa())
                        Collections.swap(organizmy, j - 1, j);
                        //jesli maja taka sama inicjatywe
                    else if (organizmy.get(j - 1).getInicjatywa() == organizmy.get(j).getInicjatywa()) {
                        if (organizmy.get(j - 1).getWiek() < organizmy.get(j).getWiek())
                            Collections.swap(organizmy, j - 1, j);
                    }
        }
    }

    public void zabij(Organizm org) {
        organizmy.remove(org);
        setPole(org.getPolozenie().getY(), org.getPolozenie().getX(), 0);
    }

    public void wykonajTure() {
        sortujOrganizmy();
        for (Organizm org : organizmy) {
            org.setWiek(org.getWiek() + 1);
            org.Akcja(this);
        }
    }

    private void randOrganizm(Swiat swiat) {
        pole = new int[this.y][this.x];
        for (int i = 0; i < this.y; i++) {
            for (int j = 0; j < this.x; j++) {
                this.pole[i][j] = 0;
            }
        }
        organizmy.clear();
        int rx, ry;
        Random generator = new Random();
        rx = generator.nextInt(this.x);
        ry = generator.nextInt(this.y);
        setCzlowiek(new Czlowiek(this, rx, ry));
        int procent = (int) (this.x * this.y * 0.03);
        if (procent == 0) {
            procent = 1;
        }
        for (int i = 0; i < 10; i++) {
            int licznik = 0;
            while (licznik <= procent) {
                rx = generator.nextInt(swiat.getX());
                ry = generator.nextInt(swiat.getY());
                if (pole[ry][rx] == 0) {
                    switch (i) {
                        case 0: {
                            BarszczSosnowskiego barszczSosnowskiego = new BarszczSosnowskiego(swiat, rx, ry);
                            addOrganizm(barszczSosnowskiego);
                            break;
                        }
                        case 1: {
                            Guarana guarana = new Guarana(swiat, rx, ry);
                            addOrganizm(guarana);
                            break;
                        }
                        case 2: {
                            Mlecz mlecz = new Mlecz(swiat, rx, ry);
                            addOrganizm(mlecz);
                            break;
                        }
                        case 3: {
                            Trawa trawa = new Trawa(swiat, rx, ry);
                            addOrganizm(trawa);
                            break;
                        }
                        case 4: {
                            WilczeJagody wilczeJagody = new WilczeJagody(swiat, rx, ry);
                            addOrganizm(wilczeJagody);
                            break;
                        }
                        case 5: {
                            Antylopa antylopa = new Antylopa(swiat, rx, ry);
                            addOrganizm(antylopa);
                            break;
                        }
                        case 6: {
                            Lis lis = new Lis(swiat, rx, ry);
                            addOrganizm(lis);
                            break;
                        }
                        case 7: {
                            Owca owca = new Owca(swiat, rx, ry);
                            addOrganizm(owca);
                            break;
                        }
                        case 8: {
                            Wilk wilk = new Wilk(swiat, rx, ry);
                            addOrganizm(wilk);
                            break;
                        }
                        case 9: {
                            Zolw zolw = new Zolw(swiat, rx, ry);
                            addOrganizm(zolw);
                            break;
                        }
                    }
                    licznik++;
                }
            }
        }
    }
}
