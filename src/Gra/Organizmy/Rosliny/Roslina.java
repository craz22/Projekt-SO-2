package Gra.Organizmy.Rosliny;


import Gra.Organizmy.Organizm;

public interface Roslina extends Organizm {
    @Override
    void Akcja();

    @Override
    String Rysuj();

    @Override
    void Kolizja();
}
