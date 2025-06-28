public class Player {
    private String playerName;
    private int wins;
    private int draws;
    private int losses;
    public Player(String playerName, int wins, int draws, int losses) {
        this.playerName = playerName;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
    }
    public String getPlayerName() {
        return playerName;
    }
    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }
    public int getLosses() {
        return losses;
    }

    public void addWin() {
        wins++;
    }
    public void addDraw() {
        draws++;
    }
    public void addLoss() {
        losses++;
    }
    public double winRate() {
        int totalGames = wins + draws + losses;
        if (totalGames == 0)  return 0.0;
        return (double) wins / totalGames;
    }
}