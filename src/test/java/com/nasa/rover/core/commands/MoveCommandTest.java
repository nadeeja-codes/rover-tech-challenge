package com.nasa.rover.core.commands;

import com.nasa.rover.core.models.Heading;
import com.nasa.rover.core.models.Point;
import com.nasa.rover.core.models.Position;
import com.nasa.rover.core.models.terrain.SquareTerrain;
import com.nasa.rover.core.models.terrain.Terrain;
import com.nasa.rover.core.models.vehicle.Rover;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoveCommandTest {

    Terrain terrain;
    Rover rover;

    @BeforeEach
    void setUp() {
        terrain = new SquareTerrain(new Point(0,0), new Point(5,5));
        rover = new Rover(Position.zero(), terrain);
    }

    @Test
    void execute_should_return_new_position() {
        Position position = new MoveCommand(rover).execute();

        assertEquals(0, position.getLocation().getX());
        assertEquals(1, position.getLocation().getY());
        assertEquals(Heading.NORTH, position.getHeading());
    }

    @Test
    void execute_should_throw_if_invalid_position() {
        rover = new Rover(new Position(new Point(0,0), Heading.SOUTH), terrain);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            Position position = new MoveCommand(rover).execute();
        });
    }
}