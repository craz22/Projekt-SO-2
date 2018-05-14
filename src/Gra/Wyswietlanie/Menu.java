package Gra.Wyswietlanie;

import javax.swing.*;
import Gra.Swiat;

import java.awt.*;

class Menu extends JPanel {
    private int y;
    private JPanel menu;

    Menu(Swiat swiat) {
        menu = new JPanel();
        menu.setBorder(BorderFactory.createTitledBorder("Menu"));
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        JLabel rozmiar = new JLabel("Rozmiar");
        SpinnerModel spinnerModelX = new SpinnerNumberModel(swiat.getX(),5,100,1);
        JSpinner spinnerX = new JSpinner(spinnerModelX);
        JLabel x = new JLabel("X");
        SpinnerModel spinnerModelY = new SpinnerNumberModel(swiat.getY(),5,100,1);
        JSpinner spinnerY = new JSpinner(spinnerModelY);
        Dimension spinnersize = new Dimension(50,30);
        spinnerX.setPreferredSize(spinnersize);
        spinnerX.setMinimumSize(spinnersize);
        spinnerX.setMaximumSize(spinnersize);
        spinnerY.setPreferredSize(spinnersize);
        spinnerY.setMinimumSize(spinnersize);
        spinnerY.setMaximumSize(spinnersize);

        menu.add(rozmiar);
        menu.add(spinnerX);
        menu.add(x);
        menu.add(spinnerY);
    }

    JPanel getPanel() {
        return menu;
    }
}
