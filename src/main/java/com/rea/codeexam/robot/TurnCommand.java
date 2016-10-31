package com.rea.codeexam.robot;

/**
 * Created by tabcorp on 31/10/2016.
 */
public class TurnCommand extends Command {

    private boolean right = false;
    public TurnCommand(Robot robot, boolean right){
        super(robot);
        this.right = right;
    }

    @Override
    public void execute(){
        try {

            if (right) {
                robot.setDirection(robot.getDirection().turnRight());
            } else {
                robot.setDirection(robot.getDirection().turnLeft());
            }
        } catch (Exception ex) {
            System.out.println("Changing direction failed " + ex);
        }
    }


}
