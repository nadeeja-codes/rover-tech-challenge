package com.nasa.rover.core.models;

import lombok.Data;

@Data
public class Position {
    private final Point location;
    private final Heading heading;

    public Position transform(Heading heading, int units) {
        switch (heading) {
            case NORTH: return new Position(new Point(location.getX(), location.getY() + units), heading);
            case SOUTH: return new Position(new Point(location.getX(), location.getY() - units), heading);
            case WEST: return new Position(new Point(location.getX() - units, location.getY()), heading);
            case EAST: return new Position(new Point(location.getX() + units, location.getY()), heading);
            default: return this;
        }
    }

    public static Position zero() {
        return new Position(new Point(0,0), Heading.NORTH);
    }
}
