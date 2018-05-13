import Organizmy.Organizm;

import java.util.Collections;
import java.util.Vector;

public class Swiat {
    private int x, y;
    private Vector<Organizm> organizmy;
    private int[][] pole;

    public Swiat(int x, int y) {
        this.x = x;
        this.y = y;
        pole = new int[y][x];
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPole(int y, int x) {
        return pole[y][x];
    }

    public void setPole(int y, int x, int ID) {
        this.pole[y][x] = ID;
    }

    public void addOrganizm(Organizm org) {
        organizmy.add(org);
        setPole(org.getPolozenie().getY(), org.getPolozenie().getX(), org.hashCode());
    }

    public void sortujOrganizmy() {
        if (organizmy.size() != 0) {
            for (int i = 0; i < organizmy.size(); i++)
                for (int j = 1; j < organizmy.size() - i; j++)
                    if (organizmy.get(j - 1).getInicjatywa() < organizmy.get(j).getInicjatywa())
                        Collections.swap(organizmy, j - 1, j);

            //zabija organizmy
            while (organizmy.lastElement().getInicjatywa() == -1) {
                organizmy.remove(organizmy.size() - 1);
            }
        }
    }

    public void wykonajTure() {
        for (Organizm org : organizmy) {
            if (org.getInicjatywa() != -1) {
                org.Akcja();
            }
        }
    }

}
