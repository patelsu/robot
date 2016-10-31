package com.rea.codeexam.robot;
import com.rea.codeexam.robot.Direction.DirectionEnum;

/**
 * Created by sujan on 31/10/2016.
 */
public class Robot {

  private Location location = null;
  private DirectionEnum direction = null;
    
  private final int X_BOARDLIMIT;
  private final int Y_BOARDLIMIT;

  public Robot(int XBOARDLIMIT, int YBOARDLIMIT){
      if(XBOARDLIMIT > 0 && YBOARDLIMIT > 0) {
          this.X_BOARDLIMIT = XBOARDLIMIT;
          this.Y_BOARDLIMIT = YBOARDLIMIT;
      }else{
          throw new IllegalArgumentException("Axis limit must be positive");
      }
  }


  public void initialize(DirectionEnum direction, Location location){

      if(direction != null && isValidLocation(location)){
          this.direction = direction;
          this.location = location;
          System.out.println(this);
      }
  }

  public boolean setLocation(Location location) {
        if (initialized() && isValidLocation(location)) {
            this.location = location;
            System.out.println(this);
            return true;
        }
        return false;
  }


  public boolean setDirection(DirectionEnum direction){

      if(initialized() && direction != null){
          this.direction = direction;
          System.out.println(this);
          return true;
      }
      return false;
  }

  public Location getLocation() throws UninitializedException {
      if(initialized())
        return location;
      else
          throw new UninitializedException();


  }

  public DirectionEnum getDirection() throws UninitializedException{
      if(initialized()){
          return direction;
      } else
          throw new UninitializedException();

  }


  public boolean initialized()
  {
      if (location != null && direction != null){
          return true;
      }
      return false;
  }

  private boolean isValidLocation(Location location){
     if( location != null && validAxis(location.getxAxis() ,X_BOARDLIMIT) && validAxis(location.getyAxis() ,Y_BOARDLIMIT))
     {
         return true;
     }
     return false;

  }

  private boolean validAxis(int val, int limit){
      if(val >= 0 && val < limit){
          return true;
      }
      return  false;
  }


    @Override
    public String toString() {
        return "Robot{" +
                 location +
                ", direction=" + direction +
                '}';
    }
}
