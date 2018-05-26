package Game.Organisms.Plants;


import Game.Organisms.Animals.Animal;
import Game.Organisms.Coordinates;
import Game.Organisms.Organism;
import Game.World;

import java.awt.*;
import java.util.Vector;

public class SosnowskyHogweed implements Plant {
    private final Color color;
    private int strength, initiative, age;
    private Coordinates coordinates;

    public SosnowskyHogweed(int x, int y) {
        this.initiative = 0;
        this.strength = 10;
        this.age = 0;
        this.coordinates = new Coordinates(x, y);
        this.color = Color.RED;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void Action(World world) {
        //looking for animals nearby
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
                        //if it's an animal
                        Class<?> interf = Animal.class;

                        if (world.getOrganism(getCoordinates().getY() + 1 - i, getCoordinates().getX() + 1 - j) != null) {
                            Class<?> obj = world.getOrganism(getCoordinates().getY() + 1 - i,
                                    getCoordinates().getX() + 1 - j)
                                    .getClass();

                            if (interf.isAssignableFrom(obj)) {
                                tab.add(new Coordinates(getCoordinates().getX() + 1 - j,
                                        getCoordinates().getY() + 1 - i)
                                );
                            }
                        }
                    }
                }
            }
        }
        //killing animals nearby
        if (!tab.isEmpty()) {
            for (Coordinates wsp : tab) {
                String comment = "Sosnowsky's Hogweed killed " + world.getOrganism(wsp.getY(), wsp.getX()).getClass().getSimpleName();
                world.addComment(comment);
                world.kill(world.getOrganism(wsp.getY(), wsp.getX()));
            }
        }
        //spreading
        Plant.super.Action(world);
    }

    @Override
    public String Draw() {
        return "SH";
    }

    @Override
    public void Collision(World world, Organism attacker) {
        String comment = attacker.getClass().getSimpleName() + " age Sosnowsky's Hogweed";
        world.addComment(comment);
        Plant.super.Collision(world, attacker);
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
