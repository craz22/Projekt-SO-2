package Gra.Wyswietlanie;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.*;

import Gra.Swiat;

import java.awt.*;

class Menu extends JPanel {
    private int y;
    private JPanel menu;
    private JScrollPane scrollPane;
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

        //Komentarze
        scrollPane = WypiszKomentarze(swiat);

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
        menu.add(scrollPane);
    }

    JPanel getPanel() {
        return menu;
    }

    void setKomentarze(Swiat swiat){
        this.scrollPane = WypiszKomentarze(swiat);
    }

    private JScrollPane WypiszKomentarze(Swiat swiat){
        StyleContext context = new StyleContext();
        StyledDocument document = new DefaultStyledDocument(context);

        Style style = context.getStyle(StyleContext.DEFAULT_STYLE);
        StyleConstants.setAlignment(style, StyleConstants.ALIGN_RIGHT);
        StyleConstants.setFontSize(style, 14);
        StyleConstants.setSpaceAbove(style, 4);
        StyleConstants.setSpaceBelow(style, 4);

        SimpleAttributeSet attributes = new SimpleAttributeSet();
        StyleConstants.setBold(attributes, true);
        StyleConstants.setItalic(attributes, true);
        if(!swiat.getKomentarze().isEmpty()){
            for (String komentarz:swiat.getKomentarze()) {
                try {
                    document.insertString(document.getLength(), komentarz+"\n", attributes);
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
            }
        }
        JTextPane textPane = new JTextPane(document);
        textPane.setEditable(false);
        return new JScrollPane(textPane);
    }
}
