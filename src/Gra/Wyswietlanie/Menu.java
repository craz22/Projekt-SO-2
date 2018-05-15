package Gra.Wyswietlanie;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Gra.Swiat;

import java.awt.*;

class Menu extends JPanel {
    private int y;
    private JPanel menu;

    Menu(Swiat swiat, Gra gra) {
        menu = new JPanel();
        menu.setBorder(BorderFactory.createTitledBorder("Menu"));
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        JLabel rozmiar = new JLabel("Rozmiar");
        rozmiar.setAlignmentX(CENTER_ALIGNMENT);

        //SPINNER X
        SpinnerModel spinnerModelX = new SpinnerNumberModel(swiat.getX(), 5, 100, 1);
        JSpinner spinnerX = new JSpinner(spinnerModelX);
        spinnerX.addChangeListener(e -> {
            JSpinner s = (JSpinner) e.getSource();
            swiat.setX((Integer) s.getValue());
            gra.newPlansza(swiat);
        });


        JLabel x = new JLabel("X");
        x.setAlignmentX(CENTER_ALIGNMENT);

        //SPINNERY
        SpinnerModel spinnerModelY = new SpinnerNumberModel(swiat.getY(), 5, 100, 1);
        JSpinner spinnerY = new JSpinner(spinnerModelY);
        Dimension spinnersize = new Dimension(50, 25);
        spinnerY.addChangeListener(e -> {
            JSpinner s = (JSpinner) e.getSource();
            swiat.setY((Integer) s.getValue());
            gra.newPlansza(swiat);
        });


        spinnerX.setPreferredSize(spinnersize);
        spinnerX.setMinimumSize(spinnersize);
        spinnerX.setMaximumSize(spinnersize);
        spinnerY.setPreferredSize(spinnersize);
        spinnerY.setMinimumSize(spinnersize);
        spinnerY.setMaximumSize(spinnersize);
        JLabel kierunekLabael = new JLabel("Kierunek:");
        kierunekLabael.setAlignmentX(CENTER_ALIGNMENT);
        JLabel kierunek = new JLabel(swiat.getKierunek());
        kierunek.setAlignmentX(CENTER_ALIGNMENT);
        menu.add(rozmiar);
        menu.add(spinnerX);
        menu.add(x);
        menu.add(spinnerY);
        menu.add(kierunekLabael);
        menu.add(kierunek);
    }

    JPanel getPanel() {
        return menu;
    }
}
