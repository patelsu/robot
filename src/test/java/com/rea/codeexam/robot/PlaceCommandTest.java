package com.rea.codeexam.robot;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tabcorp on 31/10/2016.
 */
public class PlaceCommandTest {




    @Test
    public void validInitialization() throws Exception{

        Robot robot = new Robot(5,5);
        assertTrue(!robot.initialized());
        Command command = new PlaceCommand(robot, "4", "0", "NORTH");
        command.execute();
        assertTrue(robot.initialized());
        assertTrue(Location.getLocation("4", "0").equals(robot.getLocation()));
        assertTrue(robot.getDirection().equals(Direction.DirectionEnum.NORTH));

    }

    @Test
    public void invalidGridSize() {
        Robot robot = new Robot(5,5);
        assertTrue(!robot.initialized());
        //x greater then valid size
        Command command = new PlaceCommand(robot, "5", "0", "NORTH");
        command.execute();
        assertFalse(robot.initialized());

        //y smaller then zero

        command = new PlaceCommand(robot, "4", "-1", "NORTH");
        command.execute();
        assertFalse(robot.initialized());


    }

    @Test
    public void invalidDirection() throws Exception{

        Robot robot = new Robot(5,5);
        assertTrue(!robot.initialized());
        Command command = new PlaceCommand(robot, "5", "0", "NORTHEAST");
        command.execute();
        assertFalse(robot.initialized());
    }






}