package com.nasa.rover.core.models.terrain;

import com.nasa.rover.core.models.position.Point;

public abstract class Terrain {
    public abstract boolean checkBounds(Point point);
}
