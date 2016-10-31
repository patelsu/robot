package com.rea.codeexam.robot;

/**
 * Created by sujan on 31/10/2016.
 */

public class Location {


    private int xAxis = -1;
    private int yAxis = -1;

    public Location(int x, int y){
        this.xAxis = x;
        this.yAxis = y;
    }

    public int getxAxis() {
        return xAxis;
    }

    public int getyAxis() {
        return yAxis;
    }

    public Location moveY(int y){
        return new Location(this.xAxis, this.yAxis + y);
    }

    public Location moveX(int x){
        return new Location(this.xAxis + x , this.yAxis);
    }
    public static Location getLocation(String x, String y){

            int xInt = Integer.parseInt(x);
            int yInt = Integer.parseInt(y);
            return  new Location(xInt,yInt);

    }

    @Override
    public String toString() {
        return xAxis + "," + yAxis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (xAxis != location.xAxis) return false;
        return yAxis == location.yAxis;

    }

    @Override
    public int hashCode() {
        int result = xAxis;
        result = 31 * result + yAxis;
        return result;
    }
}