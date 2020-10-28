package framework;

import java.util.*;

class PlayerManagerService {
    private static PlayerManagerService playerManagerService;
    private HashMap<AbstractPlayer, PlayerRecord> playerMap = new HashMap<>();

    private PlayerManagerService() {
    }

    public static PlayerManagerService getInstance() {
        if (playerManagerService == null) {
            synchronized (PlayerManagerService.class) {
                if (playerManagerService == null) {
                    playerManagerService = new PlayerManagerService();
                }
            }
        }
        return playerManagerService;
    }

    public void addPlayers(ArrayList<AbstractPlayer> players) {
        for(AbstractPlayer player:players){
            playerMap.put(player, new PlayerRecord(player, new PlayerPackageManager(player)));
        }
    }

    public boolean isMoreThanOnePlayers() {
        if (playerMap.values().size() > 1) return true;
        else return false;
    }

    public void onRound() {
        List<PlayerRecord> alivePlayers = new ArrayList<>(List.copyOf(playerMap.values()));
        Collections.shuffle(alivePlayers);
        for (PlayerRecord player : alivePlayers) {
            player.getAbstractPlayer().onRound(MapManagerService.getInstance().getContext(player.getAbstractPlayer()),
                    CommandManagerService.getInstance().getPlayerCommandManager(player.getAbstractPlayer()),
                    PackageManagerService.getInstance().getPlayerPackageManager(player.getAbstractPlayer()));

            CommandManagerService.getInstance().doCommand(player.getAbstractPlayer());
        }
        for (int i = alivePlayers.size() - 1; i >= 0; i--) {
            if (alivePlayers.get(i).getHP() <= 0) {
                alivePlayers.remove(i);
            }
        }
    }

    void attack(AbstractPlayer initiator, AbstractPlayer target) {

        PackageManagerService.getInstance().getPlayerPackageManager(initiator)
                .getWeapon().onAttack(playerMap.get(initiator), playerMap.get(target));

    }

    int getBlood(AbstractPlayer player) {
        return playerMap.get(player).getHP();
    }

}
