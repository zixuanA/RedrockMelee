package framework;

import java.util.ArrayList;

class PlayerRecord implements AttackAble {
    private int blood = 100;

    private AbstractPlayer player;
    private PackageManager packageManager;
    private ArrayList<BloodChangeListener> bloodChangeListeners = new ArrayList<>();
    private Weapon weapon;

    public PlayerRecord(AbstractPlayer player, PackageManager packageManager){
        this.player = player;
        this.packageManager = packageManager;
    }

    public int getBlood() {
        return blood;
    }

    public Weapon getWeapon(){
        return weapon;
    }

    public void changeBlood(int num) {
        blood += num;
    }

    public void addBloodChangeListener(BloodChangeListener listener) {
        bloodChangeListeners.add(listener);
    }

    @Override
    public void attacked(int blood) {
        changeBlood(-blood);
    }

    public interface BloodChangeListener {
        void onBloodChange(PlayerRecord record, int blood);
    }
}
