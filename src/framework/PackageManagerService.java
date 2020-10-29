package framework;

import java.util.HashMap;

class PackageManagerService {
    private static PackageManagerService packageManagerService;
    private HashMap<AbstractPlayer,PlayerPackageManager> playerPackageManagerMap = new HashMap<>();
    private PackageManagerService() {
    }

    public static PackageManagerService getInstance() {
        if (packageManagerService == null) {
            synchronized (PackageManagerService.class) {
                if (packageManagerService == null) {
                    packageManagerService = new PackageManagerService();
                }
            }
        }
        return packageManagerService;
    }

    public PlayerPackageManager getPlayerPackageManager(AbstractPlayer abstractPlayer){
        if(playerPackageManagerMap.get(abstractPlayer) == null){
            playerPackageManagerMap.put(abstractPlayer,new PlayerPackageManager(abstractPlayer));
        }
        return playerPackageManagerMap.get(abstractPlayer);
    }
}
