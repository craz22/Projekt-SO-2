package Gra;

import Gra.Organizmy.Organizm;
import Gra.Organizmy.Rosliny.*;
import Gra.Organizmy.Wspolrzedne;
import Gra.Organizmy.Zwierzeta.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Swiat {
    private int x, y;
    private String kierunek;
    private Vector<Organizm> organizmy = new Vector<>();
    private int[][] pole;
    private Czlowiek czlowiek;
    private Vector<String> komentarze = new Vector<>();
    private int licznikspecjalny;

    public Swiat(int x, int y) {
        this.x = x;
        this.y = y;
        pole = new int[y][x];
        this.kierunek = "prawa";
        this.licznikspecjalny = 0;
    }

    public int getLicznikSpecjalny() {
        return licznikspecjalny;
    }

    public void setLicznikSpecjalny(int licznikspecjalny) {
        this.licznikspecjalny = licznikspecjalny;
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

    private void setPole(int y, int x, int ID) {
        this.pole[y][x] = ID;
    }

    public void addOrganizm(Organizm org) {
        organizmy.add(org);
        setPole(org.getPolozenie().getY(), org.getPolozenie().getX(), org.hashCode());
    }

    public Organizm getOrganizm(int y, int x) {
        for (Organizm org : organizmy) {
            if (org.getPolozenie().getY() == y && org.getPolozenie().getX() == x && org.getInicjatywa() != -1) {
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
        int i = organizmy.size();
        while (organizmy.lastElement().getInicjatywa() == -1) {
            organizmy.remove(i - 1);
            i--;
        }
    }

    public void zabij(Organizm org) {
        org.setInicjatywa(-1);
        setPole(org.getPolozenie().getY(), org.getPolozenie().getX(), 0);
    }

    public void wykonajTure() {
        komentarze.removeAllElements();
        sortujOrganizmy();
        int temp = organizmy.size();
        for (int i = 0; i < temp; i++) {
            organizmy.elementAt(i).setWiek(organizmy.elementAt(i).getWiek() + 1);
            organizmy.elementAt(i).Akcja(this);
        }
        if (licznikspecjalny > 0) {
            licznikspecjalny++;
        }
        if (licznikspecjalny == 10) {
            licznikspecjalny = 0;
        }
    }

    void randOrganizm(Swiat swiat) {
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

    public void save() {
        try (PrintWriter writer = new PrintWriter("save.txt", "UTF-8")) {
            writer.println(this.x + " " + this.y);
            for (Organizm org : organizmy) {
                writer.println(org.getClass().getSimpleName());
                writer.println(org.getPolozenie().getX() + " " + org.getPolozenie().getY() + " " + org.getInicjatywa() + " " + org.getSila() + " " + org.getWiek());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    public Swiat load() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("save.txt"));
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        Swiat swiat = new Swiat(x, y);
        while (scanner.hasNext()) {
            scanner.nextLine();
            String nazwa = scanner.nextLine();
            int px = scanner.nextInt();
            int py = scanner.nextInt();
            int inicjatywa = scanner.nextInt();
            int sila = scanner.nextInt();
            int wiek = scanner.nextInt();
            Organizm org;
            switch (nazwa) {
                case "BarszczSosnowskiego": {
                    org = new BarszczSosnowskiego(swiat, px, py);
                    break;
                }
                case "Guarana": {
                    org = new Guarana(swiat, px, py);
                    break;
                }
                case "Mlecz": {
                    org = new Mlecz(swiat, px, py);
                    break;
                }
                case "Trawa": {
                    org = new Trawa(swiat, px, py);
                    break;
                }
                case "WilczeJagody": {
                    org = new WilczeJagody(swiat, px, py);
                    break;
                }
                case "Antylopa": {
                    org = new Antylopa(swiat, px, py);
                    break;
                }
                case "Czlowiek": {
                    org = new Czlowiek(swiat, px, py);
                    swiat.setCzlowiek((Czlowiek) org);
                    break;
                }
                case "Lis": {
                    org = new Lis(swiat, px, py);
                    break;
                }
                case "Owca": {
                    org = new Owca(swiat, px, py);
                    break;
                }
                case "Wilk": {
                    org = new Wilk(swiat, px, py);
                    break;
                }
                case "Zolw": {
                    org = new Zolw(swiat, px, py);
                    break;
                }
                default: {
                    org = new Trawa(swiat, px, py);
                    break;
                }
            }
            org.setInicjatywa(inicjatywa);
            org.setSila(sila);
            org.setWiek(wiek);
            swiat.addOrganizm(org);
        }
        return swiat;
    }
}
