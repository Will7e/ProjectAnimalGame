package GameController;

import java.io.Serializable;
import java.util.ArrayList;

public class SaveRunTimeGame implements Serializable {

    private int playerAmount;
    private int amountRounds;
    private ArrayList<Player> playerList;

    public SaveRunTimeGame (Game game) {

        this.playerAmount = game.getPlayerAmount();
        this.amountRounds = game.getAmountRounds();
        this.playerList = game.getPlayerList();

    }


    public int getPlayerAmount() {
        return playerAmount;
    }

    public ArrayList<Player> getPlayerListHistory () {
        return playerList;
    }

    public int getAmountRounds() {
        return amountRounds;
    }
}
