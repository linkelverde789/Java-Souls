package NEGOCIO;

public abstract class PlaceArchetype {
    private int xPositionMinimum;
    private final int yPositionMaximum;
    private final int xPositionMaximum;
    private int yPositionMinimum;

    public PlaceArchetype(int xPositionMinimum, int yPositionMaximum, int xPositionMaximum, int yPositionMinimum) {
        this.xPositionMinimum = xPositionMinimum;
        this.yPositionMaximum = yPositionMaximum;
        this.xPositionMaximum = xPositionMaximum;
        this.yPositionMinimum = yPositionMinimum;
    }

    public PlaceArchetype(int yPositionMaximum, int xPositionMaximum) {
        this.yPositionMaximum = yPositionMaximum;
        this.xPositionMaximum = xPositionMaximum;
    }

    public int getxPositionMinimum() {
        return xPositionMinimum;
    }

    public int getyPositionMaximum() {
        return yPositionMaximum;
    }

    public int getxPositionMaximum() {
        return xPositionMaximum;
    }

    public int getyPositionMinimum() {
        return yPositionMinimum;
    }
}
