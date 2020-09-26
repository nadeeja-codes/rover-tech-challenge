package com.nasa.rover.core.commands;

import com.nasa.rover.core.models.Heading;
import com.nasa.rover.core.models.Position;
import com.nasa.rover.core.models.vehicle.Movable;
import com.nasa.rover.core.models.vehicle.Vehicle;

public class MoveCommand implements Command<Position> {

    private final Movable movable;

    public MoveCommand(Movable movable) {
        this.movable = movable;
    }

    @Override
    public Position execute() {
        return movable.move();
    }
}
