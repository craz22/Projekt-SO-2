package Game.Organisms;

import Game.World;

import java.awt.*;

public interface Organism {
    void Action(World world);

    void Collision(World world, Organism attacker);

    String Draw();

    int getStrength();

    void setStrength(int strength);

    int getInitiative();

    void setInitiative(int initiative);

    int getAge();

    void setAge(int age);

    Color getColor();

    Coordinates getCoordinates();

    void setCoordinates(Coordinates coordinates);

}
