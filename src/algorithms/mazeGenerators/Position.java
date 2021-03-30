package algorithms.mazeGenerators;

import java.util.Objects;

public class Position {
    int row;
    int column;

    public int getRowIndex() {
        return row;
    }
    public int getColumnIndex() {
        return column;
    }

    @Override
    public String toString() {
        return "{"+row+","+column+"}";
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row &&
                column == position.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    public Position(int row , int column){
        this.row = row;
        this.column = column;
    }
}


