package com.rea.codeexam.robot;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sujan on 31/10/2016.
 */
public class TurnCommandTest extends TestSetUp{

    @Test(expected = UninitializedException.class)
    public void turnCommandOnUninitializedRobotFails() throws Exception{
        Robot robot = getUninitializedRobot();
        Command command = new TurnCommand(robot, false);
        command.execute();
        robot.getDirection();
    }

    @Test
    public void turnLeftTest() throws Exception{
        Robot robot = getInitializedRobot(new Location(0,0), Direction.DirectionEnum.NORTH);
        executeCommandAndAssert(Direction.DirectionEnum.WEST, robot, false);
        executeCommandAndAssert(Direction.DirectionEnum.SOUTH, robot, false);
        executeCommandAndAssert(Direction.DirectionEnum.EAST, robot, false);
        executeCommandAndAssert(Direction.DirectionEnum.NORTH, robot, false);


    }

    @Test
    public void turnRightTest() throws Exception{
        Robot robot = getInitializedRobot(new Location(0,0), Direction.DirectionEnum.NORTH);
        executeCommandAndAssert(Direction.DirectionEnum.EAST, robot, true);
        executeCommandAndAssert(Direction.DirectionEnum.SOUTH, robot, true);
        executeCommandAndAssert(Direction.DirectionEnum.WEST, robot, true);
        executeCommandAndAssert(Direction.DirectionEnum.NORTH, robot, true);
    }

    private void executeCommandAndAssert(Direction.DirectionEnum direction, Robot robot, boolean turnRight) throws Exception{
        Command command = new TurnCommand(robot, turnRight);
        command.execute();
        assertTrue(robot.getDirection() == direction);
    }



}