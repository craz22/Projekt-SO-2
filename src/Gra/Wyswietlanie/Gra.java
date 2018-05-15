package Gra.Wyswietlanie;

import javax.swing.*;
import java.awt.*;

import Gra.Swiat;

public class Gra extends JFrame {
    private Plansza plansza;
    private Menu menu;
    private JFrame f;

    public Gra(Swiat swiat) {
        BorderLayout borderLayout = new BorderLayout(7, 0);
        f = new JFrame("Gerard Wiśniewski s174297");
        f.setLayout(borderLayout);
        plansza = new Plansza(swiat, this, swiat.getX(), swiat.getY());
        menu = new Menu(swiat, this);
        Dimension rozmiarMenu = new Dimension(250,f.getHeight());
        menu.getPanel().setPreferredSize(rozmiarMenu);
        f.add(menu.getPanel(), BorderLayout.EAST);
        f.add(plansza.getPanel(), BorderLayout.CENTER);
        plansza.RysujPlansze(swiat);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(500, 500);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    void newPlansza(Swiat swiat) {
        f.remove(plansza.getPanel());
        this.plansza = new Plansza(swiat, this, swiat.getX(), swiat.getY());
        f.add(plansza.getPanel(), BorderLayout.CENTER);
        plansza.RysujPlansze(swiat);
        f.revalidate();
        f.repaint();
    }

    void wypiszKomentarze(Swiat swiat){
        this.menu.setKomentarze(swiat);
        f.revalidate();
        f.repaint();
    }
}
