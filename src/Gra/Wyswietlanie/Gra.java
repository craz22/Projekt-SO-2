package Gra.Wyswietlanie;

import Gra.Swiat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gra extends JFrame implements ActionListener, KeyListener {
    private Plansza plansza;
    private Menu menu;
    private Swiat swiat;
    private JButton tura;
    private JButton umiejetnosc;
    public Gra(Swiat swiat) {
        super("Gerard Wiśniewski s174297");
        this.swiat = swiat;
        BorderLayout borderLayout = new BorderLayout(7, 0);
        setLayout(borderLayout);
        setFocusable(true);
        addKeyListener(this);
        plansza = new Plansza(swiat, this, swiat.getX(), swiat.getY());
        tura = new JButton("Tura");
        tura.addActionListener(this);
        tura.setFocusable(false);
        umiejetnosc = new JButton("Umiejetnosc specjalna");
        umiejetnosc.addActionListener(this);
        umiejetnosc.setFocusable(false);
        JPanel south = new JPanel();
        south.add(tura);
        south.add(umiejetnosc);
        menu = new Menu(swiat, this);
        Dimension rozmiarMenu = new Dimension(250, getHeight());
        menu.getPanel().setPreferredSize(rozmiarMenu);


        add(menu.getPanel(), BorderLayout.EAST);
        add(plansza.getPanel(), BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);
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

    private void setPlansza(Swiat swiat) {
        plansza.RysujPlansze(swiat);
        revalidate();
        repaint();
    }

    private void wypiszKomentarze(Swiat swiat) {
        remove(menu.getPanel());
        this.menu = new Menu(swiat, this);
        add(menu.getPanel(), BorderLayout.EAST);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == tura) {
            swiat.wykonajTure();
            wypiszKomentarze(swiat);
            setPlansza(swiat);
        } else if (source == umiejetnosc) {
            if (swiat.getLicznikSpecjalny() == 0) {
                swiat.setLicznikSpecjalny(swiat.getLicznikSpecjalny() + 1);
            }
        }
    }
}
