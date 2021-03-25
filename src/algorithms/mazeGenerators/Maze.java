package algorithms.mazeGenerators;

import java.util.Arrays;

public class Maze {
    int [][] maze;
    int rows;
    int column;
    Position end_position;

    public int getRows() {
        return rows;
    }

    public int getColumn() {
        return column;
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
<<<<<<< HEAD
        final char PASSAGE_CHAR = 'X';
        final char WALL_CHAR = '*';
=======
        final char PASSAGE_CHAR = '*';
        final char WALL_CHAR = 'X';
<<<<<<< HEAD
        final char SemiWall = '*';
>>>>>>> 7cf5498ce53162c0cb1e9cfc2b46b3f3ef2e99ff
=======
>>>>>>> origin
        final StringBuffer b = new StringBuffer();
//        for ( int x = 0; x < column + 2; x++ )
//            b.append( WALL_CHAR );
//        b.append( '\n' );
        for ( int x = 0; x < rows; x++ ){
//            b.append( WALL_CHAR );
            for ( int y = 0; y < column; y++ )
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
        this.rows = rows;
        this.column = column;
        this.end_position = new Position(0,0);
        maze = new int[rows][column];
        int i,j;
        for  (i=0;i<this.column;i++){
            for (j=0;j<this.rows;j++){
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

    public Object getGoalPosition() {
        return end_position;
    }
}
