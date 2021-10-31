package gamecontroller;

import animals.Animal;
import resourses.Store;

import java.util.*;

public class Game {
    private Scanner scanner = new Scanner(System.in);
    public ArrayList<Player> playerList;
    private Veterinary vet;
    protected Store store;
    private int playerAmount;
    Random random;
    int i;
    double healthReduceBy10;
    double healthReduceBy20;
    double healthReduceBy30;


    // konstruktorn
    public Game() {

        this.vet = new Veterinary();
        store = new Store();
        this.playerList = new ArrayList<>();
        this.random = new Random();
        startGame();
    }

    // This method for player's choice how many rounds they want to play.  5- 30 rounds with do-while loop.
    public void startGame() {
        System.out.println("How many rounds do you want to play? ");
        int input = Integer.parseInt(scanner.nextLine());
        if (input < 5 || input > 30) {
            System.out.println("Between 5 - 30 rounds.");
            startGame();
        } else {
            askAmountPlayers();
            addPlayer();
            for (i = 1; i <= input; i++) {
                playerChoice();
                if (i > 0) {
                    animalStatsModify();
                    if (i > input){
                        // Last round.
                    }
                }
            }
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

    //Case 1 - Buy animal / Set gender.
    public void playerChoice() {
        Iterator<Player> iterator = playerList.iterator();
        while (iterator.hasNext()) {
            Player player = iterator.next();
            System.out.println("---------------");
            System.out.println("[Round: " + i + "]");
            System.out.println("Player: " + player.getName() +
                    "\nCoins: " + player.getCoins());
            System.out.println("---------------");
            player.printAnimal(player);
            System.out.println("---------------");
            player.printFood(player);
            System.out.println();
            System.out.println("What do you want to do? [Player: " + player.getName() + "] | [Round: " + i + "] | [" + player.getCoins() + " Coins]");
            if ( i > 0){ // Start with message about animals healths and age

            }
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
                        store.sellAnimal(player);
                        break;
                    case 4:
                        player.feedAnimal(player);
                        playerChoice();
                        break;
                    case 5:
                        vet.breedAnimal(player);
                        break;
                    default:
                        System.out.println(" Incorrect input ");
                }
            }
        }
    }

    public void animalStatsModify() {
        for (Player player: playerList){
            for (Animal animal : player.getAnimalList()) {
                healthPriceReduce(player);
                animal.setAge(animal.getAge() + 5);
            }

        }

    }

    // health reduce by random 10-30%
    public void healthPriceReduce(Player player){
        Random random = new Random();
        int rn = random.nextInt(3) + 1;
        for (Animal animal: player.getAnimalList()){
            switch (rn){
                case 1:
                    healthReduceBy10 = 0.1 *animal.getHealth();
                    animal.setHealth(animal.getHealth() - healthReduceBy10);
                    System.out.println("Health reduce 10%. \n (Reduced by " + healthReduceBy10);
                    if (animal.getHealth() < 100){

                    }
                    break;

                case 2:
                    healthReduceBy20 = 0.2 * animal.getHealth();
                    animal.setHealth(animal.getHealth() - healthReduceBy20);
                    System.out.println("Health reduce 20%. \n (Reduced by " + healthReduceBy20);
                    if (animal.getHealth() < 100){

                    }
                    break;

                case 3:
                    healthReduceBy30 = 0.3 * animal.getHealth();
                    animal.setHealth(animal.getHealth() - healthReduceBy30);
                    System.out.println("Health reduce 20%. \n (Reduced by " + healthReduceBy30);
                    if (animal.getHealth() < 100){

                    }
                    break;
            }

        }


    }
}















