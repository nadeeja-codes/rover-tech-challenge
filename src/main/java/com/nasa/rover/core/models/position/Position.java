package com.nasa.rover.core.models.position;

import com.nasa.rover.core.models.vehicle.TurnDirection;
import lombok.Data;

@Data
public class Position {
    private final Point location;
    private final Heading heading;
    
    public static Position zero() {
        return new Position(new Point(0,0), Heading.NORTH);
    }

    public Position transform(Heading heading, int units) {
        switch (heading) {
            case NORTH: return new Position(new Point(location.getX(), location.getY() + units), heading);
            case SOUTH: return new Position(new Point(location.getX(), location.getY() - units), heading);
            case WEST: return new Position(new Point(location.getX() - units, location.getY()), heading);
            case EAST: return new Position(new Point(location.getX() + units, location.getY()), heading);
            default: return this;
        }
    }

    public Position rotate(TurnDirection direction) {
        switch (direction) {
            case LEFT: {
                int newHeadingValue = heading.headingValue - 90;
                // if heading value goes negative, add 360 to match heading enum values
                if (newHeadingValue < 0) newHeadingValue += 360;
                return new Position(location, Heading.fromValue(newHeadingValue));
            }
            case RIGHT: return new Position(location, Heading.fromValue(heading.headingValue + 90));
            default: return this;
        }
    }

    public String toString() {
        return String.format("%d %d %c", location.getX(), location.getY(), Heading.toCode(heading));
    }

}
