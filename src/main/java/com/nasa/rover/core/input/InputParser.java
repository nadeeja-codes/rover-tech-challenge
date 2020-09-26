package com.nasa.rover.core.input;

import com.nasa.rover.core.NavigationPath;
import com.nasa.rover.core.commands.Command;
import com.nasa.rover.core.models.Position;
import com.nasa.rover.core.models.terrain.Terrain;
import com.nasa.rover.core.models.vehicle.Rover;

import java.util.List;

public interface InputParser {

    List<NavigationPath> parse() throws MalformedInputException;

}
