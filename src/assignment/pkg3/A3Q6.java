package assignment.pkg3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author anisoaraavram
 */
public class A3Q6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creating a new city
        City kw = new City();

        //knowing how many things are in the city
        kw.showThingCounts(true);

        //creating the robot
        Robot karel = new Robot(kw, 0, 1, Direction.SOUTH);

        //creating the things
        //First batch of things
        new Thing(kw, 1, 1);
        new Thing(kw, 1, 1);
        new Thing(kw, 1, 1);
        //second batch of things
        new Thing(kw, 2, 1);
        new Thing(kw, 2, 1);
        //third batch of things
        new Thing(kw, 3, 1);
        new Thing(kw, 3, 1);
        new Thing(kw, 3, 1);
        new Thing(kw, 3, 1);
        new Thing(kw, 3, 1);
        //fourth batch of things
        new Thing(kw, 4, 1);
        new Thing(kw, 4, 1);
        new Thing(kw, 4, 1);
        new Thing(kw, 4, 1);

        //making a counter
        int counter = 0;
        int counter2 = 0;

        //moving karel
        karel.move();

        //getting karel to move with the first batch
        while (true) {
            for (int i = 0; i < 4;) {
                if (i == 0) {
                    counter2 = 3;
                }
                if (i == 1) {
                    counter2 = 2;
                }
                if (i == 3) {
                    counter2 = 5;
                }
                if (i == 4) {
                    counter2 = 4;
                }
                if (karel.canPickThing()) {
                    karel.pickThing();
                }
                if (!karel.canPickThing()) {
                    karel.turnLeft();
                    while (counter < counter2) {
                        karel.move();
                        karel.putThing();
                        counter = counter + 1;
                    }
                    if (!karel.canPickThing()) {
                        karel.putThing();
                        karel.turnLeft();
                        //getting karel to get to the avenue
                        while (karel.getAvenue() != 1) {
                            karel.move();
                        }
                        karel.turnLeft();
                        karel.move();
                    }
                }
                
            }
        }
    }

}
