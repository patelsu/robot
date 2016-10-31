package com.rea.codeexam.robot;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sujan on 31/10/2016.
 */
public class RobotTest extends TestSetUp{

    @Test(expected = IllegalArgumentException.class)
    public void creatingRobotWithInvalidSizeFails()
    {

        Robot robot = new Robot(-1, 0);

    }

    @Test
    public void initializeWithNullDirectionFails() throws Exception {

        Robot robot = getUninitializedRobot();
        robot.initialize(null , new Location(0,0));
        assertFalse(robot.initialized());
    }

    @Test
    public void initalizeWithInvalidLocationFails() throws Exception {
        Robot robot = getUninitializedRobot();
        //negative axis
        robot.initialize(null , new Location(-1,0));
        assertFalse(robot.initialized());
        //greater then max axis
        robot.initialize(null , new Location(7,0));
        assertFalse(robot.initialized());
    }

    @Test
    public void successfulInitialization() throws Exception {
        Robot robot = getUninitializedRobot();
        Location location = new Location(0,0);
        robot.initialize(Direction.DirectionEnum.EAST , location);
        assertTrue(robot.initialized());
        assertTrue(robot.getDirection() == Direction.DirectionEnum.EAST);
        assertTrue(robot.getLocation().equals(location));
    }
    @Test
    public void cannotSetLocationOnUninitializedRobot() throws Exception {
        Robot robot = new Robot(5,5);
        assertFalse(robot.setLocation(new Location(0,0)));
    }

    @Test
    public void cannotSetInvalidLocation() throws Exception{
        Robot robot = getInitializedRobot();
        Location location = robot.getLocation();
        assertFalse(robot.setLocation(new Location(5,0)));
        assertTrue(robot.getLocation().equals(location));

    }

    @Test
    public void setValidLocationisSuccessful() throws Exception{

        Robot robot = getInitializedRobot();
        Location newLocation = new Location(1, 1);
        robot.setLocation(newLocation);
        assertTrue(robot.getLocation().equals(newLocation));
    }

    @Test
    public void cannotSetDirectionOnUninitializedRobot() throws Exception {
        Robot robot = getUninitializedRobot();
        assertFalse(robot.setDirection(Direction.DirectionEnum.EAST));
    }

    @Test
    public void setValidDirectionSuccessful() throws Exception {
        Robot robot = getInitializedRobot();
        assertTrue(robot.setDirection(Direction.DirectionEnum.NORTH));
        assertTrue(robot.getDirection() == Direction.DirectionEnum.NORTH);

    }

    @Test(expected = UninitializedException.class)
    public void getLocationOnUninitializedRobotFails() throws Exception {
        Robot robot = new Robot(5,5);
        robot.getLocation();
    }

    @Test(expected = UninitializedException.class)
    public void getDirectionOnUninitializedRobotFails() throws Exception {

        Robot robot = getUninitializedRobot();
        robot.getDirection();
    }


}