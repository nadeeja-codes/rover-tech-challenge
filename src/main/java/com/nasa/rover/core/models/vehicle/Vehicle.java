package com.nasa.rover.core.models.vehicle;

import com.nasa.rover.core.models.position.Position;
import lombok.Getter;
import lombok.Setter;

public abstract class Vehicle {
    @Getter
    @Setter
    private Position position;
}
