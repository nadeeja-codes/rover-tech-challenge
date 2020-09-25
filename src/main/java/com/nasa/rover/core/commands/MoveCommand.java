package com.nasa.rover.core.commands;

import com.nasa.rover.core.models.Heading;
import com.nasa.rover.core.models.Position;
import com.nasa.rover.core.models.vehicle.Vehicle;

public class MoveCommand implements Command<Position> {

    private Vehicle vehicle;
    private Heading heading;

    public MoveCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public Position execute() {
        return vehicle.move();
    }
}
