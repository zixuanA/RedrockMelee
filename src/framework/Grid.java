package framework;

import java.util.ArrayList;

public class Grid {
    private ArrayList<Weapon> weapons = new ArrayList<>();
    private ArrayList<Prop> props = new ArrayList<>();

    public ArrayList<Prop> getProps() {
        return props;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }
}
