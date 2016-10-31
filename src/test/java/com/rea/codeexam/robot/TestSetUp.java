package com.rea.codeexam.robot;

/**
 * Created by tabcorp on 31/10/2016.
 */
public class TestSetUp {

    protected Robot getUninitializedRobot(){
        return new Robot(5,5);
    }
    protected Robot getInitializedRobot(){
        Robot robot = new Robot(5,5);
        Location location = new Location(0,0);
        robot.initialize(Direction.DirectionEnum.EAST , location);
        return robot;
    }

    protected  Robot getInitializedRobot(Location location, Direction.DirectionEnum direction){
        Robot robot = new Robot(5,5);
        robot.initialize(direction , location);
        return  robot;
    }


}
