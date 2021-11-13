package gamecontroller;


import animals.Animal;
import food.Food;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The player should be able to store his money, his owned animals and the food he/she owns.
 * The player should also have a name.
 *
 * @author william, ridah, marcus
 */
public class Player implements Serializable {
    private String name; // Player's name
    protected int playerCoins = 500;
    private ArrayList<Animal> animalList; // ArrayList, use size() to retrieve total amount of animal
    private ArrayList<Food> foodList; // ArrayList, use size() to retrieve total amount of food
    public boolean backToMenu;
    int index;
    protected String animalName;

    /**
     * Constructor of player class.
     * @param name field variable for player
     *             Instantiating class "Store" in constructor
     */
    public Player(String name) {
        this.name = name;
        this.animalList = new ArrayList<>();
        this.foodList = new ArrayList<>();
    }

    /**
     * Getter for player's name.
     * @return player's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for player's coins.
     * @return coins that player owns.
     */
    public int getCoins() {
        return playerCoins;
    }


    /**
     * Setter for player's coin
     * @param playerCoins
     */
    public void setCoins(int playerCoins) {
        this.playerCoins = playerCoins;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    /**
     * Getter for foodList.
     * @return food list.
     */
    public List<Food> getFoodList() {
        return foodList;
    }

    /**
     * This method prints out list of a players food and the amount of food.
     */
    public void printFoodOwn() {
        System.out.println("Food list:");
        if (foodList.isEmpty()) {
            System.out.println("--------------- \n[Empty]");
        } else {
            int countMeat = 0;
            int countVeggies = 0;
            int countMixFood = 0;
            for (Food food : foodList) {
                if (food.getName().equalsIgnoreCase("Meat")) {
                    countMeat += 1;
                }
                if (food.getName().equalsIgnoreCase("Veggies")) {
                    countVeggies += 1;
                }
                if (food.getName().equalsIgnoreCase("Mixfood")) {
                    countMixFood += 1;
                }
            }
            System.out.println("---------------");
            System.out.println("Meat : " + countMeat + " / Kilos\n" +
                    "Veggies: " + countVeggies + " / Kilos\n" +
                    "Mixfood: " + countMixFood + " / Kilos");
        }
    }

    /**
     * Checks if food available, if correct food and if animals are available to feed
     *
     * @param player  choose to feed animal.
     * @param scanner reads user choice of what food to feed animal
     */
    public void checkAnimalToFeed(Player player, Scanner scanner) {
        if (foodList.isEmpty()) {
            System.out.println("You don't have any food, please come back after you buy some more");
            System.out.println("Return to main menu...");
            backToMenu = true;
            FormatHelp.threadSleep();
            FormatHelp.emptyScreen();

        } else if (player.getAnimalList().size() == 0) {
            System.out.println("You don't own any animal.\nCome back after you've bought some animals\nReturn to main menu...");
            backToMenu = true;
            FormatHelp.threadSleep();
            FormatHelp.emptyScreen();

        } else {
            feedAnimal(player, scanner);
        }
    }


    /**
     * This method let player types in name he/she wants to feed. Then checks if that animal exist in his/her animal list.
     * If correct then it let player to types in which kind of food he wants to use. If correct food animal health increase,
     * if player mistakenly type in wrong type of food for animal, he/she has the chance to do it again.
     *
     * @param player choose to feed animal.
     * @param scan  player's input.
     */
    public void feedAnimal(Player player, Scanner scan) {
        checkAnimalHealth(player);
        System.out.println("Type in the name of animal you want to feed.");
        animalName = scan.nextLine();
        for (int i = 0; i < player.animalList.size(); i++) {
            index = i;
            if (player.animalList.get(i).getName().equalsIgnoreCase(animalName)) {
                System.out.println("Reminder:\n  Bear,Lion [Meat] -:- Horse,Rabbit [Veggies] -:- Dog [Mixfood][Meat] ");
                System.out.println("-".repeat(15));
                System.out.println("Type in name of the food you want to feed animal.");
                System.out.println("[Meat]    [Veggies]    [Mixfood]");
                String food = scan.nextLine();
                for (int j = 0; j < player.foodList.size(); j++) {
                    if (food.equalsIgnoreCase(player.foodList.get(j).getName())) {
                        player.animalList.get(i).eatFood(player.foodList.get(j));
                        if (Animal.eatSuccess) {
                            player.foodList.remove(player.foodList.get(j));
                            backToMenu = false;
                        } else {
                            backToMenu = true;
                        }
                        break;
                    }
                }
                break;
            }
        }
        if (!player.animalList.get(index).getName().equalsIgnoreCase(animalName)) {
            System.out.println("Name not found. Type again...");
            backToMenu = true;
            FormatHelp.threadSleep();
            FormatHelp.emptyScreen();
        }

    }

    /**
     * Prints out players animals owned and removes if animal is too old / 0 health
     *
     * @param player takes turn.
     */
    public void checkAnimalHealth(Player player) {
        System.out.println("Animal list: ");
        if (animalList.isEmpty()) {
            System.out.println("[Empty]");
        }
        backToMenu = true;
        for (int i = 0; i < player.animalList.size(); i++) {
            System.out.println("-".repeat(15));
            System.out.println("[Type: " + player.animalList.get(i).getClassName() + "] " +
                    "[Health: - " + player.animalList.get(i).getHealthReduced() + "] [Age: + 1]" +
                    "\n[Name: " + player.animalList.get(i).getName() + "] " +
                    "[Age: " + player.animalList.get(i).getAge() + "] [Gender: " + Character.toUpperCase(player.animalList.get(i).getGender())  + " )" + "] " +
                    "[Health: " + player.animalList.get(i).getHealth() + "]\n");

            if (player.animalList.get(i).getAge() == player.animalList.get(i).getMaxAge()) {
                System.out.println("Animal is dead. Cause: Reached max age.");
                player.getAnimalList().remove(player.animalList.get(i));
                i--;
            } else if (player.animalList.get(i).getHealth() <= 0) {
                System.out.println("Animal is dead. Cause: Health reached 0.");
                player.getAnimalList().remove(player.animalList.get(i));
                i--;
            } else {
                backToMenu = true;
            }
        }
    }


    /**
     * Getter for boolean variable backToMenu.
     * @return true
     */
    public boolean getBackToMenu() {
        return backToMenu;
    }

}



