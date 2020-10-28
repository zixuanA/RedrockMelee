package framework;


abstract class AbstractMap {
    //TODO map的具体实现，需要完成对grid中的毒的调整。
    public abstract void move(AbstractPlayer player, Direction direction);

    public abstract Context getContext(AbstractPlayer player);

    abstract public Grid getGrid(AbstractPlayer abstractPlayer);
    public enum Direction {
        left, right, top, down, none
    }

    abstract public int[] getCoordinate(AbstractPlayer abstractPlayer);
}
