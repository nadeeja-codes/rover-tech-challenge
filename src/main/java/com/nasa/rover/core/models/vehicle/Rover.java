package com.nasa.rover.core.models.vehicle;

import com.nasa.rover.core.models.Heading;
import com.nasa.rover.core.models.Position;
import com.nasa.rover.core.models.terrain.Terrain;

public class Rover extends Vehicle {

    private Terrain terrain;

    public Rover(Position position, Terrain terrain) {
        this.terrain = terrain;
        setPosition(position);
    }

    @Override
    public Position move() {
        // Rovers are assumed to move one unit per move
        Position newPosition = getPosition().transform(getPosition().getHeading(), 1);
        if (!terrain.checkBounds(newPosition.getLocation())) {
            throw new IndexOutOfBoundsException("New position is out of bounds from terrain");
        }
        
        setPosition(newPosition);
        return newPosition;
    }
}
