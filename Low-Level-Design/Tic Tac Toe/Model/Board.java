package Model;

public class Board {
    private char[][] grid;
    private int size;

    public Board(int size) {
        this.size = size;
        grid = new char[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                grid[i][j] = '-';
    }

    public boolean placeSymbol(int row, int col, char symbol) {
        if (grid[row][col] == '-') {
            grid[row][col] = symbol;
            return true;
        }
        return false;
    }

    public void display() {
        for (char[] row : grid) {
            for (char cell : row)
                System.out.print(cell + " ");
            System.out.println();
        }
    }

    public boolean isFull() {
        for (char[] row : grid)
            for (char cell : row)
                if (cell == '-') return false;
        return true;
    }

    public boolean checkWin(int row, int col, char symbol) {
        boolean winRow = true, winCol = true, winDiag = true, winAntiDiag = true;
        for (int i = 0; i < size; i++) {
            if (grid[row][i] != symbol) winRow = false;
            if (grid[i][col] != symbol) winCol = false;
            if (grid[i][i] != symbol) winDiag = false;
            if (grid[i][size - 1 - i] != symbol) winAntiDiag = false;
        }
        return winRow || winCol || winDiag || winAntiDiag;
    }
}
