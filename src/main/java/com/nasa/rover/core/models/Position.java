package com.nasa.rover.core.models;

import lombok.Data;

@Data
public class Position {
    private final Point location;
    private final Heading heading;
}
