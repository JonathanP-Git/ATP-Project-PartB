package algorithms.search;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm{

    int numOfNodesEvaluated;
    int sum;

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
                    if (possibleStates.size() == 0){
                        tmp.setParentNull();
                        continue;}
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
<<<<<<< HEAD
>>>>>>> 35121aaf01746b6771859394f06a6fcfc93ac4b4
=======

>>>>>>> origin
    private Solution getSolution(AState tmp) {
        int sum = 0;
        Solution solution = new Solution();
        solution.add(tmp);
        sum += tmp.getCost();
        this.numOfNodesEvaluated++;
        while (tmp.getParent() != null){
            sum += tmp.getCost();
            solution.add(tmp.getParent());
            this.numOfNodesEvaluated++;
            tmp = tmp.getParent();
        }
        System.out.println(sum);
        return solution;
    }
}
