package Gra.Organizmy.Zwierzeta;


import Gra.Organizmy.Wspolrzedne;
import Gra.Swiat;

public class Lis implements Zwierze {
    private int sila, inicjatywa, wiek;
    private Wspolrzedne polozenie;
    private Swiat swiat;
    public Lis(Swiat swiat, int x, int y) {
        this.swiat = swiat;
        this.sila = 3;
        this.inicjatywa = 7;
        this.wiek = 0;
        this.polozenie = new Wspolrzedne(x, y);
    }

    @Override
    public String Rysuj() {
        return "L";
    }

    @Override
    public void Kolizja() {

    }

    @Override
    public void Akcja() {

    }

    @Override
    public int getSila() {
        return sila;
    }

    @Override
    public void setSila(int sila) {
        this.sila = sila;
    }

    @Override
    public int getInicjatywa() {
        return inicjatywa;
    }

    @Override
    public void setInicjatywa(int inicjatywa) {
        this.inicjatywa = inicjatywa;
    }

    @Override
    public int getWiek() {
        return wiek;
    }

    @Override
    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    @Override
    public Wspolrzedne getPolozenie() {
        return this.polozenie;
    }

    @Override
    public void setPolozenie(Wspolrzedne polozenie) {

    }
}
