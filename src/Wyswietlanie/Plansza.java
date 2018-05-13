package Wyswietlanie;

import javax.swing.*;
import java.awt.*;

class Plansza extends JPanel {
    private int x, y;
    private JPanel plansza;

    Plansza(int x, int y) {
        this.x = x;
        this.y = y;
        plansza = new JPanel();
        plansza.setBorder(BorderFactory.createTitledBorder("Plansza"));
        GridLayout gridLayout = new GridLayout(y, x);
        plansza.setLayout(gridLayout);
        for (int i = 0; i < x * y; i++) {
            JButton b = new JButton();
            b.setBackground(Color.WHITE);
            b.setMinimumSize(new Dimension(25, 25));
            b.setPreferredSize(new Dimension(25, 25));
            plansza.add(b);
        }
    }

    JPanel getPanel() {
        return plansza;
    }
}
