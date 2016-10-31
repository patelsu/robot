package com.rea.codeexam.robot;


/**
 * Created by sujan on 31/10/2016.
 */
public class MoveCommand extends Command{

    public MoveCommand(Robot robot){
        super(robot);
    }

    @Override
    public void execute() {
        try {
            Location location = getNewLocation(robot.getLocation(), robot.getDirection());
            if(!robot.setLocation(location)){
                System.out.println("Cannot Move ");
            }

        }catch (UninitializedException ex){

        }
    }

   private Location getNewLocation(Location location, Direction.DirectionEnum currentDirection){
       Location newLocation = null;
       switch (currentDirection){
           case NORTH:
               newLocation = location.moveY(1);
               break;
           case EAST:
               newLocation = location.moveX(1);
               break;
           case SOUTH:
               newLocation = location.moveY(-1);
               break;
           case WEST:
               newLocation = location.moveX(-1);
               break;

       }
       return newLocation;
   }
}
