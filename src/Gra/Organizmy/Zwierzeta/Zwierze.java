package Gra.Organizmy.Zwierzeta;

import Gra.Organizmy.Organizm;

public interface Zwierze extends Organizm {
    @Override
    String Rysuj();

    @Override
    void Kolizja();

    @Override
    void Akcja();
}
