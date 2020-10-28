package framework;

import java.util.ArrayList;
import java.util.List;

public class PlayerPackageManager {
    private AbstractPlayer abstractPlayer;
    private int idleCapacity = 100;
    private Weapon weapon = new LazyFishWeapon();
    private List<Prop> props = new ArrayList<>();
    public PlayerPackageManager(AbstractPlayer abstractPlayer) {
        this.abstractPlayer = abstractPlayer;
    }

    final void useProp(IProp prop) {
        ((Prop) prop).use(abstractPlayer);
    }

    public void expansionCapacity(int num) {
        idleCapacity += num;
    }

    final protected void equipWeapon(IWeapon weapon) {
        try {
            MapManagerService.getInstance().tryToPickWeapon(abstractPlayer, (Weapon) weapon);
            this.weapon = (Weapon) weapon;
        } catch (TargetIsAlreadyPickedException e) {
            System.out.println(abstractPlayer.getPlayerName() + abstractPlayer.getPlayerStuNum());
            e.printStackTrace();
        }
    }


    public int getIdleCapacity() {
        return idleCapacity;
    }
    public Weapon getWeapon(){
        return weapon;
    }
    final protected void pickProps(List<IProp> props) {
        for (int i = props.size() - 1; i >= 0; i--) {
            try {
                if (idleCapacity - ((Prop) props.get(i)).weight() < 0) continue;

                MapManagerService.getInstance().tryToPickProp(abstractPlayer, (Prop) props.get(i));
                this.props.add((Prop) props.get(i));
                idleCapacity -= ((Prop) props.get(i)).weight();
            } catch (TargetIsAlreadyPickedException e) {
                System.out.println(abstractPlayer.getPlayerName() + abstractPlayer.getPlayerStuNum());
                e.printStackTrace();
            }
        }
    }
}
