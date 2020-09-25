package com.nasa.rover.core.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void transform_should_return_transformed_position_Y() {
        Position position = new Position(new Point(4,4), Heading.NORTH);

        Position newPosition = position.transform(Heading.SOUTH, 1);

        assertEquals(4, newPosition.getLocation().getX());
        assertEquals(3, newPosition.getLocation().getY());
        assertEquals(Heading.SOUTH, newPosition.getHeading());
    }

    @Test
    void transform_should_return_transformed_position_X() {
        Position position = new Position(new Point(4,4), Heading.NORTH);

        Position newPosition = position.transform(Heading.WEST, 2);

        assertEquals(2, newPosition.getLocation().getX());
        assertEquals(4, newPosition.getLocation().getY());
        assertEquals(Heading.WEST, newPosition.getHeading());
    }

}