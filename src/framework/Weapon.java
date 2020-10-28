package framework;

abstract class Weapon implements IWeapon{
    //处理造成伤害的逻辑
    //TODO 现在的攻击逻辑有一些不合理，需要武器来主动向MapManagerService获得信息
    abstract void onAttack(PlayerRecord initiator,PlayerRecord target);
}
