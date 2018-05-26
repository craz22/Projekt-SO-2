package Game.Organisms.Plants;


import Game.Organisms.Coordinates;
import Game.Organisms.Organism;
import Game.World;

import java.awt.*;

public class PoisonBerries implements Plant {
    private final Color color;
    private int strength, initiative, age;
    private Coordinates coordinates;

    public PoisonBerries(int x, int y) {
        this.strength = 99;
        this.initiative = 0;
        this.age = 0;
        this.coordinates = new Coordinates(x, y);
        this.color = Color.BLUE;
    }

    @Override
    public String Draw() {
        return "PB";
    }

    @Override
    public void Collision(World world, Organism attacker) {
        Plant.super.Collision(world, attacker);
        String comment = attacker.getClass().getSimpleName() + " ate PoisonBerries";
        world.addComment(comment);
        world.kill(this);
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
