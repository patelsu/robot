package com.rea.codeexam.robot;

/**
 * Created by sujan on 31/10/2016.
 */
public class ReportCommand extends Command {

    public ReportCommand(Robot robot){
        super(robot);
    }

    @Override
    public void execute() {
        if(!robot.initialized()){
            System.out.println("Not initialized");
        }else{
            System.out.println(robot.toString());
        }
    }
}
