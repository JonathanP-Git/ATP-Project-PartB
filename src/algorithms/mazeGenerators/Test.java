package algorithms.mazeGenerators;

import java.util.LinkedList;
import java.util.Random;

public class Test {
    public static void main(String[] args){
        MyMazeGenerator test = new MyMazeGenerator();

        test.generate(5,5);
        Maze temp = test.generate(50,50);
        System.out.println(temp);

    }
}
