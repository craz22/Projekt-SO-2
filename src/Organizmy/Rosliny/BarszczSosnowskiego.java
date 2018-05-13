package Organizmy.Rosliny;

import Organizmy.Wspolrzedne;

public class BarszczSosnowskiego implements Roslina {
    private int sila, inicjatywa, wiek;
    private Wspolrzedne polozenie;
    public BarszczSosnowskiego(int x, int y) {
        this.inicjatywa = 0;
        this.sila = 10;
        this.wiek = 0;
        this.polozenie = new Wspolrzedne(x,y);
    }

    @Override
    public void Akcja() {

    }

    @Override
    public String Rysuj() {
        return null;
    }

    @Override
    public void Kolizja() {

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
        return polozenie;
    }

    public void setPolozenie(Wspolrzedne polozenie) {
        this.polozenie = polozenie;
    }
}
