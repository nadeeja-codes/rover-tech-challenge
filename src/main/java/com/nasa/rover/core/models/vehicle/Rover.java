package com.nasa.rover.core.models.vehicle;

import com.nasa.rover.core.models.Position;
import com.nasa.rover.core.models.terrain.Terrain;

public class Rover extends Vehicle {

    private Terrain terrain;

    public Rover(Terrain terrain) {
        this.terrain = terrain;
    }

    @Override
    public Position moveTo(Position newPosition) {
        if (!terrain.checkBounds(newPosition.getLocation())) {
            throw new IndexOutOfBoundsException("New position is out of bounds from terrain");
        }
        setPosition(newPosition);
        return newPosition;
    }
}
