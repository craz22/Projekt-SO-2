package Gra.Wyswietlanie;

import Gra.Swiat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gra extends JFrame implements KeyListener {
    private Plansza plansza;
    private Menu menu;
    private Swiat swiat;

    public Gra(Swiat swiat) {
        super("Gerard Wiśniewski s174297");
        this.swiat = swiat;
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        BorderLayout borderLayout = new BorderLayout(7, 0);
        setLayout(borderLayout);
        plansza = new Plansza(swiat, this, swiat.getX(), swiat.getY());

        menu = new Menu(swiat, this);
        Dimension rozmiarMenu = new Dimension(250, getHeight());
        menu.getPanel().setPreferredSize(rozmiarMenu);


        add(menu.getPanel(), BorderLayout.EAST);
        add(plansza.getPanel(), BorderLayout.CENTER);
        plansza.RysujPlansze(swiat);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void newPlansza(Swiat swiat) {
        remove(plansza.getPanel());
        this.plansza = new Plansza(swiat, this, swiat.getX(), swiat.getY());
        add(plansza.getPanel(), BorderLayout.CENTER);
        plansza.RysujPlansze(swiat);
        revalidate();
        repaint();
    }

    void wypiszKomentarze(Swiat swiat) {
        this.menu.setKomentarze(swiat);
        revalidate();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int kierunek = e.getKeyCode();
        switch (kierunek) {
            //w dol
            case KeyEvent.VK_DOWN: {
                swiat.setKierunek("dol");
                menu.setKierunek(swiat);
                revalidate();
                repaint();
                break;
            }
            //w gore
            case KeyEvent.VK_UP: {
                swiat.setKierunek("gora");
                menu.setKierunek(swiat);
                revalidate();
                repaint();
                break;
            }
            //w lewo
            case KeyEvent.VK_LEFT: {
                swiat.setKierunek("lewa");
                menu.setKierunek(swiat);
                revalidate();
                repaint();
                break;
            }
            //w prawo
            case KeyEvent.VK_RIGHT: {
                swiat.setKierunek("prawa");
                menu.setKierunek(swiat);
                revalidate();
                repaint();
                break;
            }
            default: {
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
