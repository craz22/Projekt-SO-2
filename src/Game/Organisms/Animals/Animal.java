package Game.Organisms.Animals;

import Game.Organisms.Coordinates;
import Game.Organisms.Organism;
import Game.World;

import java.awt.*;
import java.util.Random;
import java.util.Vector;

public interface Animal extends Organism {
    @Override
    String Draw();

    @SuppressWarnings("Duplicates")
    @Override
    default void Collision(World world, Organism attacker) {
        //if it's the same type
        String comment;
        if (attacker.getClass().getSimpleName().equals(getClass().getSimpleName())) {
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
                    Organism org;
                    switch (this.getClass().getSimpleName()) {
                        case "Antelope": {
                            org = new Antelope(wx, wy);
                            break;
                        }
                        case "Fox": {
                            org = new Fox(wx, wy);
                            break;
                        }
                        case "Sheep": {
                            org = new Sheep(wx, wy);
                            break;
                        }
                        case "Wolf": {
                            org = new Wolf(wx, wy);
                            break;
                        }
                        case "Turtle": {
                            org = new Turtle(wx, wy);
                            break;
                        }
                        default: {
                            org = new Sheep(wx, wy);
                            break;
                        }
                    }
                    comment = org.getClass().getSimpleName() + " was born";
                    world.addComment(comment);
                    world.addOrganism(org);
                }
            }
        }
        else {
            //checking who is stronger
            if (attacker.getStrength() >= getStrength()) {
                comment = attacker.getClass().getSimpleName() + " killed " + this.getClass().getSimpleName();
                world.kill(this);
                world.moveOrganism(attacker, getCoordinates().getY(), getCoordinates().getX());
            } else {
                comment = this.getClass().getSimpleName() + " killed " + attacker.getClass().getSimpleName();
                world.kill(attacker);
            }
            world.addComment(comment);
        }
    }

    @SuppressWarnings("Duplicates")
    @Override
    default void Action(World world) {
        Random generator = new Random();
        int py = 0, px = 0, los;
        //rand in which direction it will go
        los = generator.nextInt(3);
        switch (los) {
            //vertically
            case 0: {
                py = getPY(world);
                break;
            }
            //horizontally
            case 1: {
                px = getPX(world);
                break;
            }
            //diagonally
            case 2: {
                py = getPY(world);
                px = getPX(world);
                break;
            }
        }
        world.moveOrganism(this, getCoordinates().getY() + py, getCoordinates().getX() + px);
    }

    default int getPX(World world) {
        Random generator = new Random();
        int los;
        if (getCoordinates().getX() == 0) {
            return 1;
        } else if (getCoordinates().getX() == world.getX() - 1) {
            return -1;
        } else {
            los = generator.nextInt(2);
            if (los == 0) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    default int getPY(World world) {
        Random generator = new Random();
        int los;
        if (getCoordinates().getY() == 0) {
            return 1;
        } else if (getCoordinates().getY() == world.getY() - 1) {
            return -1;
        } else {
            los = generator.nextInt(2);
            if (los == 0) {
                return 1;
            } else {
                return -1;
            }
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
