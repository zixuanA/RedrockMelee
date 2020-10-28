package framework;

class MapManagerService {
    private static MapManagerService mapManagerService;
    AbstractMap abstractMap;

    private MapManagerService() {
    }

    public static MapManagerService getInstance() {
        if (mapManagerService == null) {
            synchronized (MapManagerService.class) {
                if (mapManagerService == null) {
                    mapManagerService = new MapManagerService();
                }
            }
        }
        return mapManagerService;
    }

    public void move(AbstractPlayer abstractPlayer, AbstractMap.Direction direction) {
        abstractMap.move(abstractPlayer, direction);
    }

    public Context getContext(AbstractPlayer abstractPlayer) {
        return abstractMap.getContext(abstractPlayer);
    }

    public double getDistance(AbstractPlayer from, AbstractPlayer to) {
        int[] disFrom = abstractMap.getCoordinate(from);
        int[] disTo = abstractMap.getCoordinate(to);

        disFrom[0] = Math.abs(disFrom[0] - disTo[0]);
        disFrom[1] = Math.abs(disFrom[1] - disTo[1]);

        return Math.sqrt(Math.pow(disFrom[0], 2) + Math.pow(disFrom[1], 2));
    }

    public void tryToPickProp(AbstractPlayer abstractPlayer, Prop prop) throws TargetIsAlreadyPickedException {
        if (abstractMap.getGrid(abstractPlayer).getProps().contains(prop)) {
            abstractMap.getGrid(abstractPlayer).getProps().remove(prop);
        } else {
            throw new TargetIsAlreadyPickedException();
        }
    }
    public void tryToPickWeapon(AbstractPlayer abstractPlayer, Weapon weapon) throws TargetIsAlreadyPickedException{
        if (abstractMap.getGrid(abstractPlayer).getWeapons().contains(weapon)) {
            abstractMap.getGrid(abstractPlayer).getWeapons().remove(weapon);
        } else {
            throw new TargetIsAlreadyPickedException();
        }
    }
}
