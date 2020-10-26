package framework;

public abstract class Command {
    private Command() {
    }

    public abstract void action(PlayerManagerService playerManagerService);
    public static Command generateMoveCommand(AbstractMap.Direction direction) {
        return new Command(){
            @Override
            public void action(PlayerManagerService playerManagerService) {

            }
        };
    }

    public static Command generateAttackCommand() {
        return new Command(){
            @Override
            public void action(PlayerManagerService playerManagerService) {

            }
        };
    }
}
