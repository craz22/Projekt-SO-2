package Wyswietlanie;

import javax.swing.*;
import java.awt.*;

public class Gra extends JFrame {
    public Gra(){
        BorderLayout borderLayout = new BorderLayout(7,0);
        JFrame f = new JFrame();
        f.setLayout(borderLayout);
        JPanel plansza = new JPanel();
        GridLayout gridLayout = new GridLayout(5,5);
        plansza.setLayout(gridLayout);
        for(int i=0; i<25; i++){
            JButton b = new JButton("Button"+i);
            plansza.add(b);
        }
        JPanel menu = new JPanel();
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        for(int i=0; i<5; i++) {
            JButton b = new JButton("Button" + i);
            menu.add(b);
        }
        f.add(menu,BorderLayout.EAST);
        f.add(plansza,BorderLayout.CENTER);
        f.setLocationRelativeTo(null);
        f.setSize(300,300);
        f.pack();
        f.setVisible(true);
    }
}
