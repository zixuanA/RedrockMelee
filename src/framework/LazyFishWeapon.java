package framework;

import java.util.Random;

class LazyFishWeapon extends Weapon {

    @Override
    public WeaponType getInfo() {
        return WeaponType.LAZY_FISH_GUN;
    }

    @Override
    void onAttack(PlayerRecord initiator, PlayerRecord target) {

        Random random = new Random();
        target.attacked(random.nextInt(9) + 1
                - (int)MapManagerService.getInstance().getDistance(initiator.getAbstractPlayer(), target.getAbstractPlayer()));
    }
}
