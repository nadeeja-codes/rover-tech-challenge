package com.nasa.rover.core.models.vehicle;

import com.nasa.rover.core.models.position.Heading;
import com.nasa.rover.core.models.position.Point;
import com.nasa.rover.core.models.position.Position;
import com.nasa.rover.core.models.terrain.SquareTerrain;
import com.nasa.rover.core.models.terrain.Terrain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    Terrain terrain;
    Rover rover;

    @BeforeEach
    void setUp() {
        terrain = new SquareTerrain(new Point(0,0), new Point(5,5));
        rover = new Rover(Position.zero(), terrain);
    }

    @Test
    void moveTo_should_throw_if_out_of_bounds() {
        rover.setPosition(new Position(new Point(5, 5), Heading.NORTH));

        assertThrows(IndexOutOfBoundsException.class, () -> {
            Position position = rover.move();
        });
    }

    @Test
    void moveTo_should_return_new_position_after_moving() {
        rover.setPosition(new Position(new Point(5, 3), Heading.NORTH));

        Position position = rover.move();

        assertEquals(5, position.getLocation().getX());
        assertEquals(4, position.getLocation().getY());
        assertEquals(Heading.NORTH, position.getHeading());
    }

    @Test
    void rotate_should_return_new_heading_after_rotating() {
        rover.setPosition(new Position(new Point(5, 3), Heading.NORTH));

        Position position = rover.turn(TurnDirection.LEFT);

        assertEquals(5, position.getLocation().getX());
        assertEquals(3, position.getLocation().getY());
        assertEquals(Heading.WEST, position.getHeading());
    }
}