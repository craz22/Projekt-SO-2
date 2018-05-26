package Game.Organisms.Animals;


import Game.Organisms.Coordinates;

import java.awt.*;

public class Sheep implements Animal {
    private final Color color;
    private int strength, initiative, age;
    private Coordinates coordinates;

    public Sheep(int x, int y) {
        this.strength = 4;
        this.initiative = 4;
        this.age = 0;
        this.coordinates = new Coordinates(x, y);
        this.color = Color.LIGHT_GRAY;
    }

    @Override
    public String Draw() {
        return "S";
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

    @Override
    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    @Override
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
