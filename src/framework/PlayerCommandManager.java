package framework;


public class PlayerCommandManager {
    private Command commandForThisRound;

    public void pushCommandForThisRound(Command command) {
        commandForThisRound = command;
    }

    Command popCommandForThisRound() {
        Command result = commandForThisRound;
        commandForThisRound = null;
        if (result == null) result = Command.generateMoveCommand(AbstractMap.Direction.none);
        return result;
    }
}
