package GameController;

import java.io.Serializable;
import java.util.ArrayList;

public class SaveRunTimeGame implements Serializable {

    private int playerAmount;
    private int amountRounds;
    private int index;
    private ArrayList<Player> playerListHistory;


    public SaveRunTimeGame (Game game) {
        this.index = game.getIndex();
        this.playerAmount = game.getPlayerAmount();
        this.amountRounds = game.getAmountRounds();
        this.playerListHistory = game.getPlayerListHistory();




    }


    public int getPlayerAmount() {
        return playerAmount;
    }

    public ArrayList<Player> getPlayerListHistory () {
        return playerListHistory;
    }

    public int getAmountRounds() {
        return amountRounds;
    }
    public int getIndex () {
        return index;
    }






    }


