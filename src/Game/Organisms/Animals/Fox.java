package Game.Organisms.Animals;


import Game.Organisms.Coordinates;
import Game.World;

import java.awt.*;
import java.util.Random;
import java.util.Vector;

public class Fox implements Animal {
    private final Color color;
    private int strength, initiative, age;
    private Coordinates coordinates;

    public Fox(int x, int y) {
        this.strength = 3;
        this.initiative = 7;
        this.age = 0;
        this.coordinates = new Coordinates(x, y);
        this.color = Color.PINK;
    }

    @Override
    public String Draw() {
        return "FO";
    }

    @Override
    public void Action(World world) {
        //finding available pools
        Vector<Coordinates> tab = new Vector<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //noinspection StatementWithEmptyBody
                if (i == 1 && j == 1) ;
                else {
                    if (getCoordinates().getY() + 1 - i >= 0
                            && getCoordinates().getY() + 1 - i <= world.getY() - 1
                            && getCoordinates().getX() + 1 - j >= 0
                            && getCoordinates().getX() + 1 - j <= world.getX() - 1) {
                        //if it's empty
                        if (world.getOrganism(getCoordinates().getY() + 1 - i, getCoordinates().getX() + 1 - j) == null) {
                            tab.add(new Coordinates(getCoordinates().getX() + 1 - j, getCoordinates().getY() + 1 - i));
                        }
                        //if the enemy is weaker
                        else if (world.getOrganism(getCoordinates().getY() + 1 - i, getCoordinates().getX() + 1 - j).getStrength() <= getStrength()) {
                            tab.add(new Coordinates(getCoordinates().getX() + 1 - j, getCoordinates().getY() + 1 - i));
                        }
                    }
                }
            }
        }
        //rand coordinates
        if (!tab.isEmpty()) {
            Random generator = new Random();
            int los = generator.nextInt(tab.size());
            world.moveOrganism(this, tab.elementAt(los).getY(), tab.elementAt(los).getX());
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
