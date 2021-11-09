package gamecontroller;

import animals.Animal;
import resourses.Store;

import java.io.Serializable;
import java.util.*;


/**
 * Game logic class, game is started here
 * asks user to choose amount of player and rounds
 * methods for game logic
 */

public class GameLogic implements Serializable {
    transient Scanner scanner = new Scanner(System.in);
    private ArrayList<Player> playerList;
    private Veterinary vet;
    private Store store;
    private int playerAmount;
    private Random random;
    private int counter;
    private double healthReduce;
    private int priceReduce;
    private int amountRounds;
    private boolean gameRun = true;
    private int displayRounds = 0;
    private int index;
    private int input;
    private int userChoice;


    /**
     * Class constructor
     */
        public GameLogic() {
        vet = new Veterinary();
        store = new Store();
        playerList = new ArrayList<>();
        this.random = new Random();
        askAmountOfRounds();
    }

    /**
     * 2nd constructor to save and load game
     * @param loadSavedGame load previous played games
     */
    public GameLogic(SaveRunTimeGame loadSavedGame) {

        this.playerList = loadSavedGame.getPlayerListHistory();
        this.index = loadSavedGame.getIndex();
        this.amountRounds = loadSavedGame.getAmountRounds();
        this.displayRounds = loadSavedGame.getDisplayRounds() -1;
        this.playerAmount = loadSavedGame.getPlayerAmount();

        this.counter = loadSavedGame.getCounter();
        System.out.println("Welcome back to the game! " + loadSavedGame.getPlayerListHistory().get(loadSavedGame.getIndex()).getName());

        System.out.println("Welcome back to the game! ");


        System.out.println("Loaded old save game with the following information: ");
        System.out.println("Amount of players: " + loadSavedGame.getPlayerAmount());
        System.out.println("See below for more informations.");
        System.out.println(counter);
        store = new Store();
        vet = new Veterinary();
        this.random = new Random();
        gameRound();
        playerTakeTurn();



    }

    /**
     * method for player's choice of how many rounds they want to play.
     */
    public void askAmountOfRounds() {
        System.out.println("How many rounds do you want to play? ");
        try {
            amountRounds = Integer.parseInt(scanner.nextLine());
        }
        catch (Exception e) {
            System.out.println("Incorrect input. Enter a number");
            askAmountOfRounds();
        }

        if (amountRounds < 5 || amountRounds > 30) {
            System.out.println("Between 5 - 30 rounds.");
            askAmountOfRounds();
        } else {
            askAmountOfPlayers();
            addPlayer();
            gameRound();
        }
    }

    /**
     * Method to ask amount of players to play
     */
    private void askAmountOfPlayers() {
        do {
            System.out.println("How many players do you want to play? 2 - 4.  ");
            try {
                playerAmount = Integer.parseInt(scanner.nextLine());
            }
            catch (Exception e) {
                System.out.println("Incorrect input. Enter a number.");
                askAmountOfPlayers();
            }
            if (playerAmount < 2 || playerAmount > 4) {
                System.out.println("Between 2 - 4");
            }
        } while (playerAmount < 2 || playerAmount > 4);
    }

    /**
     *  Method for adding players to the list</Player>
     *  Players can input names without having duplicate names.
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


    }

    /**
     * This method is checking if player's name already exist.
     * @param playerList
     * @param givenName
     * @return true if player name already exists
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
     * Takes turns for players
     */
    public void playerTakeTurn() {
        Iterator<Player> iterator = playerList.listIterator(getIndex());
        while (iterator.hasNext()) {
            Player player = iterator.next();
            if (playerList.size() >1){
                checkWinnerByCoins();
            }
            printRoundInfo(player);
            gameMainMenu(player);
        }
    }

    /**
     * Increases animal age every round by 5
     */
    public void increaseAnimalAge() {
        for (Player player : playerList) {
            if (!player.getAnimalList().isEmpty()){
                healthPriceReduce(player);
                for (Animal animal : player.getAnimalList()) {
                    animal.setAge(animal.getAge() + 5);
            }
            }
        }
    }

    /**
     * @param player reduce health of every animal every round by 10-30%
     */
    public void healthPriceReduce(Player player) {
        for (int i = 0; i < player.getAnimalList().size(); i++){
           int rn = random.nextInt(3) + 1;
            switch (rn) {
                case 1:
                    healthReduce = 0.1 * player.getAnimalList().get(i).getHealth();
                    player.getAnimalList().get(i).setHealth(player.getAnimalList().get(i).getHealth() - healthReduce);
                    if (player.getAnimalList().get(i).getHealth() < 100) {
                        animalPriceChange(player, 0.1);
                        break;
                    }
                case 2:
                    healthReduce = 0.2 * player.getAnimalList().get(i).getHealth();
                    player.getAnimalList().get(i).setHealth(player.getAnimalList().get(i).getHealth() - healthReduce);
                    if (player.getAnimalList().get(i).getHealth() < 100) {
                        animalPriceChange(player, 0.2);
                        break;
                    }

                case 3:
                    healthReduce = 0.3 * player.getAnimalList().get(i).getHealth();
                    player.getAnimalList().get(i).setHealth(player.getAnimalList().get(i).getHealth() - healthReduce);
                    if (player.getAnimalList().get(i).getHealth() < 100) {
                        animalPriceChange(player, 0.3);
                        break;
                    }
                    break;
            }
        }


    }

    /**
     * @param player reduces players animals price
     * @param percentage chooses by how many percentages to reduce price
     */
    public void animalPriceChange(Player player, double percentage) {
        for (Animal animal : player.getAnimalList()) {
            priceReduce = (int) (animal.getPriceToSell() * percentage);
            animal.setPriceToSell((animal.getPriceToSell() - priceReduce));
        }
    }

    /**
     * Checks if there is a winner
     and announces winner if other players own 0 coins
     */
    public void checkWinnerByCoins() {
        for (Player player : playerList) {
            if (playerList.size() == 1) {
                sellEverything(player);
                System.out.println("Congrats " + player.getName() + "\nYou are the winner!! ");
                gameRun = true;
                gameRound();
                break;
            }
            if (player.playerCoins == 0 && player.getAnimalList().size() < 1) {
                System.out.println();
                System.out.println(player.getName() + " has lost. No coins and animal left. And now remove from the game...");
                playerList.remove(player);
                checkWinnerByCoins();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
                gameRun = true;
                gameRound();
                break;

            }else {
                gameRun = true;
            }

        }
    }

    /**
     * @param player sells players ownings
     */
    public void sellEverything(Player player) {
        for (Animal animal : player.getAnimalList()) {
            player.setCoins(player.getCoins() + animal.getPriceToSell());
        }
    }

    /**
     *  Checks what player has most money, announces winner
     */
    public void announceWinner() {
        int max = 0;
        String winner = "";
        printPlayerCoinsLastRound();
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).getCoins() > max) {
                max = playerList.get(i).getCoins();
                winner = playerList.get(i).getName();
            }
        }

        System.out.println("Congrats [" + winner +"]. You have won the game with highest coins. [" + max +" Coins]");
    }

    /**
     * Combines three methods to find winner
     */
    public void findWinner() {
        for (Player player : playerList) {
            if (playerList.size() > 1){
                checkWinnerByCoins();
            }
            sellEverything(player);
            announceWinner();
            break;
        }
        gameRun = false;
        gameRound();
    }

    /**
     * Counts game rounds
     */
    public void gameRound() {
        for (counter = getCounter(); counter < amountRounds; counter++) {

            if (counter > 0){
                displayRounds++;
                setDisplayRounds(displayRounds);
            }
            if (getIndex() >= playerList.size()) {
                setIndex(0);
                index = 0;
            }
            if (gameRun) {
                playerTakeTurn();
                if  ((counter+1) > 0){
                    increaseAnimalAge();
                }
                if ((counter+1) == (amountRounds-1)){
                    System.out.println("Game end on next round. Make best decision.");
                    FormatHelp.threadSleep();
                }
                
                    if ((counter+1) == amountRounds) {
                        findWinner();
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
     * @param player's turn to choose what to do, main menu and most game logic here.
     */
    public void gameMainMenu(Player player) {
        System.out.println("What do you want to do? [Player: " + player.getName() + "] | [Round: " + displayRounds + "] | " +
                "[" + player.getCoins() + " Coins] | [Max round: " +amountRounds + "]");
        System.out.println("1. Buy animals    2. Buy food   3.Sell animal    4.Feed animal    5.Breed animal     6.Save and exit");
        try {
            input = Integer.parseInt(scanner.nextLine());
        }
        catch (Exception e){
            System.out.println("Incorrect input. Enter a number!");
        }
        if (input < 1 || input > 7) {
            System.out.println("Choose between 1 - 7");
            gameMainMenu(player);
        } else {
            switch (input) {
                case 1:
                    store.animalToBuy(player);

                    if (store.returnMainMenu()) {
                        printRoundInfo(player);
                        gameMainMenu(player);
                    }
                    else {
                        setIndex(index += 1);
                    }
                        break;
                case 2:
                    store.buyFood(player);

                    if (store.returnMainMenu()) {
                        printRoundInfo(player);
                        gameMainMenu(player);
                    }
                    else {
                        setIndex(index += 1);
                    }
                    break;
                case 3:
                    store.saleStart(player);

                    if (store.returnMainMenu()) {
                        printRoundInfo(player);
                        gameMainMenu(player);
                    }
                    else {

                        setIndex(index += 1);
                    }
                    break;
                case 4:
                    player.checkAnimalToFeed(player, scanner);
                    
                    if (player.getBackToMenu()) {
                        printRoundInfo(player);
                        gameMainMenu(player);
                        break;

                    }
                   else{
                            setIndex(index += 1);
                    }



                    break;
                case 5:
                    vet.breedAnimal(player);
                    if (vet.getBackToMenu()) {
                        printRoundInfo(player);
                        gameMainMenu(player);
                }
                    else {

                        setIndex(index += 1);
                    }
                    break;

                    case 6:
                    System.out.println("Do you want to save and exit the game?");
                    System.out.println("1. Yes. 2. No");
                    try {
                        userChoice = Integer.parseInt(scanner.nextLine());
                    }
                    catch(Exception e){
                        System.out.println("Incorrect input, please enter a number between 1-2");
                    }

                    switch (userChoice) {
                        case 1:
                            saveGame(player);
                            System.exit(0);
                            break;

                        case 2:
                            printRoundInfo(player);
                            gameMainMenu(player);
                            break;
                        default:
                            gameMainMenu(player);
                            break;
                    }


                default:
                    System.out.println(" Incorrect input ");
            }
        }
    }

    /**
     * @param player prints out player's animals health,
     * which player turn it is, and shows current round
     */
    public void printRoundInfo(Player player) {
        System.out.println("---------------");
        System.out.println("[Round: " + displayRounds + "]");
        System.out.println("Player: " + player.getName() +
                "\nCoins: " + player.getCoins());
        System.out.println("---------------");
        player.checkAnimalHealth(player);
        if (counter >0){
            amountHealthReduced(player);
        }
        System.out.println("---------------");
        player.printFood();
        System.out.println();
    }

    /**
     *  Announces that last round is reached, and prints player's amount of coins.
     */
    public void printPlayerCoinsLastRound() {
        System.out.println("Last round reached!\nGame automatically end.\nSelling all player's animal...");
        System.out.println("Player's coins: ");
        for (Player player : playerList) {
            System.out.println("[Name: " + player.getName() + "] [Coins: " + player.getCoins()+"]");
        }

    }
    public int getPlayerAmount() {
        return this.playerAmount;

    }

    public ArrayList<Player> getPlayerListHistory() {
        return this.playerList;
    }

    public int getAmountRounds() {
        return this.amountRounds;
    }

    public void setIndex(int index) {
        this.index = index;

    }

    public void setDisplayRounds(int displayRounds) {
        this.displayRounds = displayRounds;

    }

    public int getDisplayRounds() {
        return this.displayRounds;
    }


    public int getIndex() {
        return this.index;
    }

    /**
     * method to name file to save
     */
    public void saveGame(Player player) {

                System.out.print("Type in file name: ");
                String fileName = scanner.nextLine();
                FileUtilities.saveGameRunTime(new SaveRunTimeGame(this), fileName);
                System.out.println("Exiting the game. See you next time");

        }

        public int getCounter() {
        return this.counter;
        }

    public void amountHealthReduced(Player player){
        for (Animal animal: player.getAnimalList()){
            System.out.println("["+animal.getName() + "] [Health reduced: " + healthReduce +"] [Age: + 5 ]" + "[Price reduced: "+priceReduce +"]");
        }

    }


}

















