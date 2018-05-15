package Gra;

import Gra.Wyswietlanie.Gra;

public class Main {

    public static void main(String[] args) {
        Swiat swiat = new Swiat(10, 10);
        new Gra(swiat);
    }
}
