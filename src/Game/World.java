package Game;

import Game.Organisms.Animals.*;
import Game.Organisms.Coordinates;
import Game.Organisms.Organism;
import Game.Organisms.Plants.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class World {
    private int x, y;
    private final Vector<Organism> organisms = new Vector<>();
    private final Vector<String> comments = new Vector<>();
    private String direction;
    private int[][] pool;
    private int specialcounter;

    public World(int x, int y) {
        this.x = x;
        this.y = y;
        pool = new int[y][x];
        this.direction = "right";
        this.specialcounter = 0;
    }

    public int getSpecialCounter() {
        return specialcounter;
    }

    public void setSpecialCounter(int specialCounter) {
        this.specialcounter = specialCounter;
    }

    private void setHuman(Human human) {
        addOrganism(human);
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        randOrganisms(this);
    }

    public Vector<String> getComments() {
        return comments;
    }

    public void addComment(String comment) {
        this.comments.add(comment);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        randOrganisms(this);
    }

    private void setPool(int y, int x, int ID) {
        this.pool[y][x] = ID;
    }

    public void addOrganism(Organism org) {
        organisms.add(org);
        setPool(org.getCoordinates().getY(), org.getCoordinates().getX(), org.hashCode());
    }

    public Organism getOrganism(int y, int x) {
        for (Organism org : organisms) {
            if (org.getCoordinates().getY() == y && org.getCoordinates().getX() == x && org.getInitiative() != -1) {
                return org;
            }
        }
        return null;
    }

    public void moveOrganism(Organism org, int y, int x) {
        if (getOrganism(y, x) == null) {
            setPool(org.getCoordinates().getY(), org.getCoordinates().getX(), 0);
            setPool(y, x, org.hashCode());
            org.setCoordinates(new Coordinates(x, y));
        } else {
            getOrganism(y, x).Collision(this, org);
        }
    }

    private void sortOrganisms() {
        if (organisms.size() != 0) {
            for (int i = 0; i < organisms.size(); i++)
                for (int j = 1; j < organisms.size() - i; j++)
                    if (organisms.get(j - 1).getInitiative() < organisms.get(j).getInitiative())
                        Collections.swap(organisms, j - 1, j);
                        //if they have the same initiative then the older one goes first
                    else if (organisms.get(j - 1).getInitiative() == organisms.get(j).getInitiative()) {
                        if (organisms.get(j - 1).getAge() < organisms.get(j).getAge())
                            Collections.swap(organisms, j - 1, j);
                    }
        }
        int i = organisms.size();
        while (organisms.lastElement().getInitiative() == -1) {
            organisms.remove(i - 1);
            i--;
        }
    }

    public void kill(Organism org) {
        org.setInitiative(-1);
        setPool(org.getCoordinates().getY(), org.getCoordinates().getX(), 0);
    }

    public void makeRound() {
        comments.removeAllElements();
        sortOrganisms();
        int temp = organisms.size();
        for (int i = 0; i < temp; i++) {
            organisms.elementAt(i).setAge(organisms.elementAt(i).getAge() + 1);
            organisms.elementAt(i).Action(this);
        }
        if (specialcounter > 0) {
            specialcounter++;
        }
        if (specialcounter == 10) {
            specialcounter = 0;
        }
    }

    void randOrganisms(World world) {
        pool = new int[this.y][this.x];
        for (int i = 0; i < this.y; i++) {
            for (int j = 0; j < this.x; j++) {
                this.pool[i][j] = 0;
            }
        }
        organisms.clear();
        int rx, ry;
        Random generator = new Random();
        rx = generator.nextInt(this.x);
        ry = generator.nextInt(this.y);
        setHuman(new Human(rx, ry));
        int percent = (int) (this.x * this.y * 0.03);
        if (percent == 0) {
            percent = 1;
        }
        for (int i = 0; i < 10; i++) {
            int licznik = 0;
            while (licznik <= percent) {
                rx = generator.nextInt(world.getX());
                ry = generator.nextInt(world.getY());
                if (pool[ry][rx] == 0) {
                    switch (i) {
                        case 0: {
                            SosnowskyHogweed sosnowskyHogweed = new SosnowskyHogweed(rx, ry);
                            addOrganism(sosnowskyHogweed);
                            break;
                        }
                        case 1: {
                            Guarana guarana = new Guarana(rx, ry);
                            addOrganism(guarana);
                            break;
                        }
                        case 2: {
                            MilkSowthistle milkSowthistle = new MilkSowthistle(rx, ry);
                            addOrganism(milkSowthistle);
                            break;
                        }
                        case 3: {
                            Grass grass = new Grass(rx, ry);
                            addOrganism(grass);
                            break;
                        }
                        case 4: {
                            PoisonBerries poisonBerries = new PoisonBerries(rx, ry);
                            addOrganism(poisonBerries);
                            break;
                        }
                        case 5: {
                            Antelope antelope = new Antelope(rx, ry);
                            addOrganism(antelope);
                            break;
                        }
                        case 6: {
                            Fox fox = new Fox(rx, ry);
                            addOrganism(fox);
                            break;
                        }
                        case 7: {
                            Sheep sheep = new Sheep(rx, ry);
                            addOrganism(sheep);
                            break;
                        }
                        case 8: {
                            Wolf wolf = new Wolf(rx, ry);
                            addOrganism(wolf);
                            break;
                        }
                        case 9: {
                            Turtle turtle = new Turtle(rx, ry);
                            addOrganism(turtle);
                            break;
                        }
                    }
                    licznik++;
                }
            }
        }
    }

    public void save() {
        try (PrintWriter writer = new PrintWriter("save.txt", "UTF-8")) {
            writer.println(this.x + " " + this.y);
            for (Organism org : organisms) {
                writer.println(org.getClass().getSimpleName());
                writer.println(org.getCoordinates().getX() + " " + org.getCoordinates().getY() + " " + org.getInitiative() + " " + org.getStrength() + " " + org.getAge());
            }
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    public World load() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("save.txt"));
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        World world = new World(x, y);
        while (scanner.hasNext()) {
            scanner.nextLine();
            String name = scanner.nextLine();
            int px = scanner.nextInt();
            int py = scanner.nextInt();
            int initiative = scanner.nextInt();
            int strength = scanner.nextInt();
            int age = scanner.nextInt();
            Organism org;
            switch (name) {
                case "SosnowskyHogweed": {
                    org = new SosnowskyHogweed(px, py);
                    break;
                }
                case "Guarana": {
                    org = new Guarana(px, py);
                    break;
                }
                case "MilkSowthistle": {
                    org = new MilkSowthistle(px, py);
                    break;
                }
                case "Grass": {
                    org = new Grass(px, py);
                    break;
                }
                case "PoisonBerries": {
                    org = new PoisonBerries(px, py);
                    break;
                }
                case "Antelope": {
                    org = new Antelope(px, py);
                    break;
                }
                case "Human": {
                    org = new Human(px, py);
                    world.setHuman((Human) org);
                    break;
                }
                case "Fox": {
                    org = new Fox(px, py);
                    break;
                }
                case "Sheep": {
                    org = new Sheep(px, py);
                    break;
                }
                case "Wolf": {
                    org = new Wolf(px, py);
                    break;
                }
                case "Turtle": {
                    org = new Turtle(px, py);
                    break;
                }
                default: {
                    org = new Grass(px, py);
                    break;
                }
            }
            org.setInitiative(initiative);
            org.setStrength(strength);
            org.setAge(age);
            world.addOrganism(org);
        }
        return world;
    }
}
