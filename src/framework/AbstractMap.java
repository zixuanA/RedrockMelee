package framework;

public abstract class AbstractMap {
    public abstract void move(AbstractPlayer player, Direction direction) throws MoveToWrongGridException;

    public abstract Context getAroundEnvironment(AbstractPlayer player);

    public enum Direction{
        left,right,top,down,none
    }
}
