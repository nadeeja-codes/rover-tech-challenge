package com.nasa.rover.core.commands.factory;

import com.nasa.rover.core.commands.Command;
import com.nasa.rover.core.commands.MoveCommand;
import com.nasa.rover.core.commands.TurnCommand;
import com.nasa.rover.core.models.position.Position;
import com.nasa.rover.core.models.vehicle.Rover;
import com.nasa.rover.core.models.vehicle.TurnDirection;
import org.springframework.stereotype.Component;

@Component("roverCommandFactory")
public class RoverCommandFactory {

    public Command<Position> getCommand(String input, Rover rover) {

        switch (input) {
            case "M": return new MoveCommand(rover);
            case "L": return new TurnCommand(rover, TurnDirection.LEFT);
            case "R": return new TurnCommand(rover, TurnDirection.RIGHT);
            default: return null;
        }
    }
}
