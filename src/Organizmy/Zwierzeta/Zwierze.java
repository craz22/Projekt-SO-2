package Organizmy.Zwierzeta;

import Organizmy.Organizm;

public interface Zwierze extends Organizm {
    @Override
    String Rysuj();

    @Override
    void Kolizja();

    @Override
    void Akcja();
}
