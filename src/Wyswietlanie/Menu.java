package Wyswietlanie;

import javax.swing.*;

class Menu extends JPanel {
    private int y;
    private JPanel menu;

    Menu(int y) {
        this.y = y;
        menu = new JPanel();
        menu.setBorder(BorderFactory.createTitledBorder("Menu"));
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        for (int i = 0; i < y; i++) {
            JButton b = new JButton("Button" + i);
            menu.add(b);
        }
    }

    JPanel getPanel() {
        return menu;
    }
}
