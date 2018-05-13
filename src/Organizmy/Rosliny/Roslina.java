package Organizmy.Rosliny;

import Organizmy.Organizm;

public interface Roslina extends Organizm {
    @Override
    void Akcja();

    @Override
    String Rysuj();

    @Override
    void Kolizja();
}
