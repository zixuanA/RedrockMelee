package framework;

import java.util.ArrayList;

class PlayerRecord implements AttackAble {
    private int HP = 100;

    private AbstractPlayer player;
    private PackageManager packageManager;
    private ArrayList<BloodChangeListener> bloodChangeListeners = new ArrayList<>();
    private Weapon weapon;

    public PlayerRecord(AbstractPlayer player, PackageManager packageManager) {
        this.player = player;
        this.packageManager = packageManager;
    }

    public int getHP() {
        return HP;
    }

    public Weapon getWeapon() {
        return weapon;
    }


    public void addBloodChangeListener(BloodChangeListener listener) {
        bloodChangeListeners.add(listener);
    }

    @Override
    public void attacked(int damage) {
        HP -= damage;
    }

    public interface BloodChangeListener {
        void onBloodChange(PlayerRecord record, int blood);
    }
}
