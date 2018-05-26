package Game.UI;

import Game.World;

import javax.swing.*;
import java.awt.*;

class Board extends JPanel {
    private int x, y;
    private final JPanel board;
    private JButton[][] buttons;

    Board(World world, int x, int y) {
        this.x = x;
        this.y = y;
        board = setBoard(world);
    }

    JPanel getPanel() {
        return board;
    }

    JButton[][] getButtons() {
        return buttons;
    }

    private JPanel setBoard(World world) {
        this.x = world.getX();
        this.y = world.getY();
        JPanel board = new JPanel();
        board.setBorder(BorderFactory.createTitledBorder("Board"));
        GridLayout gridLayout = new GridLayout(y, x);
        board.setLayout(gridLayout);
        buttons = new JButton[world.getY()][world.getX()];
        for (int i = 0; i < world.getY(); i++) {
            for (int j = 0; j < world.getX(); j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setBackground(Color.WHITE);
                buttons[i][j].setMinimumSize(new Dimension(60, 60));
                buttons[i][j].setPreferredSize(new Dimension(60, 60));
                board.add(buttons[i][j]);
            }
        }
        return board;
    }

    void drawBoard(World world) {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (world.getOrganism(i, j) == null) {
                    buttons[i][j].setText("");
                    buttons[i][j].setBackground(Color.white);
                } else {
                    buttons[i][j].setText(world.getOrganism(i, j).Draw());
                    buttons[i][j].setBackground(world.getOrganism(i, j).getColor());
                }

            }
        }
    }
}
