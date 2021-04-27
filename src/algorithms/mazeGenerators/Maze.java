package algorithms.mazeGenerators;

import java.util.ArrayList;

/**
 * Maze class contains 5 fields - maze, row, column, end_position and start_position .
 */
public class Maze {
    int[][] maze;
    int rows;
    int column;
    Position end_position;
    Position start_position;

    /**
     * @return the maze's row amount.
     */
    public int getRows() {
        return rows;
    }

    /**
     * @return the maze's column amount.
     */
    public int getColumn() {
        return column;
    }

    /**
     * @return the maze's maze field.
     */
    public int[][] getMaze() {
        return maze;
    }

    /**
     * display the maze as a string based on the values ​​in it.
     * we will run on the maze cells. Cells with a value of 1 will be defined as walls and mark with char 1, otherwise they will mark as passage with char 0
     * start position and end position would mark as S and E respectively
     */
    public String toString() {
        //
        final char PASSAGE_CHAR = '0';
        final char WALL_CHAR = '1';
        final char START_CHAR = 'S';
        final char END_CHAR = 'E';
        final StringBuffer b = new StringBuffer();

        for (int x = 0; x < rows; x++) {
            b.append("{ ");
            for (int y = 0; y < column; y++) {

                if (x == start_position.row && y == start_position.column) {
                    b.append(START_CHAR);
                    b.append(' ');
                }
                //checking if it's a goal position
                else if (x == end_position.row && y == end_position.column) {
                    b.append(END_CHAR);
                    b.append(' ');
                }
                //checking if it's a wall or passage
                else {
                    b.append(maze[x][y] == 1 ? WALL_CHAR : PASSAGE_CHAR);
                    b.append(' ');
                }
            }
            b.append("}");
            b.append('\n');
        }
            b.append('\n');
            return b.toString();
        }

    /**
     * constructor - build new maze from a given size
     * initializing the maze fields as full of 1's.
     * @param rows
     * @param column
     */
    public Maze(int rows, int column) {
        //constructor - build the maze with walls only, start and goal positions
        this.rows = rows;
        this.column = column;
        this.start_position = new Position(rows-1,column -1);
        this.end_position = new Position(0, 0);
        maze = new int[rows][column];
        int i, j;
        for (i = 0; i < this.column; i++) {
            for (j = 0; j < this.rows; j++) {
                maze[j][i] = 1;
            }
        }
    }

    public void print() {
        System.out.println(this);
    }

    /**
     * Make a new Position instance and make it as the startPosition field.
     * @param row - Start position row.
     * @param column - Start position column.
     */
    public void setStartPosition(int row, int column) {
        start_position = new Position(row, column);
    }

    /**
     * Make a new Position instance and make it as the endPosition field.
     * @param row - Start position row.
     * @param column - Start position column.
     */
    public void setEndPosition(int row, int column) {
        end_position = new Position(row, column);
    }

    /**
     * @return the maze's end Position .
     */
    public Position getGoalPosition() {
        return end_position;

    }


    public Maze(byte[] bytes) {
        int [] fieldsValue= new int[5];
        String temp="";
        int currField=0;
        for (int i=0; i<bytes.length; i++){
            if (currField==6){
                break;
            }
            else {
                while (bytes[i] != -1) {
                    temp += (char) bytes[i];
                }
                i++; // "jump over" -1 value and continue to the next field
                fieldsValue[currField] = Integer.parseInt(temp, 2); //convert binary string to a decimal int value
                currField++; //continue to the next field
                temp = ""; //init temp
            }
        }
        this.rows=fieldsValue[0];
        this.column=fieldsValue[1];
        setStartPosition(fieldsValue[2],fieldsValue[3]);
        setEndPosition(fieldsValue[4],fieldsValue[5]);

    }

    public byte[] toByteArray(){
        ArrayList<String> stringList = new ArrayList<>();
        int sumOfExtracted = extracted(stringList);
        int index = 0;
        byte[] bytes = new byte[rows*column + sumOfExtracted];

        for (String s : stringList) {
            index += addMazeVariables(s, index, bytes);
        }
        matrixToByte(index, bytes);
        return bytes;
    }

    private void matrixToByte(int index, byte[] bytes) {
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < column - 1; j++) {
                bytes[index] = (byte) maze[i][j];
                index++;
            }
            bytes[index] = -1;
            index++;
        }
    }

    private int extracted(ArrayList<String> stringList) {
        stringList.add(Integer.toBinaryString(rows));
        stringList.add(Integer.toBinaryString(column));
        stringList.add(Integer.toBinaryString(start_position.getRowIndex()));
        stringList.add(Integer.toBinaryString(start_position.getColumnIndex()));
        stringList.add(Integer.toBinaryString(end_position.getRowIndex()));
        stringList.add(Integer.toBinaryString(end_position.getColumnIndex()));
        return stringList.size();
    }

    private int addMazeVariables(String stringInBinary, int index, byte[] bytes) {
        for (int i = 0; i < stringInBinary.length(); i++) {
            bytes[i]= (byte) Character.getNumericValue(stringInBinary.charAt(i));
            index++;
        }
        bytes[index+1] = -1;
        index ++;
        return index;
    }

    /**
     * @return the maze's start Position.
     */
    public Position getStartPosition() {
        return start_position;

    }

    public byte[] toByteArray(){
        String rowsInBinary = Integer.toBinaryString(rows);
        String columnsInBinary = Integer.toBinaryString(column);
        String startPositionRow = Integer.toBinaryString(start_position.getRowIndex());
        String startPositionColumn = Integer.toBinaryString(start_position.getColumnIndex());
        String endPositionRow = Integer.toBinaryString(end_position.getRowIndex());
        String endPositionColumn = Integer.toBinaryString(end_position.getColumnIndex());


        byte[] bytes = new byte[rows*column+6];



        for (int i = 0; i < rowsInBinary.length(); i++) {
            bytes[i]=(byte)(rowsInBinary.charAt(i));

        }
//        int[][] maze;
//        int rows;
//        int column;
//        Position end_position;
//        Position start_position;


        return bytes;
    }


}

