package gamecontroller;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *  Here we store important data and write objects of this class to a file.
 *  Information stored here must be used to get a saved game to run again.
 * @author marcusbrederfalt , Ridah, William
 *
 */

public class SaveRunTimeGame implements Serializable {

    private int playerAmount;
    private int amountRounds;
    private int index;
    private int displayRounds;
    private int counter;
    private ArrayList<Player> playerListHistory;


    /**
     * Constructor that recieves a Game object from which we store data to be able
     * to run it later when loading.
     * @param game the game we want to convert to an instance to store.
     */
    public SaveRunTimeGame (GameLogic game) {
        this.index = game.getIndex();
        this.playerAmount = game.getPlayerAmount();
        this.amountRounds = game.getAmountRounds();
        this.displayRounds = game.getDisplayRounds();
        this.playerListHistory = game.getPlayerListHistory();
        this.counter = game.getCounter();
    }

    /**
     * get method,
     * @return playerAmount, return amount of players in the game.
     */
    public int getPlayerAmount() {
        return playerAmount;
    }

    /**
     *
     * @return playerListHistory, retur narraylist of players
     */
    public ArrayList<Player> getPlayerListHistory () {
        return playerListHistory;
    }

    /**
     * get method
     * @return amountRounds in the game
     */
    public int getAmountRounds() {
        return amountRounds;
    }


    /**
     * get method
     * @return displayRounds, displayRounds that display which round the player is on.
     */
    public int getDisplayRounds() {
        return displayRounds;
    }

    /**
     * get method
     * @return index, index to keep track of which player is playing
     */
    public int getIndex () {
        return index;
    }

    /**
     * get method
     * @return, which round the the game is on.
     */
    public int getCounter() {
        return counter;
    }








}


