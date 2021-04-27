package algorithms.mazeGenerators;

import java.util.LinkedList;
import java.util.Random;

public class Test {

    public static void main(String[] args){
        MyMazeGenerator test = new MyMazeGenerator();
        Maze maze=test.generate(5,5);
        byte[] bytes= maze.toByteArray();
        System.out.println(bytes);
        Maze maze2= new Maze(bytes);
        System.out.println(maze2.rows);
        System.out.println(maze2.column);




        //byte[] bytes= [1,0,0,-1,1,0,0,-1,0,0,0,-1,0,0,0,-1,1,0,0,-1,1,1,0,-1,1,0,1,1,0,0,0,1,0];


    }
}
