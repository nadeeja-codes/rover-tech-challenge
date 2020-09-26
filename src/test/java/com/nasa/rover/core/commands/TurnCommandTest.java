package com.nasa.rover.core.commands;

import com.nasa.rover.core.models.position.Heading;
import com.nasa.rover.core.models.position.Point;
import com.nasa.rover.core.models.position.Position;
import com.nasa.rover.core.models.terrain.SquareTerrain;
import com.nasa.rover.core.models.terrain.Terrain;
import com.nasa.rover.core.models.vehicle.Rover;
import com.nasa.rover.core.models.vehicle.TurnDirection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurnCommandTest {

    Terrain terrain;
    Rover rover;

    @BeforeEach
    void setUp() {
        terrain = new SquareTerrain(new Point(0,0), new Point(5,5));
        rover = new Rover(Position.zero(), terrain);
    }

    @Test
    void execute_should_return_new_position() {
        Position position = new TurnCommand(rover, TurnDirection.RIGHT).execute();

        assertEquals(0, position.getLocation().getX());
        assertEquals(0, position.getLocation().getY());
        assertEquals(Heading.EAST, position.getHeading());
    }
}