/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;
import becker.robots.Wall;

/**
 *
 * @author anisoaraavram
 */
public class A3Q5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //creating a new city called kw
        City kw = new City();

        //seeing how many things are in the city
        kw.showThingCounts(true);

        //creating a new robot
        Robot karel = new Robot(kw, 1, 1, Direction.EAST);

        //creating a thing
        new Thing(kw, 1, 1);
        new Thing(kw, 1, 1);
        new Thing(kw, 1, 1);
        new Thing(kw, 1, 1);
        new Thing(kw, 1, 1);
        new Thing(kw, 1, 1);
        new Thing(kw, 1, 1);
        new Thing(kw, 1, 1);
        new Thing(kw, 1, 1);
        new Thing(kw, 1, 1);

        //making karel picking up things, move, place it, turn, and move
        while (true) {
            //making karel stop and move to the final spot
            if (!karel.canPickThing()) {
                karel.move();
                break;
            }
            if (karel.canPickThing()) {
                karel.pickThing();
                karel.move();
                karel.putThing();
                karel.turnLeft();
                karel.turnLeft();
                karel.move();
                karel.turnLeft();
                karel.turnLeft();
            }

        }
    }

}
