package com.nasa.rover.core.models.terrain;

import com.nasa.rover.core.models.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTerrainTest {

    @Test
    void checkBounds_should_return_true_when_in_bounds() {
        Terrain terrain = new SquareTerrain(new Point(0, 0), new Point(5, 5));

        assertEquals(true, terrain.checkBounds(new Point(1,1)));
    }

    @Test
    void checkBounds_should_return_false_when_out_of_bounds() {
        Terrain terrain = new SquareTerrain(new Point(0, 0), new Point(5, 5));

        assertEquals(false, terrain.checkBounds(new Point(6,5)));
    }
}