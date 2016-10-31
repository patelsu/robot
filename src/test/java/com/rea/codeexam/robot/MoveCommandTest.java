package com.rea.codeexam.robot;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sujan on 31/10/2016.
 */
public class MoveCommandTest extends TestSetUp {

    @Test(expected = UninitializedException.class)
    public void noMoveOnUninitializedRobot() throws Exception {
        Robot robot = getUninitializedRobot();
        Command command = getMoveCommand(robot);
        command.execute();
        assertFalse(robot.initialized());
        robot.getLocation();
    }

    @Test
    public void moveOutSideGridFails() throws Exception{
        Location location = new Location(0,0);
        Robot robot = getInitializedRobot(location, Direction.DirectionEnum.SOUTH);
        assertTrue(robot.getLocation().equals(location));
        //Moving south from 0, 0 location should fail
        executeCommandAssertLocation(location, robot);




        //set direction to west and check x axis grid
        robot.setDirection(Direction.DirectionEnum.WEST);
        executeCommandAssertLocation(location, robot);


        //place robot facing north at top of grid
        location = new Location(4,4);
        robot.setLocation(location);
        robot.setDirection(Direction.DirectionEnum.NORTH);
        assertTrue(robot.getLocation().equals(location));
        assertTrue(robot.getDirection().equals(Direction.DirectionEnum.NORTH));
        executeCommandAssertLocation(location, robot);

        //place robot facing east and check x axis max

        robot.setDirection(Direction.DirectionEnum.EAST);
        executeCommandAssertLocation(location, robot);

    }


    @Test
    public void moveWithinGridSuccessful() throws Exception{
        Location location = new Location(0,0);
        Robot robot = getInitializedRobot(location, Direction.DirectionEnum.NORTH);

        //move north
        executeCommandAssertLocation(new Location(0, 1), robot);
        executeCommandAssertLocation(new Location(0, 2), robot);

        //move east
        robot.setDirection(Direction.DirectionEnum.EAST);
        executeCommandAssertLocation(new Location(1,2),robot);
        executeCommandAssertLocation(new Location(2,2), robot);

        //move south
        robot.setDirection(Direction.DirectionEnum.SOUTH);
        executeCommandAssertLocation(new Location(2,1),robot);
        executeCommandAssertLocation(new Location(2,0), robot);

        //move west
        robot.setDirection(Direction.DirectionEnum.WEST);
        executeCommandAssertLocation(new Location(1,0),robot);
        executeCommandAssertLocation(new Location(0,0), robot);


    }


    private void executeCommandAssertLocation(Location location, Robot robot) throws Exception{
        Command command = getMoveCommand(robot);
        command.execute();
        assertTrue(robot.getLocation().equals(location));
    }

    private Command getMoveCommand(Robot robot){
        return new MoveCommand(robot);
    }

}