package Gra;

import Gra.Organizmy.Zwierzeta.Czlowiek;
import Gra.Wyswietlanie.Gra;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Swiat swiat = new Swiat(10,10);
        int rx, ry;
        Random generator = new Random();
        rx = generator.nextInt(swiat.getX());
        ry = generator.nextInt(swiat.getY());
        Czlowiek czlowiek = new Czlowiek(swiat,rx,ry);
        swiat.addOrganizm(czlowiek);
        swiat.randOrganizm(swiat);
        new Gra(swiat);
    }
}
