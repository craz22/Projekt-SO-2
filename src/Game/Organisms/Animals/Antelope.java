package Game.Organisms.Animals;


import Game.Organisms.Coordinates;
import Game.Organisms.Organism;
import Game.World;

import java.awt.*;
import java.util.Random;
import java.util.Vector;

public class Antelope implements Animal {
    private final Color color;
    private int strength, initiative, age;
    private Coordinates coordinates;

    public Antelope(int x, int y) {
        this.strength = 4;
        this.initiative = 4;
        this.age = 0;
        this.coordinates = new Coordinates(x, y);
        this.color = Color.CYAN;
    }

    @Override
    public String Draw() {
        return "AN";
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void Collision(World world, Organism attacker) {
        Random generator = new Random();
        //if the enemy is the same type
        if (attacker.getClass().getSimpleName().equals(getClass().getSimpleName())) {
            Animal.super.Collision(world, attacker);
        } else {
            //rand if it will escape
            int los = generator.nextInt(2);
            //if it will
            if (los == 0) {
                //searching for empty space
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
                                //if the pool is empty
                                if (world.getOrganism(getCoordinates().getY() + 1 - i, getCoordinates().getX() + 1 - j) == null) {
                                    tab.add(new Coordinates(getCoordinates().getX() + 1 - j, getCoordinates().getY() + 1 - i));
                                }
                            }
                        }
                    }
                }
                //rand of coordinates
                if (!tab.isEmpty()) {
                    los = generator.nextInt(tab.size());
                    world.moveOrganism(this, tab.elementAt(los).getY(), tab.elementAt(los).getX());
                    String comment = "Antelope escaped " + attacker.getClass().getSimpleName();
                    world.addComment(comment);
                }
                //if there are no empty spaces
                else {
                    Animal.super.Collision(world, attacker);
                }
                //if it wont run away
            } else {
                Animal.super.Collision(world, attacker);
            }
        }
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void Action(World world) {
        Random generator = new Random();
        int py = 0, px = 0, los;
        //rand in which direction it will go
        los = generator.nextInt(3);
        switch (los) {
            //vertical
            case 0: {
                py = getPY(world);
                break;
            }
            //horizontal
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

    @SuppressWarnings("Duplicates")
    @Override
    public int getPX(World world) {
        Random generator = new Random();
        int px, rand;
        //if its by the edge
        if (getCoordinates().getX() == 0) {
            //how far it will go
            rand = generator.nextInt(2);
            if (rand == 0) {
                px = 1;
            } else {
                px = 2;
            }
        }

        //if its 1 pool from the edge
        else if (getCoordinates().getX() == 1) {
            //left or right
            rand = generator.nextInt(2);
            //left
            if (rand == 0) {
                px = -1;
            }
            //right
            else {
                //how far it will go
                rand = generator.nextInt(2);
                if (rand == 0) {
                    px = 1;
                } else {
                    px = 2;
                }
            }
        }

        //if it's by the edge
        else if (getCoordinates().getX() == world.getX() - 1) {
            //how far it will go
            rand = generator.nextInt(2);
            if (rand == 0) {
                px = -1;
            } else {
                px = -2;
            }
        }

        //if it's 1 pool away from edge
        else if (getCoordinates().getX() == world.getX() - 2) {
            //left or right
            rand = generator.nextInt(2);
            //left
            if (rand == 0) {
                //how far it will go
                rand = generator.nextInt(2);
                if (rand == 0) {
                    px = -1;
                } else {
                    px = -2;
                }
            }
            //right
            else {
                px = 1;
            }
        }

        //if there is no problem
        else {
            //how far it will go
            rand = generator.nextInt(2);
            if (rand == 0) {
                px = 1;
            } else {
                px = 2;
            }
            //up or down
            rand = generator.nextInt(2);
            //up
            if (rand == 0) {
                px *= -1;
            }
            //if down then px is ok
        }
        return px;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public int getPY(World world) {
        Random generator = new Random();
        int py, los;


        //if its by the edge
        if (getCoordinates().getY() == 0) {
            //how far it will go
            los = generator.nextInt(2);
            if (los == 0) {
                py = 1;
            } else {
                py = 2;
            }
        }


        //if it's 1 pool away from edge
        else if (getCoordinates().getY() == 1) {
            //up or down
            los = generator.nextInt(2);
            //up
            if (los == 0) {
                py = -1;
            }
            //down
            else {
                //how far it will go
                los = generator.nextInt(2);
                if (los == 0) {
                    py = 1;
                } else {
                    py = 2;
                }
            }
        }

        //if it's by the edge
        else if (getCoordinates().getY() == world.getY() - 1) {
            //how far it will go
            los = generator.nextInt(2);
            if (los == 0) {
                py = -1;
            } else {
                py = -2;
            }
        }

        //if it's 1 pool away from edge
        else if (getCoordinates().getY() == world.getY() - 2) {
            //up or down
            los = generator.nextInt(2);
            //up
            if (los == 0) {
                //how far it will go
                los = generator.nextInt(2);
                if (los == 0) {
                    py = -1;
                } else {
                    py = -2;
                }
            }
            //down
            else {
                py = 1;
            }
        }

        //if there is no problem
        else {
            //how far it will go
            los = generator.nextInt(2);
            if (los == 0) {
                py = 1;
            } else {
                py = 2;
            }
            //up or down
            los = generator.nextInt(2);
            //up
            if (los == 0) {
                py *= -1;
            }
            //if down then py is ok
        }
        return py;
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
