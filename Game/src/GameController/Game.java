package GameController;

import Resourses.*;


import java.io.Serializable;
import java.util.*;

public class Game implements Serializable {

    transient Scanner scanner = new Scanner(System.in);
    private int index;
    private ArrayList<Player> playerList;
    protected Store store;
    private int playerAmount;
    private int amountRounds;
    private int displayRounds = 0;
    private String fileName;
    private Player playersTurn;


    Vet vet = new Vet();
    // konstruktorn

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


    public Game() {

        this.index = index;
        this.playerList = new ArrayList<>();
        store = new Store();
        this.playerAmount = playerAmount;
        this.amountRounds = amountRounds;
        startGame();


    }

    // This method for player's choice how many rounds they want to play.  5- 30 rounds with do-while loop.
    public void startGame() {
        System.out.println("How many rounds do you want to play? ");
        int input = Integer.parseInt(scanner.nextLine());
        setAmountRounds(input);

        if (input < 5 || input > 30) {
            System.out.println("Between 5 - 30 rounds.");
            startGame();
        } else {
            askAmountPlayers();
            addPlayer();
            playerChoice(input);
        //    for (amountRounds = 1; amountRounds <= input; amountRounds++) {
          //      playerChoice();
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
    public void playerChoice(int amountRounds) {



        for (int i = 0; i < amountRounds; i++) {

            displayRounds++;
            setDisplayRounds(displayRounds);

            if (getIndex() >= playerList.size()) {
                setIndex(0);
                index = 0;
            }




            Iterator<Player> iterator = playerList.listIterator(getIndex());


            while (iterator.hasNext()) {

                Player player = iterator.next();

                System.out.println("---------------");
                System.out.println("[Round: " +  getDisplayRounds()+ "]");
                System.out.println("Player: " + player.getName() +
                        "\nCoins: " + player.getCoins());
                System.out.println("---------------");
                player.printAnimal(player);
                System.out.println("---------------");
                player.printFood(player);
                System.out.println();
                System.out.println(getIndex()); // left here for debugging, delete later
                System.out.println("I = " + i); // left here for debugging, delete later
                System.out.println("What do you want to do? [Player: " + player.getName() + "] | [Round: " + getDisplayRounds() + "] |[" + player.getCoins() + " Coins]");
                System.out.println("1. Buy animals    2. Buy food   3.Sell animal    4.Feed animal    5.Breed animal     6.Save     7. Quit Game");
                int input = Integer.parseInt(scanner.nextLine());
                if (input < 1 || input > 7) {
                    System.out.println("Choice between 1 - 7");
                } else {


                    switch (input) {
                        case 1:
                            store.animalToBuy(player);
                            System.out.println(getIndex());
                            setIndex(index += 1);
                            break;
                        case 2:
                            System.out.println(getIndex());
                            store.buyFood(player);
                            setIndex(index += 1);
                            break;
                        case 3:
                            store.saleStart(player);
                            setIndex(index += 1);
                            break;
                        case 4:
                            player.feedAnimal(player);
                             setIndex(index += 1);
                            break;

                        case 5:
                            vet.breedingChance(player);
                            setIndex(index++);
                            break;

                        case 6:


                            System.out.println("Enter the name of the file you want to write to");
                            fileName = scanner.nextLine();
                            FileUtilities.saveGameRunTime(new SaveRunTimeGame(this), fileName);
                            setIndex(index += 1);
                            break;

                        case 7:
                            System.out.println("Do you want to exit the game?"); // todo, choice to make;
                            System.exit(0);

                        default:
                            System.out.println(" Incorrect input ");
                    }
                }


            }


        }
    }

     //   }


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

        public void setAmountRounds(int amountRounds) {
        this.amountRounds = amountRounds;
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







        }



























