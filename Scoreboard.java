import java.util.*;

public class Scoreboard {
    private BST winTree;
    private HashST<String, Player> players;
    private int playedGames;

    public Scoreboard() {
        winTree = new BST();
        players = new HashST<>();
        playedGames = 0;
    }

    public void addGameResult(String winnerPlayerName, String looserPlayerName, boolean draw) {
        if (!players.contains(winnerPlayerName) || !players.contains(looserPlayerName)) return;

        Player winner = players.get(winnerPlayerName);
        Player loser = players.get(looserPlayerName);

        if (draw) {
            winner.addDraw();
            loser.addDraw();
        } else {
            // Antes de modificar las victorias del jugador, guarda el valor anterior
            int oldWins = winner.getWins();
            winner.addWin();
            winTree.removeValue(oldWins, winnerPlayerName); // elimina del nodo anterior
            winTree.put(winner.getWins(), winnerPlayerName); // agrega en el nodo nuevo

            loser.addLoss();
        }

        playedGames++;
    }


    public void registerPlayer(String playerName) {
        if (!players.contains(playerName)) {
            Player p = new Player(playerName, 0, 0, 0);
            players.put(playerName, p);
            winTree.put(0, playerName);
        }
    }

    public boolean checkPlayer(String playerName) {
        return players.contains(playerName);
    }

    public Player[] winRange(int lo, int hi) {
        List<String> namesInRange = winTree.getInRange(lo, hi);
        List<Player> result = new ArrayList<>();

        for (String name : namesInRange) {
            Player p = players.get(name);
            if (p != null) result.add(p);
        }

        return result.toArray(new Player[0]);
    }

    public Player[] winSuccessor(int wins) {
        List<String> successorNames = winTree.successor(wins);
        List<Player> result = new ArrayList<>();

        for (String name : successorNames) {
            Player p = players.get(name);
            if (p != null) result.add(p);
        }

        return result.toArray(new Player[0]);
    }
}
