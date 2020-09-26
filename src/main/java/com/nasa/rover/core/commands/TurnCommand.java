package com.nasa.rover.core.commands;

import com.nasa.rover.core.models.position.Position;
import com.nasa.rover.core.models.vehicle.TurnDirection;
import com.nasa.rover.core.models.vehicle.Turnable;

public class TurnCommand implements Command<Position> {

    private final Turnable turnable;
    private final TurnDirection direction;

    public TurnCommand(Turnable turnable, TurnDirection direction) {
        this.turnable = turnable;
        this.direction = direction;
    }

    @Override
    public Position execute() {
        return turnable.turn(direction);
    }
}
