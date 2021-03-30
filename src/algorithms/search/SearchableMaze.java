package algorithms.search;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SearchableMaze implements ISearchable {
    private Maze maze;
    private LinkedList<MazeState> m_states;

    public SearchableMaze(Maze maze){
        this.maze = maze;
    }

    public AState getStart(){
        Position startPosition = maze.getStartPosition();
        return (new MazeState(startPosition.getRowIndex(),startPosition.getColumnIndex()));
    }

    @Override
    public AState getEnd() {
        Position endPosition = maze.getGoalPosition();
        return (new MazeState(endPosition.getRowIndex(),endPosition.getColumnIndex()));
    }

    boolean IsValid(AState current){
        switch (possition)
        if (current.getColumn()<maze.getColumn() && current.getRow()>=1)
            return
    }

    public List<AState> getAllPossibleStates(AState curr_state){
        List<AState> Possible_states = new ArrayList<>();

        //Map all the positions around the current state


        //Not diagonals

    if (Non_Diagonal_Verification("goDown",curr_state)){
        Position goDown = new Position(curr_state.getRow() + 1, curr_state.getColumn());
        Possible_states.add(new MazeState(goDown.getRowIndex(),goDown.getColumnIndex()));
    }
        if (Non_Diagonal_Verification("goUp",curr_state)) {
        Position goUp = new Position(curr_state.getRow() -1, curr_state.getColumn());
        Possible_states.add(new MazeState(goUp.getRowIndex(),goUp.getColumnIndex()));
    }
        if (Non_Diagonal_Verification("goLeft",curr_state)){
        Position goLeft = new Position(curr_state.getRow(), curr_state.getColumn() -1);
        Possible_states.add(new MazeState(goLeft.getRowIndex(),goLeft.getColumnIndex()));
    }
        if (Non_Diagonal_Verification("goRight",curr_state)){
        Position goRight = new Position(curr_state.getRow(), curr_state.getColumn() + 1);
        Possible_states.add(new MazeState(goRight.getRowIndex(),goRight.getColumnIndex()));
    }
        //Diagonals
        //UpRight
        AState next;
        if (Diagonal_Verification("UpRight",curr_state,next)){
            if (curr_state.getColumn() < maze.getColumn() && this.maze.getMaze()[curr_state.getRow() - 1][curr_state.getColumn() + 1] == 0){
                Position goUpRight = new Position(curr_state.getRow() - 1, curr_state.getColumn() + 1);
                Possible_states.add(new MazeState(goUpRight.getRowIndex(),goUpRight.getColumnIndex()));
            }

            //UpLeft
            if (Diagonal_Verification("UpRight",curr_state,next)){
            if (curr_state.getColumn() >= 1 && this.maze.getMaze()[curr_state.getRow() - 1][curr_state.getColumn() - 1] == 0){
                Position goUpLeft = new Position(curr_state.getRow() - 1 , curr_state.getColumn() -1 );
                Possible_states.add(new MazeState(goUpLeft.getRowIndex(),goUpLeft.getColumnIndex()));
            }

        }
        if (curr_state.getRow() < maze.getRows() - 1 ) {
            if (curr_state.getColumn() < maze.getColumn() - 1 && this.maze.getMaze()[curr_state.getRow() + 1][curr_state.getColumn() + 1] == 0){
                Position goDownRight = new Position(curr_state.getRow() + 1, curr_state.getColumn() + 1);
                Possible_states.add(new MazeState(goDownRight.getRowIndex(),goDownRight.getColumnIndex()));
            }
            if (curr_state.getColumn() >= 1 && this.maze.getMaze()[curr_state.getRow() + 1][curr_state.getColumn() - 1] == 0){
                Position goDownLeft = new Position(curr_state.getRow() + 1, curr_state.getColumn() -1);
                Possible_states.add(new MazeState(goDownLeft.getRowIndex(),goDownLeft.getColumnIndex()));
            }
        }

    return Possible_states;
}

    public boolean Diagonal_Verification(String str,AState curr_state,AState next_curr_state){
        return switch (str) {
            case "UpRight" -> (curr_state.getRow() >= 1 && curr_state.getColumn() < maze.getColumn() && this.maze.getMaze()[curr_state.getRow() - 1][curr_state.getColumn() + 1] == 0);
            case "UpLeft" -> (curr_state.getRow() >= 1 && this.maze.getMaze()[curr_state.getRow() - 1][curr_state.getColumn() - 1] == 0);
            case "goLeft" -> (curr_state.getColumn() >= 1 && this.maze.getMaze()[curr_state.getRow()][curr_state.getColumn() - 1] == 0);
            case "goRight" -> (curr_state.getColumn() < maze.getColumn() - 1 && this.maze.getMaze()[curr_state.getRow()][curr_state.getColumn() + 1] == 0);
            default -> false;
        };


    }

    public boolean Non_Diagonal_Verification(String str,AState curr_state){
        return switch (str) {
            case "goUp" -> (curr_state.getRow() >= 1 && this.maze.getMaze()[curr_state.getRow() - 1][curr_state.getColumn()] == 0);
            case "goDown" -> (curr_state.getRow() < maze.getRows() - 1 && this.maze.getMaze()[curr_state.getRow() + 1][curr_state.getColumn()] == 0);
            case "goLeft" -> (curr_state.getColumn() >= 1 && this.maze.getMaze()[curr_state.getRow()][curr_state.getColumn() - 1] == 0);
            case "goRight" -> (curr_state.getColumn() < maze.getColumn() - 1 && this.maze.getMaze()[curr_state.getRow()][curr_state.getColumn() + 1] == 0);
            default -> false;
        };
    }

}
