package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState{
    private final Position current_position;


    public MazeState(int row, int column){
        super();
        this.current_position = new Position(row,column);

    }

    @Override
    public void setParent(AState father) {
        if (father instanceof MazeState){
        this.parent = (MazeState)father;}
    }




    @Override
    public void setParentNull() {
        this.parent = null;
    }

}
