package GameController;

import Animals.*;
import Food.Food;
import Food.Meat;
import Food.MixFood;
import Food.Veggies;
import Game.*;
import Resources.Store;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class GameLogic {
    Scanner console = new Scanner(System.in);

    private ArrayList<Player> playerList;

    Store store = new Store();
    private int playerAmount;
    int playerShoppingInput;
    int setGender;


    public GameLogic(){

        this.playerList = new ArrayList<>();
        startGame();
    }

    // This method for player's choice how many rounds they want to play.  5- 30 rounds with do-while loop.
    public void startGame(){

        System.out.println("Welcome to the Animal Game!");
        System.out.println();

        int spin = 0;
        System.out.println("How many rounds do you want to play? ");
        int input = Integer.parseInt(console.nextLine());
        if (input < 5 || input > 30){
            System.out.println("Between 5 - 30 rounds.");
            startGame();
        } else {
            do {
                askAmountPlayers();


                spin++;
            }while (spin<= input );
        }
    }

    private void askAmountPlayers(){
        // This method ask for how many players are going to play.
        do {
            System.out.println("How many players do you want to play? ");
            playerAmount = Integer.parseInt(console.nextLine());
            if (playerAmount < 2 || playerAmount > 4) {
                System.out.println(" Must be Between 2 - 4 players");
            }
        } while (playerAmount <2 || playerAmount > 4);
        addPlayer();

    }

    // This method is for adding players to the list
    // Players can input names without having duplicate names.
    public void addPlayer() {
        int i = 1;
        do {
            System.out.println("Enter player" + i + "name");
             String name = console.nextLine();
            if (hasThisName(playerList, name)) {
                System.out.println("You cant take this name");
                continue;
            }
            playerList.add(new Player(name));
            i++;
        } while (i <= playerAmount);
        playerChoice();

        // This method is checking if player's name already exist.
    }
    public boolean hasThisName(ArrayList<Player> playerList, String givenName){
        for (Player player : playerList){
            if (player.getName().equalsIgnoreCase(givenName)){
                return true;
            }
        }
        return false;

    }

    // prints player's choice.
    //Case 1 - Buy animal / Set gender.
    public void playerChoice(){

        System.out.println("Welcome to the game");
        System.out.println("What do you want to do?");
        System.out.println("1. ");


    }



    // prints animals to buy and price for players.
    public void buyAnimalsChoice(){





    }

    // INCOMPLETE method for picking which animal to feed.
    public void feedAnimal(){
        System.out.println("Which animal do you want to feed? ");


    }
    // Prints foods to buy and price for players
    public void buyFoodChoice(){
        System.out.println("What food do you want to buy?");
        System.out.println("1. Meat "+"   ( "+store.getMeatPrice()+" Coins)\n"+
                "2. Mixfood " +"( "+store.getMixFoodPrice()+" Coins )\n"+
                "3. Veggies "+"( "+store.getVeggiesPrice()+" Coins )");
    }
    public void setGenderChoice(){
        System.out.println("Välj kön: 1. Male 2. Female");
    }


}










