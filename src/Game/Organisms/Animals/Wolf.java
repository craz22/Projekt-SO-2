package Game.Organisms.Animals;


import Game.Organisms.Coordinates;

import java.awt.*;

public class Wolf implements Animal {
    private final Color color;
    private int strength, initiative, age;
    private Coordinates coordinates;

    public Wolf(int x, int y) {
        this.strength = 9;
        this.initiative = 5;
        this.age = 0;
        this.coordinates = new Coordinates(x, y);
        this.color = Color.ORANGE;
    }

    @Override
    public String Draw() {
        return "WO";
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
