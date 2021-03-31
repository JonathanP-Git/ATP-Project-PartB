package algorithms.search;
import java.util.Comparator;
import java.util.Objects;

public abstract class AState {
    AState parent;
    int cost;
    int sumCost;

    public void setSumCost(int sumCost) {
        this.sumCost = sumCost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getSumCost() {
        return sumCost;
    }

    public int getCost() {
        return cost;
    }
    public AState() {
        this.cost = 0;
    }

    public AState(AState parent,int cost) {
        this.cost = cost;
        this.parent=parent;

    }

    public abstract void setParent(AState parent);
    public abstract AState getParent();
    public abstract void setParentNull();

}
