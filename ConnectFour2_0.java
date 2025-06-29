public class ConnectFour2_0 { //VERSION OPTIMIZADA
    private char[][] grid;
    private char currentSymbol;
    private int lastCol = -1;
    private int lastRow = -1;

    public ConnectFour2_0() {
        grid = new char[7][6];
        for (int columna = 0; columna < 7; columna++) {
            for (int fila = 0; fila < 6; fila++) {
                grid[columna][fila] = ' ';
            }
        }
        currentSymbol = 'X';
    }

    public boolean makeMove(int columna) {
        if (columna < 0 || columna >= 7)
            return false;

        for (int fila = 5; fila >= 0; fila--) {
            if (grid[columna][fila] == ' ') {
                grid[columna][fila] = currentSymbol;
                lastCol = columna;
                lastRow = fila;
                currentSymbol = (currentSymbol == 'X') ? 'O' : 'X';
                return true;
            }
        }
        return false;
    }

    public char isGameOver() {
        if (lastCol == -1 || lastRow == -1) {
            return ' ';
        }

        char symbol = grid[lastCol][lastRow];
        if (symbol == ' ') {
            return ' ';
        }

        if (checkLine(symbol, lastCol, lastRow, 1, 0) ||  
            checkLine(symbol, lastCol, lastRow, 0, 1) ||  
            checkLine(symbol, lastCol, lastRow, 1, 1) ||  
            checkLine(symbol, lastCol, lastRow, 1, -1)) {  
            return symbol;
        }

        return isBoardFull() ? 'E' : ' ';
    }

    private boolean checkLine(char symbol, int col, int row, int deltaCol, int deltaRow) {
        int count = 1;
        count += countConsecutive(symbol, col, row, deltaCol, deltaRow);
        count += countConsecutive(symbol, col, row, -deltaCol, -deltaRow);
        return count >= 4;
    }

    private int countConsecutive(char symbol, int col, int row, int deltaCol, int deltaRow) {
        int count = 0;
        int newCol = col + deltaCol;
        int newRow = row + deltaRow;

        while (newCol >= 0 && newCol < 7 && newRow >= 0 && newRow < 6 &&
               grid[newCol][newRow] == symbol) {
            count++;
            newCol += deltaCol;
            newRow += deltaRow;
        }
        return count;
    }

    private boolean isBoardFull() {
        for (int columna = 0; columna < 7; columna++) {
            for (int fila = 0; fila < 6; fila++) {
                if (grid[columna][fila] == ' ') return false;
            }
        }
        return true;
    }

    public void printBoard() {
        for (int fila = 0; fila < 6; fila++) {
            for (int columna = 0; columna < 7; columna++) {
                System.out.print("|" + grid[columna][fila]);
            }
            System.out.println("|");
        }
        System.out.println(" 0 1 2 3 4 5 6");
    }

    public char getCurrentSymbol() {
        return currentSymbol;
    }
}
