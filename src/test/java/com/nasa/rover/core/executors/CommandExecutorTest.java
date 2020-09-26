package com.nasa.rover.core.executors;

import com.nasa.rover.core.commands.MoveCommand;
import com.nasa.rover.core.commands.TurnCommand;
import com.nasa.rover.core.models.Heading;
import com.nasa.rover.core.models.Point;
import com.nasa.rover.core.models.Position;
import com.nasa.rover.core.models.terrain.SquareTerrain;
import com.nasa.rover.core.models.terrain.Terrain;
import com.nasa.rover.core.models.vehicle.Rover;
import com.nasa.rover.core.models.vehicle.TurnDirection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommandExecutorTest {

    Terrain terrain;
    Rover rover;

    @BeforeEach
    void setUp() {
        terrain = new SquareTerrain(new Point(0,0), new Point(5,5));
        rover = new Rover(Position.zero(), terrain);
    }

    @Test
    void executeCommands_should_return_result_list_with_same_count_when_all_succeed() {
        CommandExecutor<Position> executor = new CommandExecutor<Position>();
        executor.add(new MoveCommand(rover));
        executor.add(new MoveCommand(rover));
        executor.add(new MoveCommand(rover));
        executor.add(new TurnCommand(rover, TurnDirection.RIGHT));
        executor.add(new MoveCommand(rover));
        executor.add(new TurnCommand(rover, TurnDirection.LEFT));
        executor.add(new MoveCommand(rover));

        List<Position> results = executor.executeCommands();

        assertEquals(7, results.size());
    }

    @Test
    void executeCommands_last_result_should_match_last_command_when_all_succeed() {
        CommandExecutor<Position> executor = new CommandExecutor<Position>();
        executor.add(new MoveCommand(rover));
        executor.add(new MoveCommand(rover));
        executor.add(new MoveCommand(rover));
        executor.add(new TurnCommand(rover, TurnDirection.RIGHT));
        executor.add(new MoveCommand(rover));
        executor.add(new TurnCommand(rover, TurnDirection.LEFT));
        executor.add(new MoveCommand(rover));

        List<Position> results = executor.executeCommands();
        Position position = results.get(results.size() - 1);

        assertEquals(1, position.getLocation().getX());
        assertEquals(4, position.getLocation().getY());
        assertEquals(Heading.NORTH, position.getHeading());

    }

    @Test
    void executeCommands_should_throw_when_a_command_fails() {
        CommandExecutor<Position> executor = new CommandExecutor<Position>();
        executor.add(new MoveCommand(rover));
        executor.add(new MoveCommand(rover));
        executor.add(new MoveCommand(rover));
        executor.add(new TurnCommand(rover, TurnDirection.RIGHT));
        executor.add(new MoveCommand(rover));
        executor.add(new TurnCommand(rover, TurnDirection.LEFT));
        executor.add(new MoveCommand(rover));

        executor.add(new MoveCommand(rover));
        executor.add(new MoveCommand(rover));
        executor.add(new MoveCommand(rover));

        assertThrows(IndexOutOfBoundsException.class, () -> {
            List<Position> results = executor.executeCommands();
        });
    }
}