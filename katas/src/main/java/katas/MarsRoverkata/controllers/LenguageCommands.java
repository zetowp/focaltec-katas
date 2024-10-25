package katas.MarsRoverkata.controllers;

import katas.MarsRoverkata.Direction;

public interface LenguageCommands {

    char spinClockWise();

    char spinCounterClockWise();

    char move();

    String getDirectionDescription(Direction dir);

}
