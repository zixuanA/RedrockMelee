package framework;


import java.util.List;

abstract class AbstractMap {
    //TODO map的具体实现，需要完成对grid中的毒的调整。
    public abstract void move(AbstractPlayer player, Direction direction);

    public abstract Context getContext(AbstractPlayer player);

    abstract public Grid getGrid(AbstractPlayer abstractPlayer);

    abstract public void addPlayers(List<AbstractPlayer> abstractPlayers);

    public enum Direction {
        left, right, top, down, none
    }

    abstract public int[] getCoordinate(AbstractPlayer abstractPlayer);
}
