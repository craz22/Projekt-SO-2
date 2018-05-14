package Gra.Wyswietlanie;

import javax.swing.*;
import java.awt.*;
import Gra.Swiat;
public class Gra extends JFrame {
    public Gra(Swiat swiat) {
        BorderLayout borderLayout = new BorderLayout(7, 0);
        JFrame f = new JFrame("Gerard Wiśniewski s174297");
        f.setLayout(borderLayout);
        Plansza plansza = new Plansza(swiat, swiat.getX(), swiat.getY());
        Menu menu = new Menu(swiat);
        f.add(menu.getPanel(), BorderLayout.EAST);
        f.add(plansza.getPanel(), BorderLayout.CENTER);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(500, 500);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
