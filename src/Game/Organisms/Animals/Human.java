package Game.Organisms.Animals;


import Game.Organisms.Coordinates;
import Game.World;

import java.awt.*;

public class Human implements Animal {
    private final Color color;
    private int strength, initiative, age;
    private Coordinates coordinates;

    public Human(int x, int y) {
        this.strength = 5;
        this.initiative = 4;
        this.age = 0;
        this.coordinates = new Coordinates(x, y);
        this.color = Color.WHITE;
    }

    @Override
    public String Draw() {
        return "HU";
    }

    @Override
    public void Action(World world) {
        //if special ability is active
        int px = 0, py = 0;
        if (world.getSpecialCounter() > 0 && world.getSpecialCounter() < 6) {
            switch (world.getDirection()) {
                case "left": {
                    if (getCoordinates().getX() > 2) {
                        px = -2;
                    } else if (getCoordinates().getX() == 1) {
                        px = -1;
                    }
                    break;
                }
                case "right": {
                    if (getCoordinates().getX() <= world.getX() - 3) {
                        px = 2;
                    } else if (getCoordinates().getX() == world.getX() - 2) {
                        px = 1;
                    }
                    break;
                }
                case "up": {
                    if (getCoordinates().getY() >= 2) {
                        py = -2;
                    } else if (getCoordinates().getY() == 1) {
                        py = -1;
                    }
                    break;
                }
                case "down": {
                    if (getCoordinates().getY() <= world.getY() - 3) {
                        py = 2;
                    } else if (getCoordinates().getY() == world.getY() - 2) {
                        py = 1;
                    }
                    break;
                }
            }
        } else {
            switch (world.getDirection()) {
                case "left": {
                    if (getCoordinates().getX() >= 1) {
                        px = -1;
                    }
                    break;
                }
                case "right": {
                    if (getCoordinates().getX() <= world.getX() - 2) {
                        px = 1;
                    }
                    break;
                }
                case "up": {
                    if (getCoordinates().getY() >= 1) {
                        py = -1;
                    }
                    break;
                }
                case "down": {
                    if (getCoordinates().getY() <= world.getY() - 2) {
                        py = 1;
                    }
                    break;
                }
            }
        }
        py += getCoordinates().getY();
        px += getCoordinates().getX();
        world.moveOrganism(this, py, px);
    }

    @Override
    public Color getColor() {
        return color;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
