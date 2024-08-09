package katas.MarsRoverkata.test;

import katas.MarsRoverkata.Direction;
import katas.MarsRoverkata.controllers.LenguageCommands;


public class LenguageCommandsEspaniol implements LenguageCommands {

    @Override
    public char spinClockWise() {
        return 'D';
    }

    @Override
    public char spinCounterClockWise() {
        return 'I';
    }

    @Override
    public char move() {
        return 'A';
    }

    @Override
    public String getDirectionDescription(Direction dir) {
        return String.format("direccion: %s", getDirSpanish(dir));
    }

    private String getDirSpanish(Direction dir) {
        switch (dir) {
            case EAST:
                return "ESTE";
            case WEST:
                return "OESTE";
            case NORTH:
                return "NORTE";
            case SOUTH:
                return "SUR";
        }
        return null;
    }

}
