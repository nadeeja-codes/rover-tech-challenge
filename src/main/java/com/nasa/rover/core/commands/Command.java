package com.nasa.rover.core.commands;

@FunctionalInterface
public interface Command<T> {
    T execute();
}
