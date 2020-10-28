package framework;

public abstract class AbstractPlayer {

    protected abstract void onRound(Context context, PlayerCommandManager playerCommandManager, PlayerPackageManager playerPackageManager);

    public abstract String getPlayerName();

    public abstract String getPlayerStuNum();

    public final int getBlood() {
        return PlayerManagerService.getInstance().getBlood(this);
    }

}
