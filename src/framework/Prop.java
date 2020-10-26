package framework;

public abstract class Prop implements PackageAble {
    private boolean isUsed = false;

    public void use() {
        this.onUse();
        isUsed = true;
    }

    protected abstract void onUse();

    final public boolean isUsed() {
        return isUsed;
    }
}
