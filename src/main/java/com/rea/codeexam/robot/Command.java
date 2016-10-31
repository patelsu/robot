package com.rea.codeexam.robot;

/**
 * Created by tabcorp on 31/10/2016.
 */
public abstract class Command {

    Robot robot;
    public Command(Robot robot){

        this.robot = robot;
    }
    public abstract void execute();
}
