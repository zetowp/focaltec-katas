package katas.MarsRoverkata.test;

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

}
