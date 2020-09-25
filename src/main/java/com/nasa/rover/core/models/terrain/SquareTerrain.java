package com.nasa.rover.core.models.terrain;

import com.nasa.rover.core.models.Point;

public class SquareTerrain extends Terrain {

    private Point lowerLeft;
    private Point upperRight;

    public SquareTerrain(Point lowerLeft, Point upperRight) {
        this.lowerLeft = lowerLeft;
        this.upperRight = upperRight;
    }

    @Override
    public boolean checkBounds(Point point) {
        if (point.getX() < lowerLeft.getX() ||
        point.getY() < lowerLeft.getY() ||
        point.getX() > upperRight.getX() ||
        point.getY() > upperRight.getY()) {
            return false;
        }
        return true;
    }
}
