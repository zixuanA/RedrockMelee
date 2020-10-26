package framework;

import java.util.ArrayList;
import java.util.HashMap;

class PlayerManagerService {
    private static PlayerManagerService playerManagerService;

    private HashMap<AbstractPlayer, PlayerRecord> playerMap = new HashMap<>();

    private ArrayList<PlayerRecord> alivePlayers = new ArrayList<>();

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
        //TODO 将添加的AbstractPlayers生成对应的PlayerRecord，并同时添加到playerMap,和alivePlayer中
    }

    public boolean isMoreThanOnePlayers() {

        if (alivePlayers.size() > 1)return true;
        else return false;
    }

    void attack(AbstractPlayer initiator, AbstractPlayer target) {

        System.out.println(initiator.getPlayerName() + initiator.getPlayerStuNum() + "对" + target.getPlayerName() + target.getPlayerStuNum()
                + "造成了" + playerMap.get(initiator).getWeapon().onAttack(playerMap.get(target)) + "伤害");


    }

    int getBlood(AbstractPlayer player) {
        return playerMap.get(player).getBlood();
    }
}
