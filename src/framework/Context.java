package framework;

public class Context {
    private Grid grid;
    private AbstractPlayer[][] aroundPlayers;
    private Grid.Status[][] aroundStatus;

    public Context(Grid grid, AbstractPlayer[][] aroundPlayers, Grid.Status[][] aroundStatus) {
        this.grid = grid;
        this.aroundPlayers = aroundPlayers;
        this.aroundStatus = aroundStatus;
    }

    public AbstractPlayer[][] getAroundPlayers() {
        return aroundPlayers;
    }

    public Grid.Status[][] getAroundStatus() {
        return aroundStatus;
    }

    public Grid getGrid() {
        return grid;
    }
}
