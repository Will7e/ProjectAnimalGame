package GameController;

import java.io.Serializable;
import java.util.ArrayList;

public class SaveRunTimeGame implements Serializable {

    private int playerAmount;
    private int amountRounds;
    private ArrayList<Player> history;

    public SaveRunTimeGame (Game game) {

        this.playerAmount = getPlayerAmount();
        this.amountRounds = getAmountRounds();
        this.history = getHistory();

    }


    public int getPlayerAmount() {
        return playerAmount;
    }

    public ArrayList<Player> getHistory () {
        return history;
    }

    public int getAmountRounds() {
        return amountRounds;
    }
}
