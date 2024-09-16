package NEGOCIO;

public class World extends PlaceArchetype {

    public World() {
        super(-18, 12, 18, -12);
    }

    public int checkXBorder(int PlayerXPosition) {
        if (PlayerXPosition > this.getxPositionMaximum()) {
            return 1;
        } else if (PlayerXPosition < this.getxPositionMinimum()) {
            return -1;
        }
        return 0;
    }
    public int checkYBorder(int PlayerYPosition) {
        if (PlayerYPosition > this.getyPositionMaximum()) {
            return 1;
        } else if (PlayerYPosition < this.getyPositionMinimum()) {
            return -1;
        }
        return 0;
    }
    public int textXBorder(int PlayerXPosition) {
        if (PlayerXPosition == this.getxPositionMaximum()) {
            return 1;
        } else if (PlayerXPosition == this.getxPositionMinimum()) {
            return -1;
        }
        return 0;
    }
    public int textYBorder(int PlayerYPosition) {
        if (PlayerYPosition == this.getyPositionMaximum()) {
            return 1;
        } else if (PlayerYPosition == this.getyPositionMinimum()) {
            return -1;
        }
        return 0;
    }

}

