package algorithms.mazeGenerators;

import algorithms.search.AState;
import algorithms.search.MazeState;
import algorithms.search.Solution;

import java.util.Arrays;
import java.util.List;

public class Maze {
<<<<<<< HEAD
    int [][] maze;
    int rows_mazeSize;
    int column_mazeSize;
=======
    int[][] maze;
    int rows;
    int column;
>>>>>>> 35121aaf01746b6771859394f06a6fcfc93ac4b4
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
<<<<<<< HEAD
    public String toString(){

=======

    public String toString(List<MazeState> list) {
        final char PASSAGE_CHAR = '*';
        final char WALL_CHAR = 'X';
        final char MARKED_CHAR = 'S';
        boolean[][] markedMaze;
        markedMaze = new boolean[this.getRows()][this.getColumn()];
        for (int i = 0; i < list.size(); i++) {
            int col = list.get(i).getColumn();
            int row = list.get(i).getRow();
            markedMaze[row][col] = true;
        }
        final StringBuffer b = new StringBuffer();
//        for ( int x = 0; x < column + 2; x++ )
//            b.append( WALL_CHAR );
//        b.append( '\n' );
        for (int x = 0; x < rows; x++) {
//            b.append( WALL_CHAR );
            for (int y = 0; y < column; y++)
                if (markedMaze[x][y] == true) {
                    b.append(MARKED_CHAR);
                } else {
                    b.append(maze[x][y] == 1 ? WALL_CHAR : PASSAGE_CHAR);
                }
//            b.append( WALL_CHAR );
            b.append('\n');
        }
//        for ( int x = 0; x < column + 2; x++ )
//            b.append( WALL_CHAR );
        b.append('\n');
        return b.toString();
    }

    public String toString() {
>>>>>>> 35121aaf01746b6771859394f06a6fcfc93ac4b4
        final char PASSAGE_CHAR = '*';
        final char WALL_CHAR = 'X';

        final StringBuffer b = new StringBuffer();
//        for ( int x = 0; x < column + 2; x++ )
//            b.append( WALL_CHAR );
//        b.append( '\n' );
<<<<<<< HEAD
        for ( int x = 0; x < rows_mazeSize; x++ ){
//            b.append( WALL_CHAR );
            for ( int y = 0; y < column_mazeSize; y++ )
                b.append( maze[x][y] == 1 ? WALL_CHAR : PASSAGE_CHAR );
=======
        for (int x = 0; x < rows; x++) {
//            b.append( WALL_CHAR );
            for (int y = 0; y < column; y++)
                b.append(maze[x][y] == 1 ? WALL_CHAR : PASSAGE_CHAR);
>>>>>>> 35121aaf01746b6771859394f06a6fcfc93ac4b4
//            b.append( WALL_CHAR );
            b.append('\n');
        }
//        for ( int x = 0; x < column + 2; x++ )
//            b.append( WALL_CHAR );
        b.append('\n');
        return b.toString();
    }


    public Maze(int rows, int column) {
<<<<<<< HEAD
        this.rows_mazeSize = rows;
        this.column_mazeSize = column;
        this.end_position = new Position(0,0);
        maze = new int[rows][column];
        int i,j;
        for  (i=0;i<this.column_mazeSize;i++){
            for (j=0;j<this.rows_mazeSize;j++){
                maze[j][i]=1;
=======
        this.rows = rows;
        this.column = column;
        this.end_position = new Position(0, 0);
        maze = new int[rows][column];
        int i, j;
        for (i = 0; i < this.column; i++) {
            for (j = 0; j < this.rows; j++) {
                maze[j][i] = 1;
>>>>>>> 35121aaf01746b6771859394f06a6fcfc93ac4b4
            }
        }
    }

    public void print() {
        System.out.println(this);
    }

    public void setStartPosition(int row, int column) {
        start_position = new Position(row, column);
    }

    public void setEndPosition(int row, int column) {
        end_position = new Position(row, column);
    }

    public Position getEndPosition() {
        return end_position;
    }


    public Position getStartPosition() {
        return start_position;
    }
}


