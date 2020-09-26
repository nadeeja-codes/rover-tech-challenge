package com.nasa.rover.core.models;

import com.nasa.rover.core.models.position.Heading;
import com.nasa.rover.core.models.position.Point;
import com.nasa.rover.core.models.position.Position;
import com.nasa.rover.core.models.vehicle.TurnDirection;
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

    @Test
    void rotate_should_return_new_heading_after_turn_left() {
        Position position = new Position(new Point(4,4), Heading.NORTH);

        Position newPosition = position.rotate(TurnDirection.LEFT);

        assertEquals(4, newPosition.getLocation().getX());
        assertEquals(4, newPosition.getLocation().getY());
        assertEquals(Heading.WEST, newPosition.getHeading());

    }

    @Test
    void rotate_should_return_new_heading_after_turn_right() {
        Position position = new Position(new Point(4,4), Heading.WEST);

        Position newPosition = position.rotate(TurnDirection.RIGHT);

        assertEquals(4, newPosition.getLocation().getX());
        assertEquals(4, newPosition.getLocation().getY());
        assertEquals(Heading.NORTH, newPosition.getHeading());

    }
}