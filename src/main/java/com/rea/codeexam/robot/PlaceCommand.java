package com.rea.codeexam.robot;
import com.rea.codeexam.robot.Direction.DirectionEnum;

/**
 * Created by sujan on 31/10/2016.
 */
public class PlaceCommand extends Command{

    private String xVal = null;
    private String yVal = null ;
    private String direction = null;

    public PlaceCommand(Robot robot, String xVal, String yVal, String direction){
        super(robot);
        this.xVal = xVal;
        this.yVal = yVal;
        this.direction = direction;
    }

    @Override
    public void execute() {
        try {
            Location location = Location.getLocation(xVal, yVal);
            DirectionEnum directionEnum= DirectionEnum.fromString(direction);
            robot.initialize(directionEnum, location);
        }catch (Exception ex)
        {
            System.out.println("Cannot execute place " + ex.getMessage());
        }
    }
}
