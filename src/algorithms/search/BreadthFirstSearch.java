package algorithms.search;

import java.util.*;

/**
 * Classic BFS searching algorithm.
 */
public class BreadthFirstSearch extends ASearchingAlgorithm{

    int numOfNodesEvaluated;
    int sum;
    int sumCost;

    @Override
    /**
     * @return name of the algorithm - "BreadthFirstSearch".
     */
    public String getName() {
        return "BreadthFirstSearch";
    }

    @Override
    /**
     * @return number of nodes evaluated.
     */
    public int getNumberOfNodesEvaluated() {
        return this.numOfNodesEvaluated;
    }

    @Override
<<<<<<< HEAD
    public Solution solve(ISearchable specificPuzzle) { //Wrapper function

=======
    /**
     * Wrapper function in order to distinguish which
     * variation of the algorithm we are interested in using
     */
    public Solution solve(ISearchable specificPuzzle) {
>>>>>>> a4eb82fb51a9682b49977a06283e8b3eeebbe87d
            Queue<AState> queue = new LinkedList<>();
            return solve(specificPuzzle, queue);}

    /**
     * A searching algorithm, at each step horizontally checks all its optional neighbors for progress.
     * @param specificPuzzle- the structure on which the search is performed
     * @param queue - all possible states for progress
     * @return  the shortest path to solve the problem
     */
    public Solution solve(ISearchable specificPuzzle,Queue<AState> queue) {
            sumCost = 0;
            if (specificPuzzle==null) throw new RuntimeException("The specific puzzle recited is null");
            AState startState = specificPuzzle.getStart();
            HashSet<AState> visited = new HashSet<>();
            queue.add(startState);
            while(!queue.isEmpty()){ //While the queue isn't empty
                if ((queue.peek().equals(specificPuzzle.getEnd()))){break;}
                AState tmp = queue.poll();
                if(!visited.contains(tmp)){
                    visited.add(tmp); //add the current state to visited.
                    sumCost += tmp.getCost();
                    List<AState> possibleStates = specificPuzzle.getAllSuccessors(tmp); //Get all possible moves from the current state.
                    if (possibleStates.size() == 0){
                        sumCost -= tmp.getAccumulatedCost();
                        tmp.setParentNull();
                        continue;}
                    for(AState adjacent: possibleStates){ //adding all possible moves to queue
                        adjacent.setParent(tmp);
                        adjacent.setAccumulatedCost(sumCost + adjacent.getCost());
                        queue.add(adjacent);}

            }
        }
        if (queue.peek() != null && queue.peek().equals(specificPuzzle.getEnd())){
<<<<<<< HEAD
            return getSolution(queue.poll());
        }
        System.out.println("ERROR!!!");
        return null;
    }

    private Solution getSolution(AState tmp) {
=======
                return getSolution(queue.poll());
            }
        return null;
        }
    /**
     * return the Solution path - For the BestFS AND BFS
     */
    public Solution getSolution(AState tmp) {
>>>>>>> a4eb82fb51a9682b49977a06283e8b3eeebbe87d
        int sum = 0;
        Solution solution = new Solution();
        solution.add(tmp);
        this.numOfNodesEvaluated++;
        sum += tmp.getCost();
        while (tmp.getParent() != null){
            solution.add(tmp.getParent());
            sum += tmp.getParent().getCost();
            this.numOfNodesEvaluated++;
            tmp = tmp.getParent();
        }
        return solution;
    }
}
