package framework;

public abstract class AbstractPlayer {
    private Command expectedCommand;

    public void round(Context context, PlayerPackageManager playerPackageManager) {
        onRound(context, playerPackageManager);
        doCommand();
    }

    private void doCommand() {
        if (expectedCommand == null) expectedCommand = Command.generateMoveCommand(AbstractMap.Direction.none);
        expectedCommand.action(this);
        expectedCommand = null;
    }

    protected final void setExpectedCommand(Command expectedCommand) {
        this.expectedCommand = expectedCommand;
    }

    protected abstract void onRound(Context context, PlayerPackageManager playerPackageManager);

    public abstract String getPlayerName();

    public abstract String getPlayerStuNum();

    public final int getBlood() {
        return PlayerManagerService.getInstance().getBlood(this);
    }

}
