package katas.MarsRoverkata;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


public class MarsRoverKata {

    @Test
    public void doWalkTest() {
        assertMArsWalk("MMMMMLMMMRMMXMMMM", new MarsObject[] {}, 7, 1);
        assertMArsWalk("MMMMMLMMMRMMMMMM", new MarsObject[] { new MarsObject(1, 1) }, 7, 1);
        assertMArsWalk("MMMMMLMMMRMMMMMM", new MarsObject[] { new MarsObject(8, 5) }, 9, 5);
        assertMArsWalk("MMMMMLMMMRMMMMMM", new MarsObject[] { new MarsObject(8, 5), new MarsObject(0, 3) }, 0, 2);
    }

    private void assertMArsWalk(String commands, MarsObject[] obstacles, int expX, int expY) {
        TowerControl tower = new TowerControl(10, 10, obstacles);
        MarsRover rover = new MarsRover();
        tower.doWalk(rover, commands);
        assertEquals(expX, rover.x);
        assertEquals(expY, rover.y);
    }

}

class TowerControl {

    private int limitX;

    private int limitY;

    private MarsObject[] obstacles;
    
    


    public TowerControl(int limitX, int limitY, MarsObject... obstacles) {
        this.limitX = limitX;
        this.limitY = limitY;
        this.obstacles = obstacles;
    }

    public void doWalk(MarsRover rover, String allCommands) {
        for(RoverCommand c : toCommands(allCommands)) {
            c.execute(rover);
            if (detectCollition(rover)) {
                c.rollback(rover);
                return;
            }
        }
        System.out.println(rover);
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
        switch (c) {
            case 'L':
                return spinRover(false);
            case 'R':
                return spinRover(true);
            case 'M':
                return moveRover();
            default:
                return doNothing();
        }
    }

    private RoverCommand spinRover(boolean dir) {
        return new RoverCommand() {

            @Override
            public void rollback(MarsRover rover) {
                rover.dir = rover.dir.spin(!dir);
            }

            @Override
            public void execute(MarsRover rover) {
                rover.dir = rover.dir.spin(dir);
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
                if (rover.dir.isX()) {
                    rover.x = Direction.inLimit(rover.x, dir * rover.dir.getAdd(), limitX);
                } else {
                    rover.y = Direction.inLimit(rover.y, dir * rover.dir.getAdd(), limitY);
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
