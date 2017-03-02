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
public class A3Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // crwate new city
        City kw = new City();

        //creating wall
        new Wall(kw, 1, 5, Direction.WEST);
        new Wall(kw, 2, 5, Direction.EAST);

        //creating robot named karel
        Robot karel = new Robot(kw, 1, 1, Direction.EAST);
        //creating second robot named bob
        Robot bob = new Robot(kw, 2, 1, Direction.EAST);

        // creating thing
        new Thing(kw, 1, 3);
        new Thing(kw, 1, 4);
        new Thing(kw, 2, 6);

        //getting karel to stop at the thing
        for (int i = 0; i < 2; i++) {
            karel.move();
        }

        //getting bob to stop at the wall
        for (int i = 0; i < 4; i++) {
            bob.frontIsClear();
            bob.move();
        }

    }

}
