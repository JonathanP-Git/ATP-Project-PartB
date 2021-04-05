package algorithms.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Solution {
    private final ArrayList<AState> path;

    public Solution() {
        this.path = new ArrayList<AState>();
    }
    public boolean contains(AState temp){
        return path.contains(temp);
    }
    public void add(AState tmp) {
        path.add(tmp);
    }

    @Override
    public String toString() {
        return "Solution{" +
                "path=" + path +
                '}';
    }

    public ArrayList<AState> getSolutionPath()
    {
        Collections.reverse(path);
        return path;
    }
}
