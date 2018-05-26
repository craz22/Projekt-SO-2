package Game.Organisms.Animals;

import Game.Organisms.Coordinates;
import Game.Organisms.Organism;
import Game.World;

import java.awt.*;
import java.util.Random;

public class Turtle implements Animal {
    private final Color color;
    private int strength, initiative, age;
    private Coordinates coordinates;

    public Turtle(int x, int y) {
        this.strength = 2;
        this.initiative = 1;
        this.age = 0;
        this.coordinates = new Coordinates(x, y);
        this.color = Color.DARK_GRAY;
    }

    @Override
    public String Draw() {
        return "TU";
    }

    @Override
    public void Collision(World world, Organism attacker) {
        //if it's the same type
        if (attacker.getClass().getSimpleName().equals(getClass().getSimpleName())) {
            Animal.super.Collision(world, attacker);
        } else {
            //if it will defend from the attack
            if (attacker.getStrength() > 5) {
                Animal.super.Collision(world, attacker);
            } else {
                String comment = "Turtle defended from " + attacker.getClass().getSimpleName();
                world.addComment(comment);
            }
        }
    }

    @Override
    public void Action(World world) {
        Random generator = new Random();
        int los = generator.nextInt(4);
        if (los == 0) {
            Animal.super.Action(world);
        }
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public int getInitiative() {
        return initiative;
    }

    @Override
    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
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
