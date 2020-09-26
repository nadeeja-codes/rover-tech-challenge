package com.nasa.rover.core.executors;

import com.nasa.rover.core.commands.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutor<T> {
    private final List<Command<T>> commandList;
    private final List<T> commandResults;

    public CommandExecutor() {
        commandList = new ArrayList<>();
        commandResults = new ArrayList<>();
    }

    public CommandExecutor<T> add(Command<T> command) {
        commandList.add(command);
        return this;
    }

    public List<T> executeCommands() {
        try {
            for(Command<T> command : commandList) {
                commandResults.add(command.execute());
            }
            commandList.clear();
            return commandResults;

        } catch (Exception e) {
            // clear commandList in case of any exception
            commandList.clear();
            throw e;
        }
    }
}
