package framework;

import java.util.ArrayList;
import java.util.Collections;
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
        if (alivePlayers.size() > 1) return true;
        else return false;
    }

    public void onRound() {
        Collections.shuffle(alivePlayers);
        for(int i = 0 ; i < alivePlayers.size() ; i++){

        }
        for(int i = alivePlayers.size() - 1 ; i >= 0 ; i--){
            if(alivePlayers.get(i).getHP() <= 0){
                alivePlayers.remove(i);
            }
        }
        //TODO 每一个回合的运行逻辑
    }

    public void removePlayerIfHPIsEmpty(PlayerRecord playerRecord) {
        if (playerRecord == null) return;
        if (playerRecord.getHP() <= 0) {
            alivePlayers.remove(playerRecord);
        }
    }

    void attack(AbstractPlayer initiator, AbstractPlayer target) {


    }

    int getBlood(AbstractPlayer player) {
        return playerMap.get(player).getHP();
    }
}
