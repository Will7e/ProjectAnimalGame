package gamecontroller;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *  Here we store important data and write objects of this class to a file.
 *  Information stored here must be used to get a game up and running.
 */



public class SaveRunTimeGame implements Serializable {

    private int playerAmount;
    private int amountRounds;
    private int index;
    private int displayRounds;
    private int counter;
    private ArrayList<Player> playerListHistory;


    /**
     * Constructor
     * @param game
     */

    public SaveRunTimeGame (GameLogic game) {
        this.index = game.getIndex();
        this.playerAmount = game.getPlayerAmount();
        this.amountRounds = game.getAmountRounds();
        this.displayRounds = game.getDisplayRounds();
        this.playerListHistory = game.getPlayerListHistory();
        this.counter = game.getCounter();

        
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
        return displayRounds;
    }
    public int getIndex () {
        return index;
    }
    public int getCounter() {
        return counter;
    }








}


