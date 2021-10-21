package GameController;

import Resourses.Store;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    public ArrayList<Player> playerList;
    protected Store store;
    private int playerAmount;
    int i;
    // konstruktorn
    public Game() {
        store = new Store();
        this.playerList = new ArrayList<>();
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
            System.out.println("[Round: " + i+"]");
            System.out.println("Player: " + player.getName() +
                    "\nCoins: " + player.getCoins());
            System.out.println("---------------");
            player.printAnimal(player);
            System.out.println("---------------");
            player.printFood(player);
            System.out.println();
            System.out.println("What do you want to do? [Player: "+ player.getName()+"] | [Round: "+i+"] |["+ player.getCoins()+" Coins]");
            System.out.println("1. Buy animals    2. Buy food   3.Sell animal    4.Feed animal    5.Breed animal     6.Save & Quit");
            int input = scanner.nextInt();
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
                    case 4:player.feedAnimal(player);
                    break;
                    default:
                        System.out.println(" Incorrect input ");
                }
            }
        }
    }
}













