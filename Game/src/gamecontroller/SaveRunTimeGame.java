package gamecontroller;

import gamecontroller.Game;
import gamecontroller.Player;

import java.io.Serializable;
import java.util.ArrayList;

public class SaveRunTimeGame implements Serializable {

    private int playerAmount;
    private int amountRounds;
    private int index;
    private int displayRounds;
    private ArrayList<Player> playerListHistory;
    private boolean savedGame;


    public SaveRunTimeGame (Game game) {
        this.index = game.getIndex();
        this.playerAmount = game.getPlayerAmount();
        this.amountRounds = game.getAmountRounds();
        this.displayRounds = game.getDisplayRounds();
        this.playerListHistory = game.getPlayerListHistory();
        //  this.savedGame = game.getSavedGame();
        
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
    public int getDisplayRounds() {
        return displayRounds - 1;
    }
    public int getIndex () {
        return index;
    }








}


