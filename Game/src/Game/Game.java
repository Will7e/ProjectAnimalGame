package Game;

import java.util.ArrayList;
import java.util.List;


public class Game {

    private List<Player> playersList;
    private int gameRounds;
    private int numberOfPlayers;

    public Game() {
        this.playersList = new ArrayList<>();

    }

    public void game() {



    }

    public List <Player> getPlayersList() {
        return playersList;
    }

    public void addPlayer(Player player) {

    }

    public int getGameRounds() {
        return gameRounds;
    }

    public void setGameRounds(int gameRounds) {
        this.gameRounds = gameRounds;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
}
