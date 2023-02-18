import java.util.Arrays;
import java.util.Objects;

public class Spreadsheet {
    private  Cell[][] cells;
    private int row;
    private int column;
    private int[] columnLength;
    Spreadsheet (int row, int column) {
        cells = new Cell[row+1][column+1];
        this.row = row + 1;
        this.column = column + 1;
        cells[0][0] = new StringCell("");
        summaryOfCells();
        columnLength = new int[column+1];
    }
    @Override
    public boolean equals(Object o) {
        boolean bool = true;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spreadsheet that = (Spreadsheet) o;
        if (row == that.row && column == that.column) {
            for ( int i = 0; i < that.row; ++i ) {
                for ( int j = 0; j < that.column; ++j) {
                    if ( !this.cells[i][j].equals(that.cells[i][j]) ) {
                        bool = false;
                        break;
                    }
                }
                if (!bool){
                    break;
                }
            }
        }
        return bool;
    }
    public boolean isEmpty(){
        return row == 0 || column == 0;
    }
    @Override
    public int hashCode() {
        int result = Objects.hash(row, column);
        result = 31 * result + Arrays.deepHashCode(cells);
        return result;
    }

    private void outOfBounds (int row, int column){
        if (row < 0 ||  row >= this.row) {
            throw new ArrayIndexOutOfBoundsException(" row is lower than 0, or greater than cells rows!");
        }
        if (column < 0 || column >= this.column) {
            throw new ArrayIndexOutOfBoundsException(" columns is lower than 0, or greater than cells column!");
        }
    }
    public void setCellAt (int row, int column, Cell<?> cell) {
        outOfBounds(row + 1,column + 1);
        this.cells[row + 1][column+ 1]  = cell;
    }


    public Cell getCellAt (int row, int column) {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Spreadsheet is empty!");
        }
        outOfBounds(row + 1,column + 1);
        return cells[row + 1][column +1];
    }
    public void addRow (int row) {
        if (row + 1 < 0 || row + 1 > this.row) {
            throw new ArrayIndexOutOfBoundsException(" row is lower than 0, or greater than cells rows!");
        }
        Cell[][] tmpCells = new Cell[this.row + 1][column];
        for (int i = 0; i < this.row; ++i) {
            for (int j = 0; j < this.column; ++j) {
                if (i == row + 1) {
                    tmpCells[i][j] = null;
                } else if (i > row + 1) {
                    tmpCells[i+1][j] = cells[i][j];
                } else {
                    tmpCells[i][j] = cells[i][j];
                }
            }
            if (i != 0) {
                tmpCells[i][0] = new StringCell((i - 1) + "");
            }
        }
        ++this.row;
        this.cells = tmpCells;
        cells[this.row-1][0] = new StringCell((this.row-2)+"");
    }
    public void removeRow (int row) {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Spreadsheet is empty ");
        }
        if (row  + 1 < 0 || row + 1 >= this.row) {
            throw new ArrayIndexOutOfBoundsException(" row is lower than 0, or greater than cells rows!");
        }
        Cell[][] tmpCells = new Cell[this.row - 1][column];
        for (int i = 0; i < this.row-1; ++i) {
            if (i == row + 1) {
                continue;
            }
            for (int j = 0; j < column; ++j) {
                if (i > row + 1) {
                    tmpCells[i-1][j] = cells[i][j];
                } else {
                    tmpCells[i][j] = cells[i][j];
                }
            }
            if (i != 0) {
                if (i > row + 1 ) {
                    tmpCells[i - 1][0] = new StringCell((i - 2) + "");
                } else {
                    tmpCells[i][0] = new StringCell((i - 1) + "");
                }
            }
        }
        --this.row;
        cells = tmpCells;
        cells[this.row-1][0] = new StringCell((this.row-2)+"");
    }
    public void addColumn (int column) {
        if (column + 1 < 0 || column + 1 > this.column) {
            throw new ArrayIndexOutOfBoundsException(" colum is lower than 0, or greater than cells columns!");
        }
        Cell[][] tmpCells = new Cell[row][this.column + 1];
        for (int i = 0; i < this.column; ++i) {
            for (int j = 0; j < this.row; ++j) {
                if (i == column + 1) {
                    tmpCells[j][i] = null;
                } else if (i > column + 1) {
                    tmpCells[j][i + 1] = cells[j][i];
                } else {
                    tmpCells[j][i] = cells[j][i];
                }
            }
            if (i != 0) {
                tmpCells[0][i] = new StringCell(i - 1 + "");
            }
        }
        ++this.column;
        this.cells = tmpCells;
        cells[0][this.column - 1] = new StringCell((this.column - 2) + "");
        columnLength = new int[this.column];
    }
    public void removeColum (int column) {
        if (isEmpty()) {
            return;
        }
        if (column + 1 < 0 || column + 1 >= this.column) {
            throw new ArrayIndexOutOfBoundsException(" column is lower than 0, or greater than cells columns!");
        }
        Cell[][] tmpCells = new Cell[row][this.column-1];
        for (int i = 0; i < this.column; ++i) {
            for (int j = 0; j < row; ++j) {
                if (i == column + 1) {
                    continue;
                }
                if (i > column + 1) {
                    tmpCells[j][i-1] = cells[j][i];
                } else {
                    tmpCells[j][i] = cells[j][i];
                }
            }
            if (i != 0) {
                if (i > column + 1 ) {
                    tmpCells[0][i - 1] = new StringCell((i - 2) + "");
                } else {
                    tmpCells[0][i] = new StringCell((i - 1) + "");
                }
            }
        }
        --this.column;
        cells = tmpCells;
        cells[0][this.column - 1] = new StringCell((this.column - 2) + "");
        columnLength = new int[this.column];
    }
    public void swapRows (int row1, int row2) {
        if (row1 + 1 < 0 || row2 + 1 < 0) {
            throw new ArrayIndexOutOfBoundsException(" row1 or row2 are lower than 0!");
        }
        if (row1 + 1 >= this.row || row2 + 1 >= this.row) {
            throw new ArrayIndexOutOfBoundsException(" row1 or row2 are greater than cells rows!");
        }
        for (int i = 1; i < this.column; ++i) {
            Cell tmp = cells[row1 + 1][i];
            cells[row1 + 1][i] = cells[row2 + 1][i];
            cells[row2 + 1][i] = tmp;
        }
    }
    public void swapColumn (int column1, int column2) {
        if (column1 + 1 < 0 || column2 + 1 < 0) {
            throw new ArrayIndexOutOfBoundsException(" colum1 or colum2 are lower than 0!");
        }
        if (column1 + 1 >= this.column || column2 + 1 >= this.column) {
            throw new ArrayIndexOutOfBoundsException(" colum1 or colum2 are greater than cells column!");
        }
        for (int i = 1; i < this.row; ++i) {
            Cell tmp = cells[i][column1 + 1];
            cells[i][column1 + 1] = cells[i][column2 + 1];
            cells[i][column2 + 1] = tmp;
        }
    }
    private void summaryOfCells() {
        for (int i = 1; i < this.row; ++i) {
            cells[i][0] = new StringCell(i-1 + "");
        }
        for (int j = 1; j < this.column; ++j) {
            cells[0][j] = new StringCell(j-1 + "");
        }
    }
    private void toCountColumnLength() {
        int max = 0;
        for (int i = 0; i < this.column; ++i) {
            for (int j = 0; j < this.row; ++j) {
                if (cells[j][i] == null) {
                    max = 4;
                } else if(max < cells[j][i].toString().length()) {
                    max = cells[i][j].toString().length();
                }
            }
            columnLength[i] = max+1;
        }
    }
    public void print() {
        toCountColumnLength();
        System.out.print(cells[0][0]);
        System.out.print(" ");
        for (int i = 0; i < column; ++i) {
            System.out.print(cells[0][i]);
            for (int j = 0; j < columnLength[i]; ++j) {
                System.out.print(" ");
            }
        }
        System.out.println();
        int spaceCount;
        for (int i = 1; i < this.row; ++i) {
            for (int j = 0; j < this.column; ++j) {
                spaceCount = columnLength[j];
                System.out.print(cells[i][j]);
                    if (cells[i][j] == null) {
                        spaceCount -= 4;
                    } else {
                        spaceCount -= cells[i][j].toString().length();
                    }
                    for (int space = 0; space < spaceCount; ++space) {
                        System.out.print(" ");
                    }
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}