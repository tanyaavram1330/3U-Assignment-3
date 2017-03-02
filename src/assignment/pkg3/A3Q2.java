/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Wall;

/**
 *
 * @author anisoaraavram
 */
public class A3Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creating city
        City kw = new City();

        //creating karel the robot
        Robot karel = new Robot(kw, 0, 2, Direction.WEST);

        //creating the walls
        new Wall(kw, 1, 2, Direction.NORTH);
        new Wall(kw, 1, 2, Direction.EAST);
        new Wall(kw, 1, 1, Direction.NORTH);
        new Wall(kw, 1, 1, Direction.WEST);
        new Wall(kw, 2, 1, Direction.WEST);
        new Wall(kw, 2, 1, Direction.SOUTH);
        new Wall(kw, 2, 2, Direction.SOUTH);
        new Wall(kw, 2, 2, Direction.EAST);

        //moving karel once before the condition
        karel.move();
        karel.move();
        karel.turnLeft();

        //moving karel to move in a condition
        for (int i = 0; i < 7; i++) {
            karel.move();
            karel.move();
            karel.move();
            karel.turnLeft();
        }

        //moving karel one final time
        karel.move();
    }

}
