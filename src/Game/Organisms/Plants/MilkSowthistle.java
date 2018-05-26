package Game.Organisms.Plants;


import Game.Organisms.Coordinates;
import Game.World;

import java.awt.*;

public class MilkSowthistle implements Plant {
    private final Color color;
    private int strength, initiative, age;
    private Coordinates coordinates;

    public MilkSowthistle(int x, int y) {
        this.strength = 0;
        this.initiative = 0;
        this.age = 0;
        this.coordinates = new Coordinates(x, y);
        this.color = Color.YELLOW;
    }

    @Override
    public void Action(World world) {
        for (int i = 0; i < 3; i++) {
            Plant.super.Action(world);
        }
    }

    @Override
    public String Draw() {
        return "MS";
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
