package com.nasa.rover.core.models.vehicle;

import com.nasa.rover.core.models.position.Position;

public interface Turnable {
    Position turn(TurnDirection direction);
}
