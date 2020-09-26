package com.nasa.rover.core.models.position;

public enum Heading {
    NORTH(0),
    EAST(90),
    SOUTH(180),
    WEST(270);

    public final int headingValue;

    Heading(int i) {
        this.headingValue = i;
    }

    public static Heading fromValue(int value) {
        switch (value) {
            case 0:
            case 360: return NORTH;
            case 90: return EAST;
            case 180: return SOUTH;
            case 270: return WEST;
        }
        return NORTH;
    }

    public static Heading fromCode(String value) {
        switch (value) {
            case "N": return NORTH;
            case "E": return EAST;
            case "S": return SOUTH;
            case "W": return WEST;
        }
        return NORTH;
    }

    public static char toCode(Heading heading) {
        switch (heading) {
            case NORTH: return 'N';
            case EAST: return 'E';
            case SOUTH: return 'S';
            case WEST: return 'W';
        }
        return 'N';
    }
}
