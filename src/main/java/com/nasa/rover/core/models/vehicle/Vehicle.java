package com.nasa.rover.core.models.vehicle;

import com.nasa.rover.core.models.Heading;
import com.nasa.rover.core.models.Position;
import lombok.Getter;
import lombok.Setter;

public abstract class Vehicle {
    @Getter
    @Setter
    private Position position;
}
