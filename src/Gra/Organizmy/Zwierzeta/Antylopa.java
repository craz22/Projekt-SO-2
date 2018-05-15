package Gra.Organizmy.Zwierzeta;


import Gra.Organizmy.Organizm;
import Gra.Organizmy.Wspolrzedne;
import Gra.Swiat;

import java.awt.*;
import java.util.Random;
import java.util.Vector;

public class Antylopa implements Zwierze {
    private int sila, inicjatywa, wiek;
    private Wspolrzedne polozenie;
    private Swiat swiat;
    private Color color;

    public Antylopa(Swiat swiat, int x, int y) {
        this.swiat = swiat;
        this.sila = 4;
        this.inicjatywa = 4;
        this.wiek = 0;
        this.polozenie = new Wspolrzedne(x, y);
        this.color = Color.CYAN;
    }

    @Override
    public String Rysuj() {
        return "A";
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void Kolizja(Swiat swiat, Organizm atakujacy) {
        //wylosowanie czy ucieknie
        Random generator = new Random();
        int los = generator.nextInt(2);
        if (los == 0) {
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
            //wylosowanie wspolrzednych
            if (!tablica.isEmpty()) {
                los = generator.nextInt(tablica.size());
                swiat.moveOrganizm(this, tablica.elementAt(los).getY(), tablica.elementAt(los).getX());
            }
            //jesli nie ma wolnych miejsc
            else {
                if (atakujacy.getSila() > getSila()) {
                    swiat.zabij(this);
                    swiat.moveOrganizm(atakujacy, getPolozenie().getY(), getPolozenie().getX());
                } else {
                    swiat.zabij(atakujacy);
                }
            }
        } else {
            if (atakujacy.getSila() > getSila()) {
                swiat.zabij(this);
                swiat.moveOrganizm(atakujacy, getPolozenie().getY(), getPolozenie().getX());
            } else {
                swiat.zabij(atakujacy);
            }
        }
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void Akcja(Swiat swiat) {
        Random generator = new Random();
        int py = 0, px = 0, los;
        //losowanie czy poruszy sie pionowo, poziomo czy po skosie
        los = generator.nextInt(3);
        switch (los) {
            //pionowo
            case 0: {
                py = getPY(swiat);
                break;
            }
            //poziomo
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

    @SuppressWarnings("Duplicates")
    @Override
    public int getPX(Swiat swiat) {
        Random generator = new Random();
        int px, los;


        //jesli stoi przy lewej krawedzi
        if (getPolozenie().getX() == 0) {
            //o ile pol w dol sie ruszy
            los = generator.nextInt(2);
            //o 1 pole
            if (los == 0) {
                px = 1;
            } else {
                px = 2;
            }
        }


        //jesli stoi o 1 miejsce od lewej krawedzi
        else if (getPolozenie().getX() == 1) {
            //czy ruszy sie w lewo czy w prawo
            los = generator.nextInt(2);
            //w lewo
            if (los == 0) {
                px = -1;
            }
            //w prawo
            else {
                //o ile pol sie ruszy
                los = generator.nextInt(2);
                //o 1
                if (los == 0) {
                    px = 1;
                }
                //o 2
                else {
                    px = 2;
                }
            }
        }

        //jesli stoi przy prawej krawedzi
        else if (getPolozenie().getX() == swiat.getX() - 1) {
            //o ile pol sie ruszy
            los = generator.nextInt(2);
            //o 1
            if (los == 0) {
                px = -1;
            }
            //o 2
            else {
                px = -2;
            }
        }

        //jesli stoi o 1 miejsce od prawej krawedzi
        else if (getPolozenie().getX() == swiat.getX() - 2) {
            //czy ruszy sie w lewo czy prawo
            los = generator.nextInt(2);
            //w lewo
            if (los == 0) {
                //o ile pol sie ruszy
                los = generator.nextInt(2);
                //o 1
                if (los == 0) {
                    px = -1;
                }
                //o 2
                else {
                    px = -2;
                }
            }
            //w prawo
            else {
                px = 1;
            }
        }

        //jesli nie ma zadnego problemu
        else {
            //o ile pol sie ruszy
            los = generator.nextInt(2);
            //o 1
            if (los == 0) {
                px = 1;
            }
            //o 2
            else {
                px = 2;
            }
            //czy ruszy sie w gore czy w dol
            los = generator.nextInt(2);
            //w gore
            if (los == 0) {
                px *= -1;
            }
            //jesli w dol to jest dobrze
        }
        return px;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public int getPY(Swiat swiat) {
        Random generator = new Random();
        int py, los;


        //jesli stoi przy gornej krawedzi
        if (getPolozenie().getY() == 0) {
            //o ile pol w dol sie ruszy
            los = generator.nextInt(2);
            //o 1 pole
            if (los == 0) {
                py = 1;
            } else {
                py = 2;
            }
        }


        //jesli stoi o 1 miejsce od gornej krawedzi
        else if (getPolozenie().getY() == 1) {
            //czy ruszy sie w gore czy w dol
            los = generator.nextInt(2);
            //w gore
            if (los == 0) {
                py = -1;
            }
            //w dol
            else {
                //o ile pol sie ruszy
                los = generator.nextInt(2);
                //o 1
                if (los == 0) {
                    py = 1;
                }
                //o 2
                else {
                    py = 2;
                }
            }
        }

        //jesli stoi przy dolnej krawedzi
        else if (getPolozenie().getY() == swiat.getY() - 1) {
            //o ile pol sie ruszy
            los = generator.nextInt(2);
            //o 1
            if (los == 0) {
                py = -1;
            }
            //o 2
            else {
                py = -2;
            }
        }

        //jesli stoi o 1 miejsce od dolnej krawedzi
        else if (getPolozenie().getY() == swiat.getY() - 2) {
            //czy ruszy sie w gore czy w dol
            los = generator.nextInt(2);
            //w gore
            if (los == 0) {
                //o ile pol sie ruszy
                los = generator.nextInt(2);
                //o 1
                if (los == 0) {
                    py = -1;
                }
                //o 2
                else {
                    py = -2;
                }
            }
            //w dol
            else {
                py = 1;
            }
        }

        //jesli nie ma zadnego problemu
        else {
            //o ile pol sie ruszy
            los = generator.nextInt(2);
            //o 1
            if (los == 0) {
                py = 1;
            }
            //o 2
            else {
                py = 2;
            }
            //czy ruszy sie w gore czy w dol
            los = generator.nextInt(2);
            //w gore
            if (los == 0) {
                py *= -1;
            }
            //jesli w dol to jest dobrze
        }
        return py;
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
