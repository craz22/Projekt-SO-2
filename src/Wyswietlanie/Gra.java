package Wyswietlanie;

import javax.swing.*;
import java.awt.*;

public class Gra extends JFrame {
    public Gra(){
        BorderLayout borderLayout = new BorderLayout(7,0);
        JFrame f = new JFrame();
        f.setLayout(borderLayout);
        Plansza plansza = new Plansza(7,5);
        Menu menu = new Menu(3);
        f.add(menu.getPanel(),BorderLayout.EAST);
        f.add(plansza.getPanel(),BorderLayout.CENTER);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(500,500);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
