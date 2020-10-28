package framework;

import java.util.ArrayList;

class PlayerRecord {
    private int HP = 100;
    private AbstractPlayer player;
    private ArrayList<BloodChangeListener> bloodChangeListeners = new ArrayList<>();


    public PlayerRecord(AbstractPlayer player, PlayerPackageManager playerPackageManager) {
        this.player = player;
    }

    public AbstractPlayer getAbstractPlayer() {
        return player;
    }

    public int getHP() {
        return HP;
    }




    public void addBloodChangeListener(BloodChangeListener listener) {
        bloodChangeListeners.add(listener);
    }

    public void attacked(int damage) {
        if (damage <= 0) return;
        HP -= damage;
    }

    public interface BloodChangeListener {
        void onBloodChange(PlayerRecord record, int blood);
    }
}
