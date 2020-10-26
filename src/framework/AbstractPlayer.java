package framework;

public abstract class AbstractPlayer {

    protected abstract void beforeRound();

    protected abstract void onRound(Context around, CommandManager commandManager, PackageManager packageManager);

    public abstract String getPlayerName();

    public abstract String getPlayerStuNum();

    //TODO
    final protected void equipWeapon() {

    }

//
//    final void move(AbstractMap.Direction direction) {
//
//    }
//
//    final void attack(Observable target) {
//        PlayerManager.getInstance().attack(this,target);
//    }

    public final int getBlood() {
        return PlayerManagerService.getInstance().getBlood(this);
    }

}
