package gamecontroller;

import animals.Animal;
import resourses.Store;

import java.io.Serializable;
import java.util.*;


/**
 *  In this class the games logic exist
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


    // konstruktorn
        public GameLogic() {
        vet = new Veterinary();
        store = new Store();
        playerList = new ArrayList<>();
        this.random = new Random();
        this.counter = counter;
        startGame();
    }

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
        playerInfos();



    }

    // This method for player's choice how many rounds they want to play.  5- 30 rounds with do-while loop.
    public void startGame() {
        System.out.println("How many rounds do you want to play? ");
        amountRounds = Integer.parseInt(scanner.nextLine());
        if (amountRounds < 5 || amountRounds > 30) {
            System.out.println("Between 5 - 30 rounds.");
            startGame();
        } else {
            askAmountPlayers();
            addPlayer();
            gameRound();
        }
    }

    private void askAmountPlayers() {
        // This method ask for how many players are going to play.
        do {
            System.out.println("How many players do you want to play? ");
            playerAmount = Integer.parseInt(scanner.nextLine());
            if (playerAmount < 2 || playerAmount > 4) {
                System.out.println("Between 2 - 4");
            }
        } while (playerAmount < 2 || playerAmount > 4);
    }

    // This method is for adding players to the list
    // Players can input names without having duplicate names.
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

    public boolean hasThisName(List<Player> playerList, String givenName) {
        for (Player player : playerList) {
            if (player.getName().equalsIgnoreCase(givenName)) {
                return true;
            }
        }
        return false;
    }

    public void playerInfos() {
        Iterator<Player> iterator = playerList.listIterator(getIndex());
        while (iterator.hasNext()) {
            Player player = iterator.next();
            checkWinner();
            info(player);
            playerChoice(player);
        }
    }

    public void animalStatsModify() {
        for (Player player : playerList) {
            if (!player.getAnimalList().isEmpty()){
                healthPriceReduce(player);
                for (Animal animal : player.getAnimalList()) {
                    animal.setAge(animal.getAge() + 5);
            }
            }
        }
    }

    // health reduce by random 10-30%
    // if health reduce by 10%  = price reduce 10% ( can change as if it wants)
    public void healthPriceReduce(Player player) {
        for (int i = 0; i < player.getAnimalList().size(); i++){
           int rn = random.nextInt(3) + 1;
            switch (rn) {
                case 1:
                    healthReduce = 0.1 * player.getAnimalList().get(i).getHealth();
                    player.getAnimalList().get(i).setHealth(player.getAnimalList().get(i).getHealth() - healthReduce);
                    if (player.getAnimalList().get(i).getHealth() < 100) {
                        priceChange(player, 0.1);
                        break;
                    }
                case 2:
                    healthReduce = 0.2 * player.getAnimalList().get(i).getHealth();
                    player.getAnimalList().get(i).setHealth(player.getAnimalList().get(i).getHealth() - healthReduce);
                    if (player.getAnimalList().get(i).getHealth() < 100) {
                        priceChange(player, 0.2);
                        break;
                    }

                case 3:
                    healthReduce = 0.3 * player.getAnimalList().get(i).getHealth();
                    player.getAnimalList().get(i).setHealth(player.getAnimalList().get(i).getHealth() - healthReduce);
                    if (player.getAnimalList().get(i).getHealth() < 100) {
                        priceChange(player, 0.3);
                        break;
                    }
                    break;
            }
        }


    }

    public void priceChange(Player player, double percentage) {
        for (Animal animal : player.getAnimalList()) {
            priceReduce = (int) (animal.getPriceToSell() * percentage);
            animal.setPriceToSell((animal.getPriceToSell() - priceReduce));
        }
    }

    public void checkWinner() {
        for (Player player : playerList) {
            if (playerList.size() == 1) {
                sellEveryThing(player);
                System.out.println("Congrats " + player.getName() + "\nYou are the winner!! ");
                gameRun = false;
                gameRound();
                break;
            }
            if (player.playerCoins == 0 && player.getAnimalList().size() < 1) {
                System.out.println("");
                System.out.println(player.getName() + " has lost. No coins and animal left. And now remove from the game...");
                playerList.remove(player);
                checkWinner();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }

            }

            }
        }

    public void sellEveryThing(Player player) {
        for (Animal animal : player.getAnimalList()) {
            player.setCoins(player.getCoins() + animal.getPriceToSell());
        }
    }

    // can sort player rank from the highest coins to the lowest coin?
    public void findPlayerRank() {
        int max = 0;
        String winner = "";
        playerCoins();
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).getCoins() > max) {
                max = playerList.get(i).getCoins();
                winner = playerList.get(i).getName();
            }
        }

        System.out.println("Congrats [" + winner +"]. You have won the game with highest coins. [" + max +" Coins]");
    }

    public void findWinnerLastRound() {
        for (Player player : playerList) {
            checkWinner();
            sellEveryThing(player);
            findPlayerRank();
            break;
        }
        gameRun = false;
        gameRound();
    }

    public void gameRound() {
        for (counter = 0; counter < amountRounds; counter++) {

            displayRounds++;
            setDisplayRounds(displayRounds);


            if (getIndex() >= playerList.size()) {
                setIndex(0);
                index = 0;
            }
            if (gameRun) {
                playerInfos();
                if  ((counter+1) > 0){
                    animalStatsModify();
                }
                    if ((counter+1) == amountRounds) {
                        findWinnerLastRound();
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

    public void playerChoice(Player player) {
        System.out.println("What do you want to do? [Player: " + player.getName() + "] | [Round: " + displayRounds + "] | " +
                "[" + player.getCoins() + " Coins] | [Max round: " +amountRounds + "]");
        System.out.println("1. Buy animals    2. Buy food   3.Sell animal    4.Feed animal    5.Breed animal     6.Save and exit");
        int input = Integer.parseInt(scanner.nextLine());
        if (input < 1 || input > 7) {
            System.out.println("Choose between 1 - 7");
        } else {
            switch (input) {
                case 1:
                    store.animalToBuy(player);

                    if (store.returnMainMenu()) {
                        info(player);
                        playerChoice(player);
                    }
                    else {
                        setIndex(index += 1);
                    }
                        break;
                case 2:
                    store.buyFood(player);

                    if (store.returnMainMenu()) {
                        info(player);
                        playerChoice(player);
                    }
                    else {
                        setIndex(index += 1);
                    }
                    break;
                case 3:
                    store.saleStart(player);

                    if (store.returnMainMenu()) {
                        info(player);
                        playerChoice(player);
                    }
                    else {

                        setIndex(index += 1);
                    }
                    break;
                case 4:
                    player.feedAnimal(player);
                    if (player.getBackToMenu()) {
                        info(player);
                        playerChoice(player);
                        break;

                    }
                   else{
                            player.checkAnimal(player, scanner);
                            setIndex(index += 1);
                    }



                    break;
                case 5:
                    vet.breedAnimal(player);
                    if (vet.getBackToMenu()) {
                        info(player);
                        playerChoice(player);
                }
                    else {

                        setIndex(index += 1);
                    }
                    break;

                    case 6:
                    System.out.println("Do you want to save and exit the game?");
                    System.out.println("1. Yes. 2. No");
                    int userChoice = Integer.parseInt(scanner.nextLine());
                    switch (userChoice) {
                        case 1:
                            saveGame(player);
                            System.exit(0);
                            break;

                        case 2:
                            info(player);
                            playerChoice(player);
                            break;
                        default:
                            System.out.println("Choose between 1 - 2");
                            break;
                    }


                default:
                    System.out.println(" Incorrect input ");
            }
        }
    }
    public void info(Player player) {
        System.out.println("---------------");
        System.out.println("[Round: " + displayRounds + "]");
        System.out.println("Player: " + player.getName() +
                "\nCoins: " + player.getCoins());
        System.out.println("---------------");
        player.animalInfo(player);
        System.out.println("---------------");
        player.printFood();
        System.out.println();
    }

    public void playerCoins() {
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


    public void saveGame(Player player) {

                System.out.print("Type in file name: ");
                String fileName = scanner.nextLine();
                FileUtilities.saveGameRunTime(new SaveRunTimeGame(this), fileName);
                System.out.println("Exiting the game. See you next time");



        }


        public void setCounter(int counter) {
            this.counter = counter;
        }


        public int getCounter() {
        return this.counter;
        }

    }
















