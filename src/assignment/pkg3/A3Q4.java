package assignment.pkg3;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Wall;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author anisoaraavram
 */
public class A3Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creating city called kw
        City kw = new City();

        //creating the robot
        Robot karel = new Robot(kw, 2, 2, Direction.SOUTH);

        //creating top side of the walls:1
        new Wall(kw, 1, 1, Direction.NORTH);
        new Wall(kw, 1, 3, Direction.NORTH);
        new Wall(kw, 1, 4, Direction.NORTH);

        //Left side of the walls:1
        new Wall(kw, 1, 1, Direction.WEST);
        new Wall(kw, 2, 1, Direction.WEST);
        new Wall(kw, 3, 1, Direction.WEST);

        //creating the bottom of the walls:1
        new Wall(kw, 3, 1, Direction.SOUTH);
        new Wall(kw, 3, 2, Direction.SOUTH);
        new Wall(kw, 3, 3, Direction.SOUTH);
        new Wall(kw, 3, 4, Direction.SOUTH);

        //right side of the walls:1
        new Wall(kw, 3, 4, Direction.EAST);
        new Wall(kw, 2, 4, Direction.EAST);
        new Wall(kw, 1, 4, Direction.EAST);

        while (karel.frontIsClear()) {
            karel.move();
        }
        //getting karel to move
        while (true) {
            //if front is clear karel moves the checks the right
            if (karel.frontIsClear()) {
                karel.move();
                karel.turnLeft();
                karel.turnLeft();
                karel.turnLeft();
            }
            //if front isn't clear then karel turns left
            if (!karel.frontIsClear()) {
                karel.turnLeft();
                //if karel faces a corner he turns left again to not face the wall
                if (!karel.frontIsClear()) {
                    karel.turnLeft();
                }
                //if karel is facing free space on all sides he stops, checks all sides
                //if free then karel moves once forward towards the exit (NORTH)
            } else {
                if (karel.frontIsClear() && karel.getDirection() == Direction.NORTH) {
                    karel.turnLeft();
                    if (karel.frontIsClear() && karel.getDirection() == Direction.WEST) {
                        karel.turnLeft();
                        if (karel.frontIsClear() && karel.getDirection() == Direction.SOUTH) {
                            karel.turnLeft();
                            if (karel.frontIsClear() && karel.getDirection() == Direction.EAST) {
                                karel.turnLeft();
                                karel.move();
                                break;

                            }
                        }
                    }
                }
                //if karel is facing free space on all sides he stops, checks all sides
                //if free then karel moves once forward towards the exit (WEST)
                if (karel.frontIsClear() && karel.getDirection() == Direction.WEST) {
                    karel.turnLeft();
                    if (karel.frontIsClear() && karel.getDirection() == Direction.SOUTH) {
                        karel.turnLeft();
                        if (karel.frontIsClear() && karel.getDirection() == Direction.EAST) {
                            karel.turnLeft();
                            if (karel.frontIsClear() && karel.getDirection() == Direction.NORTH) {
                                karel.turnLeft();
                                karel.move();
                                break;
                            }

                        }
                    }

                }
                //if karel is facing free space on all sides he stops, checks all sides
                //if free then karel moves once forward towards the exit (EAST)
                if (karel.frontIsClear() && karel.getDirection() == Direction.EAST) {
                    karel.turnLeft();
                    if (karel.frontIsClear() && karel.getDirection() == Direction.NORTH) {
                        karel.turnLeft();
                        if (karel.frontIsClear() && karel.getDirection() == Direction.WEST) {
                            karel.turnLeft();
                            if (karel.frontIsClear() && karel.getDirection() == Direction.SOUTH) {
                                karel.turnLeft();
                                karel.move();
                                break;
                            }

                        }
                    }
                }
                //if karel is facing free space on all sides he stops, checks all sides
                //if free then karel moves once forward towards the exit (SOUTH)
                if (karel.frontIsClear() && karel.getDirection() == Direction.SOUTH) {
                    karel.turnLeft();
                    if (karel.frontIsClear() && karel.getDirection() == Direction.EAST) {
                        karel.turnLeft();
                        if (karel.frontIsClear() && karel.getDirection() == Direction.NORTH) {
                            karel.turnLeft();
                            if (karel.frontIsClear() && karel.getDirection() == Direction.WEST) {
                                karel.turnLeft();
                                karel.move();
                                break;
                            }

                        }
                    }
                }
            }
        }
    }
}
