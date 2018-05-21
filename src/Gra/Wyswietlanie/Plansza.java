package Gra.Wyswietlanie;

import Gra.Swiat;

import javax.swing.*;
import java.awt.*;

class Plansza extends JPanel {
    private int x, y;
    private JPanel plansza;
    private JButton[][] buttons;

    Plansza(Swiat swiat, Gra gra, int x, int y) {
        this.x = x;
        this.y = y;
        plansza = setPlansza(swiat);
    }

    JPanel getPanel() {
        return plansza;
    }

    void setPanel(JPanel panel) {
        this.plansza = panel;
    }

    JButton[][] getButtons() {
        return buttons;
    }

    private JPanel setPlansza(Swiat swiat) {
        this.x = swiat.getX();
        this.y = swiat.getY();
        JPanel plansza = new JPanel();
        plansza.setBorder(BorderFactory.createTitledBorder("Plansza"));
        GridLayout gridLayout = new GridLayout(y, x);
        plansza.setLayout(gridLayout);
        buttons = new JButton[swiat.getY()][swiat.getX()];
        for (int i = 0; i < swiat.getY(); i++) {
            for (int j = 0; j < swiat.getX(); j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setBackground(Color.WHITE);
                buttons[i][j].setMinimumSize(new Dimension(60, 60));
                buttons[i][j].setPreferredSize(new Dimension(60, 60));
                plansza.add(buttons[i][j]);
            }
        }
        return plansza;
    }

    void RysujPlansze(Swiat swiat) {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (swiat.getOrganizm(i, j) == null) {
                    buttons[i][j].setText("");
                    buttons[i][j].setBackground(Color.white);
                } else {
                    buttons[i][j].setText(swiat.getOrganizm(i, j).Rysuj());
                    buttons[i][j].setBackground(swiat.getOrganizm(i, j).getColor());
                }

            }
        }
    }
}
