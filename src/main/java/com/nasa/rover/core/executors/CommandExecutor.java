package com.nasa.rover.core.executors;

import com.nasa.rover.core.commands.Command;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;
import java.util.List;

@Component("commandExecutor")
@RequestScope
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

    public CommandExecutor<T> add(List<Command<T>> commands) {
        commandList.addAll(commands);
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
