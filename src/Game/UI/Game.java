package Game.UI;

import Game.Organisms.Animals.*;
import Game.Organisms.Organism;
import Game.Organisms.Plants.*;
import Game.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

public class Game extends JFrame implements KeyEventDispatcher {
    private Board board;
    private Menu menu;
    private World world;

    public Game(World world) {
        super("Gerard Wiśniewski virtual world simulator");
        this.world = world;
        BorderLayout borderLayout = new BorderLayout(7, 0);
        setLayout(borderLayout);
        setFocusable(true);
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(this);
        board = new Board(world, world.getX(), world.getY());
        JButton round = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Round();
            }
        });
        round.setText("Round");
        round.setFocusable(false);
        JButton skill = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Skill();
            }
        });
        skill.setText("Special ability");
        skill.setFocusable(false);
        JButton save = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Save();
            }
        });
        save.setText("Save");
        save.setFocusable(false);
        JButton load = new JButton(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Load();
            }
        });
        load.setText("Load");
        load.setFocusable(false);
        JPanel south = new JPanel();
        south.add(round);
        south.add(skill);
        south.add(save);
        south.add(load);
        menu = new Menu(world, this);
        Dimension menusize = new Dimension(250, getHeight());
        menu.getPanel().setPreferredSize(menusize);
        for (int i = 0; i < board.getButtons().length; i++) {
            for (int j = 0; j < board.getButtons()[i].length; j++) {
                int finalI = i;
                int finalJ = j;
                board.getButtons()[i][j].addActionListener(e -> {
                    if (board.getButtons()[finalI][finalJ].getText().equals("")) {
                        Object[] possibleValues = {"SosnowskyHogweed", "Guarana", "MilkSowthistle", "Grass", "PoisonBerries", "Antelope", "Fox", "Sheep", "Wolf", "Turtle"};
                        JOptionPane optionPane = new JOptionPane();
                        optionPane.setFocusable(false);
                        Object selectedValue = JOptionPane.showInputDialog(null, "Choose an animal", "Creating animals", JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
                        Organism org;
                        if (selectedValue != null) {
                            switch (selectedValue.toString()) {
                                case "SosnowskyHogweed": {
                                    org = new SosnowskyHogweed(finalJ, finalI);
                                    break;
                                }
                                case "Guarana": {
                                    org = new Guarana(finalJ, finalI);
                                    break;
                                }
                                case "MilkSowthistle": {
                                    org = new MilkSowthistle(finalJ, finalI);
                                    break;
                                }
                                case "Grass": {
                                    org = new Grass(finalJ, finalI);
                                    break;
                                }
                                case "PoisonBerries": {
                                    org = new PoisonBerries(finalJ, finalI);
                                    break;
                                }
                                case "Antelope": {
                                    org = new Antelope(finalJ, finalI);
                                    break;
                                }
                                case "Fox": {
                                    org = new Fox(finalJ, finalI);
                                    break;
                                }
                                case "Sheep": {
                                    org = new Sheep(finalJ, finalI);
                                    break;
                                }
                                case "Wolf": {
                                    org = new Wolf(finalJ, finalI);
                                    break;
                                }
                                case "Turtle": {
                                    org = new Turtle(finalJ, finalI);
                                    break;
                                }
                                default: {
                                    org = new Grass(finalJ, finalI);
                                    break;
                                }
                            }
                            world.addOrganism(org);
                            setBoard(world);
                        }
                    }
                });
            }
        }
        add(menu.getPanel(), BorderLayout.EAST);
        add(board.getPanel(), BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);
        board.drawBoard(world);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        requestFocus();
    }

    void newBoard(World world) {
        remove(board.getPanel());
        this.board = new Board(world, world.getX(), world.getY());
        add(board.getPanel(), BorderLayout.CENTER);
        for (int i = 0; i < board.getButtons().length; i++) {
            for (int j = 0; j < board.getButtons()[i].length; j++) {
                int finalI = i;
                int finalJ = j;
                board.getButtons()[i][j].addActionListener(e -> {
                    if (board.getButtons()[finalI][finalJ].getText().equals("")) {
                        Object[] possibleValues = {"SosnowskyHogweed", "Guarana", "MilkSowthistle", "Grass", "PoisonBerries", "Antelope", "Fox", "Sheep", "Wolf", "Turtle"};
                        JOptionPane optionPane = new JOptionPane();
                        optionPane.setFocusable(false);
                        Object selectedValue = JOptionPane.showInputDialog(null, "Choose animal", "Creating animals", JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
                        Organism org;

                        if (selectedValue != null) {
                            switch (selectedValue.toString()) {
                                case "SosnowskyHogweed": {
                                    org = new SosnowskyHogweed(finalJ, finalI);
                                    break;
                                }
                                case "Guarana": {
                                    org = new Guarana(finalJ, finalI);
                                    break;
                                }
                                case "MilkSowthistle": {
                                    org = new MilkSowthistle(finalJ, finalI);
                                    break;
                                }
                                case "Grass": {
                                    org = new Grass(finalJ, finalI);
                                    break;
                                }
                                case "PoisonBerries": {
                                    org = new PoisonBerries(finalJ, finalI);
                                    break;
                                }
                                case "Antelope": {
                                    org = new Antelope(finalJ, finalI);
                                    break;
                                }
                                case "Fox": {
                                    org = new Fox(finalJ, finalI);
                                    break;
                                }
                                case "Sheep": {
                                    org = new Sheep(finalJ, finalI);
                                    break;
                                }
                                case "Wolf": {
                                    org = new Wolf(finalJ, finalI);
                                    break;
                                }
                                case "Turtle": {
                                    org = new Turtle(finalJ, finalI);
                                    break;
                                }
                                default: {
                                    org = new Grass(finalJ, finalI);
                                    break;
                                }
                            }
                            world.addOrganism(org);
                            setBoard(world);
                        }
                    }
                });
            }
        }
        board.drawBoard(world);
        menu.setSpinners(world);
        revalidate();
        repaint();
    }

    private void setBoard(World world) {
        board.drawBoard(world);
        revalidate();
        repaint();
    }

    private void writeComments(World world) {
        remove(menu.getPanel());
        this.menu = new Menu(world, this);
        add(menu.getPanel(), BorderLayout.EAST);
        revalidate();
        repaint();
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        int direction = e.getKeyCode();
        switch (direction) {
            case KeyEvent.VK_DOWN: {
                world.setDirection("down");
                menu.setDirection(world);
                revalidate();
                repaint();
                break;
            }
            case KeyEvent.VK_UP: {
                world.setDirection("up");
                menu.setDirection(world);
                revalidate();
                repaint();
                break;
            }
            case KeyEvent.VK_LEFT: {
                world.setDirection("left");
                menu.setDirection(world);
                revalidate();
                repaint();
                break;
            }
            case KeyEvent.VK_RIGHT: {
                world.setDirection("right");
                menu.setDirection(world);
                revalidate();
                repaint();
                break;
            }
            case KeyEvent.VK_SPACE: {
                Round();
                break;
            }
            default: {
                return false;
            }
        }
        return false;
    }

    private void Round() {
        world.makeRound();
        writeComments(world);
        setBoard(world);
    }

    private void Skill() {
        if (world.getSpecialCounter() == 0) {
            world.setSpecialCounter(world.getSpecialCounter() + 1);
        }
    }

    private void Save() {
        world.save();
    }

    private void Load() {
        try {
            world = world.load();
            newBoard(world);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}
