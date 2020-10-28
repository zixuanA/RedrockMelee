package framework;

import java.util.List;

public abstract class Command {
    private Command() {
    }

    public static Command generateMoveCommand(AbstractMap.Direction direction) {
        return new Command() {
            @Override
            void action(AbstractPlayer initiator) {
                MapManagerService.getInstance().move(initiator,direction);
            }
        };
    }

    public static Command generateAttackCommand(AbstractPlayer target) {
        return new Command() {
            @Override
            void action(AbstractPlayer initiator) {
                PlayerManagerService.getInstance().attack(initiator, target);
            }
        };
    }

    public static Command generateUsePropCommand(IProp prop) {
        return new Command() {
            @Override
            void action(AbstractPlayer initiator) {
                PackageManagerService.getInstance().getPlayerPackageManager(initiator).useProp(prop);
            }
        };
    }

    public static Command generatePickCommand(List<IProp> props){
        return generatePickCommand(props, null);
    }

    public static Command generatePickCommand(IWeapon weapon){
        return generatePickCommand(null, weapon);
    }

    public static Command generatePickCommand(List<IProp> props, IWeapon weapon){
        return new Command() {
            @Override
            void action(AbstractPlayer initiator) {
                if(props != null) PackageManagerService.getInstance().getPlayerPackageManager(initiator).pickProps(props);
                if(weapon != null) PackageManagerService.getInstance().getPlayerPackageManager(initiator).equipWeapon(weapon);
            }
        };
    }

    abstract void action(AbstractPlayer initiator);
}
