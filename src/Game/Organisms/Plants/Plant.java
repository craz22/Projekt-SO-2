package Game.Organisms.Plants;


import Game.Organisms.Coordinates;
import Game.Organisms.Organism;
import Game.World;

import java.awt.*;
import java.util.Random;
import java.util.Vector;

public interface Plant extends Organism {
    @SuppressWarnings("Duplicates")
    @Override
    default void Action(World world) {
        Random generator = new Random();
        int los;
        //looking for empty spaces
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
                    }
                }
            }
        }
        //if there are empty spaces
        if (!tab.isEmpty()) {
            //chance to bread
            los = generator.nextInt(100);
            if (los < 10) {//10% chance
                los = generator.nextInt(tab.size());
                int wx = tab.elementAt(los).getX(), wy = tab.elementAt(los).getY();
                String classname = this.getClass().getSimpleName();
                Organism org;
                switch (classname) {
                    case "SosnowskyHogweed": {
                        org = new SosnowskyHogweed(wx, wy);
                        break;
                    }
                    case "Guarana": {
                        org = new Guarana(wx, wy);
                        break;
                    }
                    case "MilkSowthistle": {
                        org = new MilkSowthistle(wx, wy);
                        break;
                    }
                    case "Grass": {
                        org = new Grass(wx, wy);
                        break;
                    }
                    case "PoisonBerries": {
                        org = new PoisonBerries(wx, wy);
                        break;
                    }
                    default: {
                        org = new Grass(wx, wy);
                        break;
                    }
                }
                String comment = org.getClass().getSimpleName() + " was born";
                world.addComment(comment);
                world.addOrganism(org);
            }
        }
    }

    @Override
    String Draw();

    @Override
    default void Collision(World world, Organism attacker) {
        if (attacker.getStrength() >= getStrength()) {
            String comment = attacker.getClass().getSimpleName() + " killed " + this.getClass().getSimpleName();
            world.addComment(comment);
            world.kill(this);
            world.moveOrganism(attacker, getCoordinates().getY(), getCoordinates().getX());
        } else {
            String comment = this.getClass().getSimpleName() + " killed " + attacker.getClass().getSimpleName();
            world.addComment(comment);
            world.kill(attacker);
        }
    }

    @Override
    int getStrength();

    @Override
    void setStrength(int strength);

    @Override
    int getInitiative();

    @Override
    void setInitiative(int initiative);

    @Override
    int getAge();

    @Override
    void setAge(int age);

    @Override
    Color getColor();

    @Override
    Coordinates getCoordinates();

    @Override
    void setCoordinates(Coordinates coordinates);
}
