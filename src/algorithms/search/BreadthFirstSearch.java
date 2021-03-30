package algorithms.search;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm{

    int numOfNodesEvaluated;

    @Override
    public String getName() {
        return "Breadth First Search";
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return this.numOfNodesEvaluated;
    }

    @Override
<<<<<<< HEAD
    public Solution solve(ISearchable specificPuzzle) {
        AState startState = specificPuzzle.getStart();
        Queue<AState> queue = new LinkedList<>();
        HashSet<AState> visited = new HashSet<>();
        queue.add(startState);
        while(!queue.isEmpty()){
            if ((queue.peek().equals(specificPuzzle.getEnd().getRow(),specificPuzzle.getEnd().getColumn()))){break;}
            AState tmp = queue.poll();
            if(!visited.contains(tmp)){
                visited.add(tmp);
                List<AState> possibleStates = specificPuzzle.getAllPossibleStates(tmp);
                for(AState adjacent: possibleStates){
                    adjacent.setParent(tmp);
                    queue.add(adjacent);}
            }
        }
        if (queue.peek() != null && queue.peek().equals(specificPuzzle.getEnd().getRow(),specificPuzzle.getEnd().getColumn())){
            return getSolution(queue.poll());
        }
        return null;
    }
=======
    public Solution solve(ISearchable specificPuzzle) { //Wrapper function
            Queue<AState> queue = new LinkedList<>();
            return solve(specificPuzzle, queue, "BFS");}

    public Solution solve(ISearchable specificPuzzle,Queue<AState> queue, String searchingAlgorithm) {
            AState startState = specificPuzzle.getStart();
            HashSet<AState> visited = new HashSet<>();
            queue.add(startState);
            while(!queue.isEmpty()){
                if ((queue.peek().equals(specificPuzzle.getEnd()))){break;}
                AState tmp = queue.poll();
                if(!visited.contains(tmp)){
                    visited.add(tmp);
                    List<AState> possibleStates = specificPuzzle.getAllPossibleStates(tmp,searchingAlgorithm);
                    for(AState adjacent: possibleStates){
                        adjacent.setParent(tmp);
                        queue.add(adjacent);}
                }
            }
        if (queue.peek() != null && queue.peek().equals(specificPuzzle.getEnd())){
                return getSolution(queue.poll());
            }
        System.out.println("ERROR!!!");
        return null;
        }
>>>>>>> 35121aaf01746b6771859394f06a6fcfc93ac4b4
    private Solution getSolution(AState tmp) {
        Solution solution = new Solution();
        solution.add(tmp);
        this.numOfNodesEvaluated++;
        while (tmp.getParent() != null){
            solution.add(tmp.getParent());
            this.numOfNodesEvaluated++;
            tmp = tmp.getParent();
        }
        return solution;
    }
}
