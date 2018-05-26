package Game.Organisms.Plants;


import Game.Organisms.Coordinates;

import java.awt.*;

public class Grass implements Plant {
    private final Color color;
    private int strength, initiative, age;
    private Coordinates coordinates;

    public Grass(int x, int y) {
        this.strength = 0;
        this.initiative = 0;
        this.age = 0;
        this.coordinates = new Coordinates(x, y);
        this.color = Color.GREEN;
    }

    @Override
    public String Draw() {
        return "GR";
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
