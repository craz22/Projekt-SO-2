package Gra.Wyswietlanie;

import Gra.Organizmy.Organizm;
import Gra.Organizmy.Rosliny.*;
import Gra.Organizmy.Zwierzeta.*;
import Gra.Swiat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

public class Gra extends JFrame implements KeyEventDispatcher {
    private Plansza plansza;
    private Menu menu;
    private Swiat swiat;
    private JButton tura;
    private JButton umiejetnosc;
    private JButton save;
    private JButton load;

    public Gra(Swiat swiat) {
        super("Gerard Wiśniewski s174297");
        this.swiat = swiat;
        BorderLayout borderLayout = new BorderLayout(7, 0);
        setLayout(borderLayout);
        setFocusable(true);
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(this);
        plansza = new Plansza(swiat, this, swiat.getX(), swiat.getY());
        tura = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tura();
            }
        });
        tura.setText("Tura");
        tura.setFocusable(false);
        umiejetnosc = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Umiejetnosc();
            }
        });
        umiejetnosc.setText("Umiejetnosc specjalna");
        umiejetnosc.setFocusable(false);
        save = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Save();
            }
        });
        save.setText("Save");
        save.setFocusable(false);
        load = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Load();
            }
        });
        load.setText("Load");
        load.setFocusable(false);
        JPanel south = new JPanel();
        south.add(tura);
        south.add(umiejetnosc);
        south.add(save);
        south.add(load);
        menu = new Menu(swiat, this);
        Dimension rozmiarMenu = new Dimension(250, getHeight());
        menu.getPanel().setPreferredSize(rozmiarMenu);
        for (int i = 0; i < plansza.getButtons().length; i++) {
            for (int j = 0; j < plansza.getButtons()[i].length; j++) {
                int finalI = i;
                int finalJ = j;
                plansza.getButtons()[i][j].addActionListener(e -> {
                    if (plansza.getButtons()[finalI][finalJ].getText().equals("")) {
                        Object[] possibleValues = {"BarszczSosnowskiego", "Guarana", "Mlecz", "Trawa", "WilczeJagody", "Antylopa", "Lis", "Owca", "Wilk", "Zolw"};
                        JOptionPane optionPane = new JOptionPane();
                        optionPane.setFocusable(false);
                        Object selectedValue = JOptionPane.showInputDialog(null, "Wybierz zwierze", "Tworzenie zwierzecia", JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
                        Organizm org;
                        int px = finalJ;
                        int py = finalI;

                        if (selectedValue != null) {
                            switch (selectedValue.toString()) {
                                case "BarszczSosnowskiego": {
                                    org = new BarszczSosnowskiego(swiat, px, py);
                                    break;
                                }
                                case "Guarana": {
                                    org = new Guarana(swiat, px, py);
                                    break;
                                }
                                case "Mlecz": {
                                    org = new Mlecz(swiat, px, py);
                                    break;
                                }
                                case "Trawa": {
                                    org = new Trawa(swiat, px, py);
                                    break;
                                }
                                case "WilczeJagody": {
                                    org = new WilczeJagody(swiat, px, py);
                                    break;
                                }
                                case "Antylopa": {
                                    org = new Antylopa(swiat, px, py);
                                    break;
                                }
                                case "Lis": {
                                    org = new Lis(swiat, px, py);
                                    break;
                                }
                                case "Owca": {
                                    org = new Owca(swiat, px, py);
                                    break;
                                }
                                case "Wilk": {
                                    org = new Wilk(swiat, px, py);
                                    break;
                                }
                                case "Zolw": {
                                    org = new Zolw(swiat, px, py);
                                    break;
                                }
                                default: {
                                    org = new Trawa(swiat, px, py);
                                    break;
                                }
                            }
                            swiat.addOrganizm(org);
                            setPlansza(swiat);
                        }
                    }
                });
            }
        }
        add(menu.getPanel(), BorderLayout.EAST);
        add(plansza.getPanel(), BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);
        plansza.RysujPlansze(swiat);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        requestFocus();
    }

    void newPlansza(Swiat swiat) {
        remove(plansza.getPanel());
        this.plansza = new Plansza(swiat, this, swiat.getX(), swiat.getY());
        add(plansza.getPanel(), BorderLayout.CENTER);
        for (int i = 0; i < plansza.getButtons().length; i++) {
            for (int j = 0; j < plansza.getButtons()[i].length; j++) {
                int finalI = i;
                int finalJ = j;
                plansza.getButtons()[i][j].addActionListener(e -> {
                    if (plansza.getButtons()[finalI][finalJ].getText().equals("")) {
                        Object[] possibleValues = {"BarszczSosnowskiego", "Guarana", "Mlecz", "Trawa", "WilczeJagody", "Antylopa", "Lis", "Owca", "Wilk", "Zolw"};
                        JOptionPane optionPane = new JOptionPane();
                        optionPane.setFocusable(false);
                        Object selectedValue = JOptionPane.showInputDialog(null, "Wybierz zwierze", "Tworzenie zwierzecia", JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
                        Organizm org;
                        int px = finalJ;
                        int py = finalI;

                        if (selectedValue != null) {
                            switch (selectedValue.toString()) {
                                case "BarszczSosnowskiego": {
                                    org = new BarszczSosnowskiego(swiat, px, py);
                                    break;
                                }
                                case "Guarana": {
                                    org = new Guarana(swiat, px, py);
                                    break;
                                }
                                case "Mlecz": {
                                    org = new Mlecz(swiat, px, py);
                                    break;
                                }
                                case "Trawa": {
                                    org = new Trawa(swiat, px, py);
                                    break;
                                }
                                case "WilczeJagody": {
                                    org = new WilczeJagody(swiat, px, py);
                                    break;
                                }
                                case "Antylopa": {
                                    org = new Antylopa(swiat, px, py);
                                    break;
                                }
                                case "Lis": {
                                    org = new Lis(swiat, px, py);
                                    break;
                                }
                                case "Owca": {
                                    org = new Owca(swiat, px, py);
                                    break;
                                }
                                case "Wilk": {
                                    org = new Wilk(swiat, px, py);
                                    break;
                                }
                                case "Zolw": {
                                    org = new Zolw(swiat, px, py);
                                    break;
                                }
                                default: {
                                    org = new Trawa(swiat, px, py);
                                    break;
                                }
                            }
                            swiat.addOrganizm(org);
                            setPlansza(swiat);
                        }
                    }
                });
            }
        }
        plansza.RysujPlansze(swiat);
        menu.setSpinners(swiat);
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
    public boolean dispatchKeyEvent(KeyEvent e) {
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
                return false;
            }
        }
        return false;
    }

    private void Tura() {
        swiat.wykonajTure();
        wypiszKomentarze(swiat);
        setPlansza(swiat);
    }

    private void Umiejetnosc() {
        if (swiat.getLicznikSpecjalny() == 0) {
            swiat.setLicznikSpecjalny(swiat.getLicznikSpecjalny() + 1);
        }
    }

    private void Save() {
        swiat.save();
    }

    private void Load() {
        try {
            swiat = swiat.load();
            newPlansza(swiat);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}
