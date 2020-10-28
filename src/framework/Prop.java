package framework;

public abstract class Prop implements PackageAble {
    private boolean isUsed = false;

    public void use(AbstractPlayer abstractPlayer) {
        this.onUse(abstractPlayer);
        isUsed = true;
    }

    protected abstract void onUse(AbstractPlayer abstractPlayer);

    final public boolean isUsed() {
        return isUsed;
    }
}
