package katas.MarsRoverkata.controllers;

import katas.MarsRoverkata.MarsRover;

public interface RoverCommand {

    void execute(MarsRover rover);

    void rollback(MarsRover rover);

}
