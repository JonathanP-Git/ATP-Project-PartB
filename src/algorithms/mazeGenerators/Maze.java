package algorithms.mazeGenerators;

import java.util.Arrays;

public class Maze {
    int [][] maze;
    int rows_mazeSize;
    int column_mazeSize;
    Position end_position;
    Position start_position;

    public int getRows() {
        return rows_mazeSize;
    }

    public int getColumn() {
        return column_mazeSize;
    }

    public int[][] getMaze() {
        return maze;
    }

    //    public String toString(){
//        StringBuilder sb = new StringBuilder();
//        for(int x=0; x< column ; x++){
//            for(int y=0; y<rows; y++)
//                sb.append(maze[x][y]);
//            sb.append("\n");
//        }
//        return sb.toString();}
    public String toString(){

        final char PASSAGE_CHAR = '*';
        final char WALL_CHAR = 'X';

        final StringBuffer b = new StringBuffer();
//        for ( int x = 0; x < column + 2; x++ )
//            b.append( WALL_CHAR );
//        b.append( '\n' );
        for ( int x = 0; x < rows_mazeSize; x++ ){
//            b.append( WALL_CHAR );
            for ( int y = 0; y < column_mazeSize; y++ )
                b.append( maze[x][y] == 1 ? WALL_CHAR : PASSAGE_CHAR );
//            b.append( WALL_CHAR );
            b.append( '\n' );
        }
//        for ( int x = 0; x < column + 2; x++ )
//            b.append( WALL_CHAR );
        b.append( '\n' );
        return b.toString();
    }


    public Maze(int rows, int column) {
        this.rows_mazeSize = rows;
        this.column_mazeSize = column;
        this.end_position = new Position(0,0);
        maze = new int[rows][column];
        int i,j;
        for  (i=0;i<this.column_mazeSize;i++){
            for (j=0;j<this.rows_mazeSize;j++){
                maze[j][i]=1;
            }
}
    }

    public void print() {
        System.out.println(this);
    }

    public Position getStartPosition() {
        return new Position(0,1);
    }

    public Position getGoalPosition() {
        return end_position;
    }
}
