package com.rea.codeexam.robot;

/**
 * Created by sujan on 31/10/2016.
 */
public class UninitializedException extends Exception {

    public UninitializedException(){
        super("Robot not initialized");
    }
}
