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
public class A3Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creating new city
        City kw = new City();

        //creating karel the robot
        Robot karel = new Robot(kw, 1, 1, Direction.EAST);

        //creating the walls
        new Wall(kw, 1, 1, Direction.NORTH);
        new Wall(kw, 1, 1, Direction.WEST);
        new Wall(kw, 1, 2, Direction.NORTH);
        new Wall(kw, 1, 3, Direction.NORTH);
        new Wall(kw, 1, 4, Direction.NORTH);
        new Wall(kw, 1, 4, Direction.EAST);
        new Wall(kw, 2, 4, Direction.EAST);
        new Wall(kw, 3, 4, Direction.EAST);
        new Wall(kw, 3, 4, Direction.SOUTH);
        new Wall(kw, 3, 3, Direction.SOUTH);
        new Wall(kw, 3, 2, Direction.SOUTH);
        new Wall(kw, 3, 1, Direction.SOUTH);
        new Wall(kw, 3, 1, Direction.WEST);
        new Wall(kw, 2, 1, Direction.WEST);

        //creating the things
        new Thing(kw, 1, 2);
        new Thing(kw, 2, 2);
        new Thing(kw, 2, 3);
        new Thing(kw, 2, 4);
        new Thing(kw, 3, 4);
        new Thing(kw, 3, 1);

        //getting karel to turn left
        karel.turnLeft();
        karel.turnLeft();
        karel.turnLeft();

        //making karel move and pick up trash
        while (true) {
            //getting karel to move
            if (karel.frontIsClear()) {
                karel.move();
            }
            //making karel pick up things
            while (karel.canPickThing()) {
                karel.pickThing();
            }
            //if front isn't clear and karel is facing south karel moves
            //making sure that karel picks up every thing
            if (!karel.frontIsClear() && karel.getDirection() == Direction.SOUTH) {
                while (karel.canPickThing()) {
                    karel.pickThing();
                }
                karel.turnLeft();
                karel.move();
                karel.turnLeft();
                while (karel.canPickThing()) {
                    karel.pickThing();
                }
            }
            //if frint isn't clear and karel is facing north karel moves
            //making sure that karel picks up every thing
            if (!karel.frontIsClear() && karel.getDirection() == Direction.NORTH) {
                while (karel.canPickThing()) {
                    karel.pickThing();
                }
                karel.turnLeft();
                karel.turnLeft();
                karel.turnLeft();
                if (karel.frontIsClear()) {
                    karel.move();

                    karel.turnLeft();
                    karel.turnLeft();
                    karel.turnLeft();
                    while (karel.canPickThing()) {
                        karel.pickThing();
                    }

                } //breaking the loop
                else if (!karel.frontIsClear() && karel.getDirection() == Direction.EAST) {
                    break;
                }

            }

        }
        //if karel is facing east karel turns
        if (karel.getDirection() == Direction.EAST) {
            karel.turnLeft();
            karel.turnLeft();
        }
        //getting karel to move to the end of the box then turn left
        if (karel.getDirection() == Direction.WEST && karel.frontIsClear()) {
            karel.move();
            if (!karel.frontIsClear()) {
                karel.turnLeft();
                karel.turnLeft();
                karel.turnLeft();

            }
        }
        //getting karel to reach the top end of the box then turn east
        if (karel.getDirection() == Direction.NORTH && karel.frontIsClear()) {
            karel.move();
            if (!karel.frontIsClear()) {
                karel.turnLeft();
                karel.turnLeft();
                karel.turnLeft();
            }
        }
    }
}
