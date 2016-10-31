package com.rea.codeexam.robot;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Unit test for App Class.
 */
public class AppTest
{
   @Test
   public void testInvalidInstructions(){

       App app = new App();
       Command command =  app.processInstruction("INVALID");
       assertNull(command);
       command = app.processInstruction("PLACE 0,2");
       assertNull(command);
       command = app.processInstruction("PLACE 0,2 NORTH");
       assertNull(command);
       command = app.processInstruction("MOV");
       assertNull(command);
   }


   @Test
   public void testValidInstructions(){
       App app = new App();
       Command command =  app.processInstruction("MOVE");
       assertNotNull(command);
       command = app.processInstruction("MOVE 0,2");
       assertNotNull(command);
       command = app.processInstruction("PLACE 0,2, NORTH");
       assertNotNull(command);
       command = app.processInstruction("REPORT");
       assertNotNull(command);
       command = app.processInstruction("RIGHT");
       assertNotNull(command);
       command = app.processInstruction("LEFT");
       assertNotNull(command);
   }
}
