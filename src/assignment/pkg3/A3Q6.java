/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.RobotSE;
import becker.robots.Thing;

/**
 *
 * @author anisoaraavram
 */
public class A3Q6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creaing a city
        City kw = new City();

        //knowing how many things are in the city
        kw.showThingCounts(true);

        //creating the robot
        RobotSE karel = new RobotSE(kw, 0, 1, Direction.SOUTH);

        //creating things
        //first batch of things
        new Thing(kw, 1, 1);
        new Thing(kw, 1, 1);
        new Thing(kw, 1, 1);
        //second abtch of things
        new Thing(kw, 2, 1);
        new Thing(kw, 2, 1);
        //thrid batch of things
        new Thing(kw, 3, 1);
        new Thing(kw, 3, 1);
        new Thing(kw, 3, 1);
        new Thing(kw, 3, 1);
        new Thing(kw, 3, 1);
        //Fourth batch of things
        new Thing(kw, 4, 1);
        new Thing(kw, 4, 1);
        new Thing(kw, 4, 1);
        new Thing(kw, 4, 1);

        //making a coutner
        int counter = 0;
        
        //moving karel
        karel.move();
        
        //while loop working as long as karel can pick up
        while (karel.canPickThing()){
            
            //karel picks things and counts up
            if (karel.canPickThing()){
                karel.pickAllThings();
                counter++;
            }
            
            //store counter as karel's backpack amount
            counter = karel.countThingsInBackpack();
            karel.turnLeft();
            //karel put things as he moves
            for (int i = 0; i < counter; i++){
                karel.putThing();
                karel.move();
            }
            
            //karel turns around once he is done a row
            karel.turnAround();
            
            // a counter variable used to move back X amount of things 
            for (int i = 0; i < counter;){
                karel.move();
                counter--;
            }
            
            //moving to the next row
            karel.turnLeft();
            karel.move();
        }
        
    }

}
