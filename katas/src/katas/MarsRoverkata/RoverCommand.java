package katas.MarsRoverkata;


public interface RoverCommand {

    void execute(MarsRover rover);

    void rollback(MarsRover rover);

}
