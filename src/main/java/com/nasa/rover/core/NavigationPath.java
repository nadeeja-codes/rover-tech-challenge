package com.nasa.rover.core;

import com.nasa.rover.core.commands.Command;
import com.nasa.rover.core.models.position.Position;
import com.nasa.rover.core.models.vehicle.Vehicle;
import lombok.Getter;

import java.util.List;

public class NavigationPath {

    @Getter
    private Vehicle vehicle;
    @Getter
    private List<Command<Position>> commands;

    public NavigationPath(Vehicle vehicle, List<Command<Position>> commands) {
        this.vehicle = vehicle;
        this.commands = commands;
    }
}
