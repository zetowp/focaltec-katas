package katas.MarsRoverkata.controllers;

import java.util.ArrayList;
import java.util.List;

import katas.MarsRoverkata.Direction;
import katas.MarsRoverkata.MarsObject;
import katas.MarsRoverkata.MarsRover;

public class TowerControl {

    private int limitX;

    private int limitY;

    private MarsObject[] obstacles;

    private LenguageCommands leng;

    public TowerControl(LenguageCommands lang, int limitX, int limitY, MarsObject... obstacles) {
        this.limitX = limitX;
        this.limitY = limitY;
        this.obstacles = obstacles;
        this.leng = lang;
    }

    public void doWalk(MarsRover rover, String allCommands) {
        for (RoverCommand c : toCommands(allCommands)) {
            c.execute(rover);
            if (detectCollition(rover)) {
                c.rollback(rover);
                return;
            }
        }
        System.out.println(printLocation(rover));
    }

    private String printLocation(MarsRover rover) {
        return String.format("%s, %s", rover.toString(), leng.getDirectionDescription(rover.getDir()));
    }

    private boolean detectCollition(MarsRover rover) {
        for (MarsObject obstacle : obstacles) {
            if (obstacle.collition(rover))
                return true;
        }
        return false;
    }

    private List<RoverCommand> toCommands(String allCommands) {
        List<RoverCommand> commands = new ArrayList<>();
        for (char c : allCommands.toCharArray()) {
            commands.add(toCommand(c));
        }
        return commands;
    }

    private RoverCommand toCommand(char c) {
        if (c == leng.spinCounterClockWise())
            return spinRover(false);
        if (c == leng.spinClockWise())
            return spinRover(true);
        if (c == leng.move())
            return moveRover();
        return doNothing();
    }

    private RoverCommand spinRover(boolean dir) {
        return new RoverCommand() {

            @Override
            public void rollback(MarsRover rover) {
                rover.setDir(rover.getDir().spin(!dir));
            }

            @Override
            public void execute(MarsRover rover) {
                rover.setDir(rover.getDir().spin(dir));
            }
        };
    }

    private RoverCommand moveRover() {
        return new RoverCommand() {

            @Override
            public void rollback(MarsRover rover) {
                move(rover, -1);
            }

            private void move(MarsRover rover, int dir) {
                if (rover.getDir().isX()) {
                    rover.setX(Direction.inLimit(rover.getX(), dir * rover.getDir().getAdd(), limitX));
                } else {
                    rover.setY(Direction.inLimit(rover.getY(), dir * rover.getDir().getAdd(), limitY));
                }
            }

            @Override
            public void execute(MarsRover rover) {
                move(rover, 1);
            }
        };
    }

    private RoverCommand doNothing() {
        return new RoverCommand() {

            @Override
            public void rollback(MarsRover rover) {
            }

            @Override
            public void execute(MarsRover rover) {
            }
        };
    }

}
