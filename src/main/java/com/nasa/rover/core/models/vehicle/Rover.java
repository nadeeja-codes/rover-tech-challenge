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
            throw new IndexOutOfBoundsException("Attempted Position is out of bounds from terrain: " + newPosition.toString());
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
