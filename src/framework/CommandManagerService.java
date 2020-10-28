package framework;

import java.util.HashMap;

class CommandManagerService {
    private static CommandManagerService commandManagerService;
    private HashMap<AbstractPlayer,PlayerCommandManager> playerPackageManagerMap = new HashMap<>();

    private CommandManagerService() {
    }

    public static CommandManagerService getInstance() {
        if (commandManagerService == null) {
            synchronized (CommandManagerService.class) {
                if (commandManagerService == null) {
                    commandManagerService = new CommandManagerService();
                }
            }
        }
        return commandManagerService;
    }

    public PlayerCommandManager getPlayerCommandManager(AbstractPlayer abstractPlayer){
        if(playerPackageManagerMap.get(abstractPlayer) == null){
            playerPackageManagerMap.put(abstractPlayer,new PlayerCommandManager());
        }
        return playerPackageManagerMap.get(abstractPlayer);
    }

    public void doCommand(AbstractPlayer abstractPlayer){
        getPlayerCommandManager(abstractPlayer).popCommandForThisRound().action(abstractPlayer);
    }
}
