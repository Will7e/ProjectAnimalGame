package GameController;

import Resourses.Store;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class GameLogic {
    Scanner scanner = new Scanner(System.in);
    public ArrayList<Player> playerList;
    protected Store store;
    private int playerAmount;
    int round = 1;
    int i;


    // konstruktorn
    public GameLogic() {
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
            System.out.println("Enter player" + i + "name");
            String name = scanner.nextLine();
            if (hasThisName(playerList, name)) {
                System.out.println("You cant take this name");
                continue;
            }
            playerList.add(new Player(name));
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
            System.out.println("Round : " + i);
            System.out.println("Player :" + player.getName());
            System.out.println("What do you want to buy?");
            System.out.println("1. Buy animals    2. Buy food   3. Feed animal");
            int input = scanner.nextInt();
            if (input < 1 || input > 3) {
                System.out.println("Choice between 1 - 3");
            } else {
                switch (input) {
                    case 1:
                        store.animalToBuy(player);
                        break;
                    case 2:
                        store.buyFood(player);
                        break;
                    case 3:
                    default:
                        System.out.println(" Incorrect input");
                }
            }
        }
    }
}














