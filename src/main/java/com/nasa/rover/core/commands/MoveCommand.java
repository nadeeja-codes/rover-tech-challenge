package com.nasa.rover.core.commands;

import com.nasa.rover.core.models.position.Position;
import com.nasa.rover.core.models.vehicle.Movable;

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
