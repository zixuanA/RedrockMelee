package framework;

import java.util.ArrayList;

public class Grid {
    private ArrayList<Weapon> weapons = new ArrayList<>();
    private ArrayList<Prop> props = new ArrayList<>();
    private AbstractPlayer player;

    public AbstractPlayer getPlayer() {
        return player;
    }

    public void setPlayer(AbstractPlayer player) {
        this.player = player;
    }

    public ArrayList<Prop> getProps() {
        return props;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }
}
