package katas.MarsRoverkata.test;

import katas.MarsRoverkata.controllers.LenguageCommands;


public class LenguageCommandsEnglish implements LenguageCommands {

    @Override
    public char spinClockWise() {
        return 'R';
    }

    @Override
    public char spinCounterClockWise() {
        return 'L';
    }

    @Override
    public char move() {
        return 'M';
    }

}
