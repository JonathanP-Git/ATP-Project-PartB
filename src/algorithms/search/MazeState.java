package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.Objects;

public class MazeState extends AState{
    private final Position current_position;

<<<<<<< HEAD
=======
    public int getRow() {
        return current_position.getRowIndex();
    }

    public int getColumn() {
        return current_position.getColumnIndex();
    }

    public MazeState(int row, int column, int cost){
        super();
        this.current_position = new Position(row,column);
        this.cost = cost;
    }
>>>>>>> 35121aaf01746b6771859394f06a6fcfc93ac4b4

    public MazeState(int row, int column){
        super();
        this.current_position = new Position(row,column);
<<<<<<< HEAD

=======
>>>>>>> 35121aaf01746b6771859394f06a6fcfc93ac4b4
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MazeState mazeState = (MazeState) o;
        return Objects.equals(current_position, mazeState.current_position);
    }

    @Override
    public String toString() {
        return "MazeState{" +
                current_position +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(current_position);
    }

    @Override
    public void setParent(AState father) {
        this.parent = father;}


<<<<<<< HEAD
=======
    public AState getParent() {
        return parent;
    }
>>>>>>> 35121aaf01746b6771859394f06a6fcfc93ac4b4

    @Override
    public void setParentNull() {
        this.parent = null;
    }

}
