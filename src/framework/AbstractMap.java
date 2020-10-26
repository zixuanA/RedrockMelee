package framework;

public abstract class AbstractMap {
    public abstract void move(AbstractPlayer player, Direction direction) throws MoveToWrongGridException;

    public abstract Environment getAroundEnvironment(AbstractPlayer player);

    public enum Direction{
        left,right,top,down,none
    }
}
