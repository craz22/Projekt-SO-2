package Game;

import Game.UI.Game;

import java.awt.*;

class Main {

    public static void main(String[] args) {
        World world = new World(10, 10);
        world.randOrganisms(world);
        EventQueue.invokeLater(() -> new Game(world));
    }
}
