package Gra;

import Gra.Organizmy.Zwierzeta.Czlowiek;
import Gra.Wyswietlanie.Gra;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Swiat swiat = new Swiat(10, 10);
        new Gra(swiat);
    }
}
