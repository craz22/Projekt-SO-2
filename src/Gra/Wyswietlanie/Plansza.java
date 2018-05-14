package Gra.Wyswietlanie;

import javax.swing.*;
import java.awt.*;
import Gra.Swiat;

class Plansza extends JPanel {
    private int x, y;
    private JPanel plansza;

    Plansza(Swiat swiat, int x, int y) {
        this.x = x;
        this.y = y;
        plansza = new JPanel();
        plansza.setBorder(BorderFactory.createTitledBorder("Plansza"));
        GridLayout gridLayout = new GridLayout(y, x);
        plansza.setLayout(gridLayout);
        for (int i = 0; i < y; i++) {
            for (int j=0; j<x; j++){
                JButton b;
                if(swiat.getOrganizm(i,j) == null){
                    b = new JButton();
                }
                else{
                    b = new JButton(swiat.getOrganizm(i,j).Rysuj());
                }
                b.setBackground(Color.WHITE);
                b.setMinimumSize(new Dimension(50, 50));
                b.setPreferredSize(new Dimension(50, 50));
                plansza.add(b);
            }
        }
    }

    JPanel getPanel() {
        return plansza;
    }
}
