package framework;

import java.util.ArrayList;

public class Grid {
    private ArrayList<Weapon> weapons = new ArrayList<>();
    private ArrayList<Prop> props = new ArrayList<>();
    private AbstractPlayer player;
    private int poisoningInjury = 0;

    public void setPoisoningInjury(int poisoningInjury) {
        this.poisoningInjury = poisoningInjury;
    }

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

    public Status getStatus() {
        if (poisoningInjury >= 0) return Status.Poisoning;
        else return Status.safe;

    }

    public IStatusHandler getStatusHandler(){
        return new StatusHandlerImpl();
    }

    interface IStatusHandler {
        void handle(PlayerRecord playerRecord);
    }

    class StatusHandlerImpl implements IStatusHandler {
        @Override
        public void handle(PlayerRecord playerRecord) {
            playerRecord.attacked(poisoningInjury);
        }
    }
    public enum Status{
        safe, Poisoning
    }

}
