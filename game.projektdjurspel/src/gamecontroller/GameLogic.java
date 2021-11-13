package gamecontroller;

import animals.Animal;
import resourses.Store;
import resourses.Veterinary;

import java.io.Serializable;
import java.util.*;

/**
 *  This is the GameLogic class and as the name implies, here is how the games logic is built up.
 *  The class keeps track of players in the game and which round the player, players are on.
 *  The player get to choose between all the options in the game from this class.
 * @author William, Marcus, Ridah
 *
 */

public class GameLogic implements Serializable {
    transient Scanner scanner = new Scanner(System.in); // transient so that we can be able send the class to  SaveRunTimeGame
    protected ArrayList<Player> playerList;
    protected Veterinary veterinary;
    protected Store store;
    protected int playerAmount; // Amount of player
    protected Random random;
    protected int counter; // Start value of for loop.
    protected int amountRounds; // Amount max round for loop to end
    protected boolean gameRun = true; // Check if loop still run.
    protected int displayRounds = 0; // This let player know which round player are in
    protected int index;
    protected int input;
    protected int userChoice;


    /**
     * Constructor for this class.
     */
    public GameLogic() {
        veterinary = new Veterinary(); // Initialize Veterinary
        store = new Store();// Initialize Store
        playerList = new ArrayList<>();// Initialize player list
        this.random = new Random(); // Initialize Random
        startGame();
    }

    /**
     *
     * This is the constructor that starts the game when loading a saved game.
     * @param loadSavedGame loading saved game from file.
     */

    public GameLogic(SaveRunTimeGame loadSavedGame) {
        this.playerList = loadSavedGame.getPlayerListHistory();
        this.index = loadSavedGame.getIndex();
        this.amountRounds = loadSavedGame.getAmountRounds();
        this.displayRounds = loadSavedGame.getDisplayRounds() - 1;
        this.playerAmount = loadSavedGame.getPlayerAmount();

        this.counter = loadSavedGame.getCounter();
        System.out.println("Welcome back to the game! " + loadSavedGame.getPlayerListHistory().get(loadSavedGame.getIndex()).getName());

        System.out.println("Loaded old save game with the following information: ");
        System.out.println("Amount of players: " + loadSavedGame.getPlayerAmount());
        System.out.println("See below for more informations.");
        store = new Store();
        veterinary = new Veterinary();
        this.random = new Random();
        gameRound();

    }

    /**
     * saveGame method
     * @param player , saves the game
     */
    public void saveGame(Player player) {
        System.out.print("Type in file name: ");
        String fileName = scanner.nextLine();
        FileUtilities.saveGameRunTime(new SaveRunTimeGame(this), fileName);
        System.out.println("Exiting the game. See you next time");

    }

    /**
     * This method is where the game going to start. It asks for round, calls for ask amount of player and add player method.
     * Try catch for incorrect input.
     */
    public void startGame() {
        System.out.println("How many rounds do you want to play? ");
        try {
            amountRounds = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Incorrect input. Enter a number");
            startGame();
        }
        if (amountRounds < 5 || amountRounds > 30) {
            System.out.println("Between 5 - 30 rounds.");
            startGame();
        } else {
            requestPlayersAmount();
            addPlayer();
            gameRound();
        }
    }


    /**
     * This method is for player to decide how many players going to player this game. But with limitation.
     * Try catch for incorrect input and while loop to limit amount of players ( 2-4)
     */
    private void requestPlayersAmount() {
        // This method ask for how many players are going to play.
        do {
            System.out.println("How many players do you want to play? 2 - 4.  ");
            try {
                playerAmount = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Incorrect input. Enter a number.");
                requestPlayersAmount();
            }
            if (playerAmount < 2 || playerAmount > 4) {
                System.out.println("Between 2 - 4");
            }
        } while (playerAmount < 2 || playerAmount > 4);
    }

    /**
     * This method is where the game add players. Player can decide their name, but not duplicated.
     * This method allow the game to add as amount player as we decide on.
     */
    public void addPlayer() {
        int i = 1;
        do {
            System.out.print("Player " + i + " name: ");
            String name = scanner.nextLine();
            if (hasThisName(playerList, name)) {
                System.out.println("The name is already taken.");
                continue;
            }
            playerList.add(new Player(name.toUpperCase()));
            i++;
        } while (i <= playerAmount);

        // This method is checking if player's name already exist.
    }

    /**
     * This method is to display which round the game start with and which player's turn it is.
     * This method is calling for another method in Player class to let player know what he/she has.
     * @param player turn.
     */
    public void playerDisplay(Player player) {
        System.out.println("---------------");
        System.out.println("[Round: " + displayRounds + "]");
        System.out.println("Player: " + player.getName() +
                "\nCoins: " + player.getCoins());
        System.out.println("---------------");
        player.checkAnimalHealth(player);
        System.out.println("---------------");
        player.printFoodOwn();
        System.out.println();
    }


    /**
     * This method is where player takes turn and have their choices. Each player have their own turn
     * if one has nothing left, it removes that player from the game.
     */
    public void playerTakesTurn() {
        Iterator<Player> iterator = playerList.listIterator(getIndex());
        while (iterator.hasNext()) {
            Player player = iterator.next();
            if (player.getCoins() <= 0 && player.getAnimalList().size() <1){
                System.out.println(player.getName() + " has no animal and coin. Now remove from the game.");
                iterator.remove();
                FormatHelp.threadSleep();
                FormatHelp.emptyScreen();
                break;
            }
            playerDisplay(player);
            playerChoice(player);

        }
    }
    /**
     * This method is the menu choice for player's. It displays options for player.
     * @param player to decide for which options they're going to go for.
     */
    public void playerChoice(Player player) {
        System.out.println("What do you want to do? [Player: " + player.getName() + "] | [Round: " + displayRounds + "] | " +
                "[" + player.getCoins() + " Coins] | [Max round: " + amountRounds + "]");
        System.out.println("1. Buy animals    2. Buy food   3.Sell animal    4.Feed animal    5.Breed animal     6.Save and exit");
        try {
            input = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Incorrect input. Enter a number 1 - 7!");
        }
        if (input < 1 || input > 7) {
            System.out.println("Choose between 1 - 7");
            playerChoice(player);
        } else {
            switch (input) {
                case 1:
                    store.animalToBuy(player);

                    if (store.returnMainMenu()) {
                        playerDisplay(player);
                        playerChoice(player);
                    } else {
                        setIndex(index += 1);
                    }
                    break;
                case 2:
                    store.buyFood(player);

                    if (store.returnMainMenu()) {
                        playerDisplay(player);
                        playerChoice(player);
                    } else {
                        setIndex(index += 1);
                    }
                    break;
                case 3:
                    store.saleStart(player);

                    if (store.returnMainMenu()) {
                        playerDisplay(player);
                        playerChoice(player);
                    } else {

                        setIndex(index += 1);
                    }
                    break;
                case 4:
                    player.checkAnimalToFeed(player, scanner);
                    if (player.getBackToMenu()) {
                        playerDisplay(player);
                        playerChoice(player);
                        break;
                    } else {
                        setIndex(index += 1);
                    }

                    break;
                case 5:
                    veterinary.animalBreeding(player);
                    if (veterinary.getBackToMenu()) {
                        playerDisplay(player);
                        playerChoice(player);
                    } else {
                        setIndex(index += 1);
                    }
                    break;

                case 6:
                    System.out.println("Do you want to save and exit the game?");
                    System.out.println("1. Yes.   2. No");
                    try {
                        userChoice = Integer.parseInt(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Incorrect input. Enter a number between 1 - 2");
                    }

                    switch (userChoice) {
                        case 1:
                            saveGame(player);
                            System.exit(0);
                            break;

                        case 2:
                            playerDisplay(player);
                            playerChoice(player);
                            break;
                        default:
                            playerChoice(player);
                            break;
                    }
                default:
                    System.out.println(" Incorrect input ");
            }
        }
    }

    /**
     * This method is where the game round runs till reach max round. In this method we set condition to controlls
     * what are going to happen each round or what happen when it ends.
     */
    public void gameRound() {
        for (counter = getCounter(); counter < amountRounds; counter++) {

            displayRounds++;
            setDisplayRounds(displayRounds);

            if (getIndex() >= playerList.size()) {
                setIndex(0);
                index = 0;
            }
            if (gameRun) {
                playerTakesTurn();
                if ((counter + 1) > 0) {
                    playerTakesTurn();
                    animalStatsModify();
                }
                if ((counter + 1) == (amountRounds - 1)) {
                    System.out.println("Game end on next round. Make best decision.");
                    FormatHelp.threadSleep();
                }

                if ((counter + 1) == amountRounds) {
                    findGameWinner();
                    break;

                }
            } else {
                System.out.println("[ - Game Over - ] ");
                System.exit(0);
                break;
            }
            System.out.println();
        }
    }


    /**
     * This method is when the game end. Player receives all coins that he/she can get by selling animals.
     * This method loop through every animal in player animal list and add to his current coins.
     * @param player that receives coins
     */
    public void sellEveryThing(Player player) {
        for (Animal animal : player.getAnimalList()) {
            player.setCoins(player.getCoins() + animal.getPriceToSell());
        }
    }
    /**
     * This method loop through player list. Finding the player who has most coins in the list.
     */
    public void playerWithHighestCoins() {
        int max = 0;
        String winner = "";
        gameEndMessage();
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).getCoins() > max) {
                max = playerList.get(i).getCoins();
                winner = playerList.get(i).getName();
            }
        }

        System.out.println("Congrats [" + winner + "]. You have won the game with highest coins. [" + max + " Coins]");
    }


    /**
     * This method uses when the game reach last game. Player are going sell everything and finding who has most coins.
     * Then game end.
     */
    public void findGameWinner() {
        for (Player player : playerList) {
            sellEveryThing(player);
        }
        playerWithHighestCoins();
        gameRun =false;
        gameRound();
    }
    /**
     * This method is for change health and price of every animal in player's animal list.
     */
    public void animalStatsModify() {
        for (Player player : playerList) {
            if (!player.getAnimalList().isEmpty()) {
                reduceAnimalHealthNPrice(player);
            }else {
                break;
            }
        }
    }

    /**
     * This method randomize the amount of animal health that reduces. It's between 10 - 30%
     * Within this method it calls for the price change method as well as the health reduced.
     *
     * @param player takes turn.
     */
    public void reduceAnimalHealthNPrice(Player player) {
        if (!player.getAnimalList().isEmpty()) {
            for (int i = 0; i < player.getAnimalList().size(); i++) {
                int rn = random.nextInt(3) + 1;
                switch (rn) {
                    case 1:
                        player.getAnimalList().get(i).setHealthReduced(0.1 * player.getAnimalList().get(i).getHealth());
                        player.getAnimalList().get(i).setHealth(player.getAnimalList().get(i).getHealth() - player.getAnimalList().get(i).getHealthReduced());
                        player.getAnimalList().get(i).setAge(player.getAnimalList().get(i).getAge() + 1);
                        animalPriceChange(player.getAnimalList().get(i), 0.1);
                        break;

                    case 2:
                        player.getAnimalList().get(i).setHealthReduced(0.2 * player.getAnimalList().get(i).getHealth());
                        player.getAnimalList().get(i).setHealth(player.getAnimalList().get(i).getHealth() - player.getAnimalList().get(i).getHealthReduced());
                        player.getAnimalList().get(i).setAge(player.getAnimalList().get(i).getAge() + 1);
                        animalPriceChange(player.getAnimalList().get(i), 0.2);
                        break;

                    case 3:
                        player.getAnimalList().get(i).setHealthReduced(0.3 * player.getAnimalList().get(i).getHealth());
                        player.getAnimalList().get(i).setHealth(player.getAnimalList().get(i).getHealth() - player.getAnimalList().get(i).getHealthReduced());
                        player.getAnimalList().get(i).setAge(player.getAnimalList().get(i).getAge() + 1);
                        animalPriceChange(player.getAnimalList().get(i), 0.3);
                        break;
                }
            }
        }

    }

    /**
     * This method reduce the price to sell of each animals
     * @param animal price to reduce.
     * @param percentage as amount that reduces.
     */
    public void animalPriceChange(Animal animal, double percentage) {
            animal.setPriceReduced((int) (animal.getPriceToSell() * percentage));
            animal.setPriceToSell((animal.getPriceToSell() - animal.getPriceReduced()));
    }

    /**
     * This method prints out players and their coins when the game end
     */
    public void gameEndMessage() {
        System.out.println("Last round reached!\nGame automatically end.\nSelling all player's animal...");
        System.out.println("Player's coins: ");
        for (Player player : playerList) {
            System.out.println("[Name: " + player.getName() + "] [Coins: " + player.getCoins() + "]");
        }
    }

    /**
     *This method check either if the name is already exist in player list
     * @param playerList each player in list
     * @param givenName name that player input
     * @return true or false.
     */
    public boolean hasThisName(List<Player> playerList, String givenName) {
        for (Player player : playerList) {
            if (player.getName().equalsIgnoreCase(givenName)) {
                return true;
            }
        }
        return false;
    }
    /**
     * This get amount of players.
     * @return amount of players.
     */
    public int getPlayerAmount() {
        return this.playerAmount;

    }

    /**
     * This get player list.
     * @return list of player
     */
    public ArrayList<Player> getPlayerListHistory() {
        return this.playerList;
    }

    /**
     * This get amount of game rounds.
     * @return amount of rounds.
     */
    public int getAmountRounds() {
        return this.amountRounds;
    }

    public void setIndex(int index) {
        this.index = index;

    }


    /**
     * This set the rounds that going to show to player
     * @param displayRounds is the round at the game start.
     */
    public void setDisplayRounds(int displayRounds) {
        this.displayRounds = displayRounds;

    }

    /**
     * This get the rounds that display to players
     * @return game round players are in.
     */
    public int getDisplayRounds() {
        return this.displayRounds;
    }

    public int getIndex() {
        return this.index;
    }

    /**
     * Get the round that game start with as it increase each round
     * @return game round that player are playing.
     */
    public int getCounter() {
        return this.counter;
    }

}
















