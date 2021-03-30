package algorithms.search;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return 0;
    }

    @Override
    public Solution solve(ISearchable specificPuzzle) {
        AState startState = specificPuzzle.getStart();
        Queue<AState> queue = new LinkedList<>();
        HashMap<AState,AState> visited = new HashMap<>();
        queue.add(startState);
        AState current = startState;
        while (current != specificPuzzle.getEnd()) {
            List<AState> adj = specificPuzzle.getAllPossibleStates(current);
            for (AState n : adj) {

                if (!visited.containsKey(n)) {
                    visited.put(n,current);
                    queue.add(n);

                }
            }
            current = queue.remove();
        }
        LinkedList<AState>path= new LinkedList<>() ;
        path.add(1,current);
        while(current!=startState){
            current=visited.get(current);
            path.add(1,current);
        }



        return getSolution(current);


    }


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
