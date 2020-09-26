package com.nasa.rover.core.models.vehicle;

import com.nasa.rover.core.models.Position;

public interface Turnable {
    Position turn(TurnDirection direction);
}
