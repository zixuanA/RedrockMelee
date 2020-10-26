package framework;

import java.util.Random;

class LazyFishWeapon extends Weapon {
    @Override
    void onAttack(AttackAble target) {
        Random random = new Random();
        target.attacked(random.nextInt(9) + 1);
    }


    @Override
    public WeaponType getInfo() {
        return WeaponType.LAZY_FISH_GUN;
    }
}
