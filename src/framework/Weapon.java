package framework;

abstract class Weapon implements IWeapon{
    //处理造成伤害的逻辑
    abstract void onAttack(AttackAble target);
}
