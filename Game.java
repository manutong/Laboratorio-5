import java.util.Scanner;

public class Game {
private String status;
private String winnerPlayerName;
private String playerNameA;
private String playerNameB;
private ConnectFour connectFour;

public Game(String playerNameA, String playerNameB) {
    this.playerNameA = playerNameA;
    this.playerNameB = playerNameB;
    connectFour = new ConnectFour();
    this.status = "IN_PROGRESS";
    this.winnerPlayerName = "";

}
public String play(){
Scanner scanner = new Scanner(System.in);
while(status.equals("IN_PROGRESS")){
    connectFour.printBoard();
    char currentSymbol = connectFour.getCurrentSymbol();

    String currentPlayer = (currentSymbol == 'X') ? playerNameA : playerNameB;
    System.out.println("Es turno de " + currentPlayer + " (" + currentSymbol + ")");
    System.out.print("Ingrese la columna (0-6) para colocar la ficha: ");

    int columna;
    if (scanner.hasNextInt()) {
        columna = scanner.nextInt();
    } else {
        System.out.println("Entrada inválida. Debe ingresar un número entre 0 y 6.");
        scanner.next();
        continue;
    }
boolean moved = connectFour.makeMove(columna);
    if (!moved) {
        System.out.println("Movimiento inválido. Intente otra columna.");
        continue;
    }
char resultado = connectFour.isGameOver();
    if (resultado == 'X' || resultado == 'O') {
        status = "VICTORY";
        winnerPlayerName = (resultado == 'X' ? playerNameA : playerNameB);
    } else if (resultado == 'E') {
        status = "DRAW";
        winnerPlayerName = "";
    }
}
connectFour.printBoard();

if (status.equals("VICTORY")) {
    System.out.println(winnerPlayerName + " ha ganado la partida");
return winnerPlayerName;
} else {
    System.out.println("La partida terminó en empate");
    return "";
}
}
    public String getStatus() {
        return status;
    }

    public String getWinnerPlayerName() {
        return winnerPlayerName;
    }
}


