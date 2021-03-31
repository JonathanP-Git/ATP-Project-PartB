package test;
import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.search.*;
import java.util.ArrayList;

public class RunSearchOnMaze {
    public static void main(String[] args) {
        IMazeGenerator mg = new MyMazeGenerator();
<<<<<<< HEAD
        Maze maze = mg.generate(5, 8);
=======
        Maze maze = mg.generate(1000, 1000);
>>>>>>> origin
        maze.print();
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        solveProblem(searchableMaze, new BreadthFirstSearch());
        solveProblem(searchableMaze, new DepthFirstSearch());
        solveProblem(searchableMaze, new BestFirstSearch());
    }
    private static void solveProblem(ISearchable domain, ISearchingAlgorithm searcher) {
        //Solve a searching problem with a searcher
        Solution solution = searcher.solve(domain);
        System.out.println(String.format("'%s' algorithm - nodes evaluated: %s", searcher.getName(), searcher.getNumberOfNodesEvaluated()));
        //Printing Solution Path
<<<<<<< HEAD
        System.out.println("Solution path:");
        if (solution.getSolutionPath()==null){
            System.out.println("there is no solution to the maze-->we should fix this");

        }
        else{
=======
                System.out.println("Solution path:");
        if (solution.getSolutionPath()==null){ System.out.println("there is no solution to the maze-->we should fix this"); }
>>>>>>> e54f3e6076f8c6f4d497a3a7cdc27e4b7f3ef7d2
        ArrayList<AState> solutionPath = solution.getSolutionPath();
<<<<<<< HEAD
        for (int i = 0; i < solutionPath.size(); i++) {
            System.out.println(String.format("%s. %s",i,solutionPath.get(i)));
        }}
=======
//        for (int i = 0; i < solutionPath.size(); i++) {
//            System.out.println(String.format("%s. %s",i,solutionPath.get(i)));
//        }
>>>>>>> origin
    }
}