package Gra;

import Gra.Wyswietlanie.Gra;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Swiat swiat = new Swiat(10, 10);
        EventQueue.invokeLater(() -> new Gra(swiat));
    }
}
