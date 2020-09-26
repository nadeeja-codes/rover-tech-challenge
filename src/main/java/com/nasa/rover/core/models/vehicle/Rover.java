package com.nasa.rover.core.models.vehicle;

import com.nasa.rover.core.models.position.Position;
import com.nasa.rover.core.models.terrain.Terrain;

public class Rover extends Vehicle implements Movable, Turnable {

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

    @Override
    public Position turn(TurnDirection direction) {
        Position newPosition = getPosition().rotate(direction);

        setPosition(newPosition);
        return newPosition;
    }
}
