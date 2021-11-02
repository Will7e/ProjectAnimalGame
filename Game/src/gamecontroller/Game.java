package gamecontroller;

import animals.Animal;
import resourses.Store;

import java.io.Serializable;
import java.util.*;

public class Game implements Serializable {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Player> playerList;
    public static Veterinary vet;
    public static Store store;
    private int playerAmount;
    Random random;
    public static int i;
    protected static double healthReduce;
    protected static int priceReduce;
    protected static int input;
    public static boolean gameRun = true;



    // konstruktorn
    public Game() {

        vet = new Veterinary();
        store = new Store();
        playerList = new ArrayList<>();
        this.random = new Random();
        startGame();
    }
    public Game(SaveRunTimeGame loadSavedGame) {

        this.playerList = loadSavedGame.getPlayerListHistory();
        this.index = loadSavedGame.getIndex();
        this.amountRounds = loadSavedGame.getAmountRounds();
        this.displayRounds = loadSavedGame.getDisplayRounds();
        this.playerAmount = loadSavedGame.getPlayerAmount();
        System.out.println("Welcome back to the game! " + loadSavedGame.getPlayerListHistory().get(loadSavedGame.getIndex()).getName());

        System.out.println("Loaded old save game with the following information: ");
        System.out.println("Amount of players = " + loadSavedGame.getPlayerAmount());
        System.out.println("See below for more information");
        store = new Store();
        playerChoice(amountRounds);

    }
        // This method for player's choice how many rounds they want to play.  5- 30 rounds with do-while loop.
    public void startGame() {
        System.out.println("How many rounds do you want to play? ");
        input = Integer.parseInt(scanner.nextLine());
        if (input < 2 || input > 30) {
            System.out.println("Between 5 - 30 rounds.");
            startGame();
        } else {
            askAmountPlayers();
            addPlayer();
            gameRound(input);
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

    public static void playerInfos() {
        Iterator<Player> iterator = playerList.iterator();
        while (iterator.hasNext()) {
            Player player = iterator.next();
            checkWinner();
            info(player);
            playerChoice(player);
        }
    }
    public static void animalStatsModify() {
        for (Player player: playerList){
            for (Animal animal : player.getAnimalList()) {
                healthPriceReduce(player);
                animal.setAge(animal.getAge() + 5);
            }
        }
    }
    // health reduce by random 10-30%
    // if health reduce by 10%  = price reduce 10% ( can change as if it wants)
    public static void healthPriceReduce(Player player){
        Random random = new Random();
        int rn = random.nextInt(3) + 1;
        for (Animal animal: player.getAnimalList())
            switch (rn) {
                case 1:
                    healthReduce = 0.1 * animal.getHealth();
                    animal.setHealth(animal.getHealth() - healthReduce);
                    if (animal.getHealth() < 100) {
                        priceChange(player, 0.1);
                        break;
                    }
                case 2:
                    healthReduce = 0.2 * animal.getHealth();
                    animal.setHealth(animal.getHealth() - healthReduce);
                    if (animal.getHealth() < 100) {
                        priceChange(player, 0.2);
                        break;
                    }

                case 3:
                    healthReduce = 0.3 * animal.getHealth();
                    animal.setHealth(animal.getHealth() - healthReduce);
                    if (animal.getHealth() < 100) {
                        priceChange(player, 0.3);
                        break;
                    }
            }

    }
    public static void priceChange(Player player, double percentage){
        for (Animal animal : player.getAnimalList()){
            priceReduce = (int) (animal.getPriceToSell() * percentage);
            animal.setPriceToSell( ( animal.getPriceToSell() - priceReduce));
        }
    }
    public static void checkWinner(){
        for (Player player : playerList){
            if (playerList.size() == 1){
                sellEveryThing(player);
                System.out.println("Congrats " + player.getName()+"\nYou are the winner!! ");
                gameRun = false;
                gameRound(input);
                break;
            }
            if (player.playerCoins == 0 && player.getAnimalList().size() < 1){
                System.out.println("");
                System.out.println(player.getName() + " has lost. No coins and animal left. And now remove from the game.");
                playerList.remove(player);
                checkWinner();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }

            }if (player.getCoins() == 0) {
                System.out.println("You have zero coins. Sell your animal to get coins.");
                playerChoice(player);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
    public static void sellEveryThing(Player player){
        for (Animal animal : player.getAnimalList()){
            player.setCoins(player.getCoins() + animal.getPriceToSell());
        }
    }
    // can sort player rank from the highest coins to the lowest coin?
    public static void findPlayerRank(){
        int max = 0;
        String winner ="";
        for(int i= 0; i< playerList.size(); i++){
            if (playerList.get(i).getCoins() > max ){
                max = playerList.get(i).getCoins();
                winner = playerList.get(i).getName();
            }
        }
        System.out.println("Winner " + winner);
    }
    public static void findWinnerLastRound(){
        for (Player player : playerList){
            checkWinner();
            sellEveryThing(player);
            findPlayerRank();
            break;
        }
        gameRun = false;
        gameRound(input);
    }
    public static void gameRound(int input ){
        for (i = 1; i <= input; i++) {
            if (gameRun){
                playerInfos();
                if (i > 0) {
                    animalStatsModify();
                    if (i == input){
                        findWinnerLastRound();
                        break;
                    }
                }
            }else {
                System.out.println("Game Over");
                System.exit(0);
                break;
            }
            System.out.println();
        }
    }
    public static void playerChoice(Player player){
        System.out.println("What do you want to do? [Player: " + player.getName() + "] | [Round: " + i + "] | [" + player.getCoins() + " Coins]");
        System.out.println("1. Buy animals    2. Buy food   3.Sell animal    4.Feed animal    5.Breed animal     6.Save & Quit");
        int input = Integer.parseInt(scanner.nextLine());
        if (input < 1 || input > 6) {
            System.out.println("Choice between 1 - 6");
        } else {
            switch (input) {
                case 1:
                    store.animalToBuy(player);
                    break;
                case 2:
                    store.buyFood(player);
                    break;
                case 3:
                    store.saleStart(player);
                    break;
                case 4:
                    player.feedAnimal(player);
                    break;
                case 5:
                    vet.breedAnimal(player);
                    break;
                default:
                    System.out.println(" Incorrect input ");
            }
        }
    }
    public static void info(Player player){
        System.out.println("---------------");
        System.out.println("[Round: " + i + "]");
        System.out.println("Player: " + player.getName() +
                "\nCoins: " + player.getCoins());
        System.out.println("---------------");
        player.printAnimal(player);
        System.out.println("---------------");
        player.printFood(player);
        System.out.println();
    }

    public String playerCoins(){
        for (Player player : playerList){

        }
    }

}















