package com.rea.codeexam.robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App {
    Robot robot = new Robot(5, 5);

    public enum Commands {
        PLACE, MOVE, LEFT, RIGHT, REPORT;
    }

    public static void main(String[] args) {

        App app = new App();
        System.out.println("Robot started!");

        System.out.println("PLACE X,Y,F\n" +
                "    MOVE\n" +
                "    LEFT\n" +
                "    RIGHT\n" +
                "    REPORT");

        while (true){
            BufferedReader  br = null;

            try {


                br = new BufferedReader(new InputStreamReader(System.in));

                while (true) {

                    System.out.print("Enter Command: ");

                    String input = br.readLine();

                    if ("q".equals(input)) {
                        System.out.println("Exit!");
                        System.exit(0);
                    }

                 //   System.out.println("input : " + input);
                    app.processInstruction(input);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }


    }


    public void processInstruction(String doit) {
        String inst = doit.trim();
        int idx = inst.indexOf(' ');
        if (idx > 0) {
            inst = inst.substring(0, idx);
        }

        Command command = null;
        if (inst.length() > 0) {
            if (inst.trim().equalsIgnoreCase(Commands.PLACE.toString()) && idx > 0) {
                String params = doit.trim().substring(idx);
                if (params != null && params.length() > 0) {
                    String[] paramVals = params.split(",");
                    if (paramVals.length > 0 && paramVals.length >= 3) {
                        command = new PlaceCommand(robot, paramVals[0].trim(), paramVals[1].trim(), paramVals[2].trim());
                    }
                }
            } else if (inst.trim().equalsIgnoreCase(Commands.MOVE.toString())) {
                command = new MoveCommand(robot);
            } else if (inst.trim().equalsIgnoreCase(Commands.LEFT.toString())) {
                command = new TurnCommand(robot, false);
            } else if (inst.trim().equalsIgnoreCase(Commands.RIGHT.toString())) {
                command = new TurnCommand(robot, true);
            } else if (inst.trim().equalsIgnoreCase(Commands.REPORT.toString())) {
                command = new ReportCommand(robot);
            }
        }
        if(command != null)
        {
            command.execute();
        }
    }
}
