package com.rea.codeexam.robot;

/**
 * Created by tabcorp on 31/10/2016.
 */


public class Direction {

    public  enum DirectionEnum
    {
        NORTH, EAST, SOUTH, WEST;
        private static DirectionEnum[] vals = values();
        public DirectionEnum turnLeft()
        {
            return vals[(this.ordinal() + 1) % vals.length];
        }
        public DirectionEnum turnRight()
        {
            int idx = this.ordinal() - 1 % vals.length;
            if (idx < 0)
            {
                idx += vals.length;
            }
            return vals[idx];
        }

        public static DirectionEnum fromString(String direction){

            DirectionEnum directionEnum = null;
            if (direction.trim().equalsIgnoreCase(DirectionEnum.NORTH.toString()))
            {
                directionEnum = DirectionEnum.NORTH;
            } else if (direction.trim().equalsIgnoreCase(DirectionEnum.EAST.toString()))
            {
                directionEnum = DirectionEnum.EAST;
            } else if (direction.trim().equalsIgnoreCase(DirectionEnum.SOUTH.toString()))
            {
                directionEnum = DirectionEnum.SOUTH;
            } else if (direction.trim().equalsIgnoreCase(DirectionEnum.WEST.toString()))
            {
                directionEnum = DirectionEnum.WEST;
            }else
            {
                throw new IllegalArgumentException("Not a valid direction");
            }
            return directionEnum;
        }
    }






}
