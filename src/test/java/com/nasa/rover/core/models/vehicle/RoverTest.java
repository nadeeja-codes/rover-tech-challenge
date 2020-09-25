package com.nasa.rover.core.models.vehicle;

import com.nasa.rover.core.models.Heading;
import com.nasa.rover.core.models.Point;
import com.nasa.rover.core.models.Position;
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
}