public class ConnectFour {

private char[][] grid;
private char currentSymbol;

public ConnectFour() {
grid = new char[7][6];
for(int columna =0; columna <7; columna++) {
for(int fila =0; fila < 6; fila++) {
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
                // Cambia el símbolo solo si se colocó la ficha
                currentSymbol = (currentSymbol == 'X') ? 'O' : 'X';
                return true;
            }
        }
                return false;
    }

    public char isGameOver() {

        for (int columna = 0; columna < 7; columna++) {
            for (int fila = 0; fila < 6; fila++) {
                char symbol = grid[columna][fila];
                if (symbol == ' ') continue;


                if (columna + 3 < 7 &&
                        symbol == grid[columna + 1][fila] &&
                        symbol == grid[columna + 2][fila] &&
                        symbol == grid[columna + 3][fila])
                    return symbol;


                if (fila + 3 < 6 &&
                        symbol == grid[columna][fila + 1] &&
                        symbol == grid[columna][fila + 2] &&
                        symbol == grid[columna][fila + 3])
                    return symbol;


                if (columna + 3 < 7 && fila + 3 < 6 &&
                        symbol == grid[columna + 1][fila + 1] &&
                        symbol == grid[columna + 2][fila + 2] &&
                        symbol == grid[columna + 3][fila + 3])
                    return symbol;


                if (columna - 3 >= 0 && fila + 3 < 6 &&
                        symbol == grid[columna - 1][fila + 1] &&
                        symbol == grid[columna - 2][fila + 2] &&
                        symbol == grid[columna - 3][fila + 3])
                    return symbol;
            }
        }


        if (isBoardFull()) return 'E';

        return ' ';
    }

    private boolean isBoardFull() {
        for (int columna = 0; columna < 7; columna++) {
            for (int fila = 0; fila < 6; fila++) {
                if (grid[columna][fila] == ' ') return false;
            }
        }
        return true;
    }
    public void printBoard() { //AUXILIAR PARA IMPRIMIR TABLERO
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