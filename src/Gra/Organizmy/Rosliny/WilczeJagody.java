package Gra.Organizmy.Rosliny;


import Gra.Organizmy.Wspolrzedne;
import Gra.Swiat;

public class WilczeJagody implements Roslina {
    private int sila, inicjatywa, wiek;
    private Wspolrzedne polozenie;
    private Swiat swiat;
    public WilczeJagody(Swiat swiat, int x, int y) {
        this.sila = 99;
        this.inicjatywa = 0;
        this.wiek = 0;
        this.polozenie = new Wspolrzedne(x, y);
        this.swiat = swiat;
    }

    @Override
    public void Akcja() {

    }

    @Override
    public String Rysuj() {
        return "J";
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
        return this.polozenie;
    }

    public void setPolozenie(Wspolrzedne polozenie) {
        this.polozenie = polozenie;
    }
}