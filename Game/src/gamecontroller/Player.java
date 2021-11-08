package gamecontroller;


import animals.*;
import food.Food;
import resourses.Store;

import java.io.Serializable;
import java.util.*;

/**
 * The player should be able to store his money, his owned animals and the food he/she owns.
 * The player should also have a name.
 *
 * @author william, ridah, marcus
 */
public class Player implements Serializable {
    transient private Scanner console;
    private String name;
    protected int playerCoins = 100;
    private ArrayList<Animal> animalList; // ArrayList
    private ArrayList<Food> foodList; // ArrayList, use size() to retrieve total amount of ...
    private Store store;
    public static boolean backToMenu;
    int index;
    String animalName;

    public Player(String name) {
        this.store = new Store();
        this.name = name;
        console = new Scanner(System.in);
        this.animalList = new ArrayList<>();
        this.foodList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoins() {
        return playerCoins;
    }

    public void setCoins(int playerCoins) {
        this.playerCoins = playerCoins;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    // Prints out list of players food and amounts.
    public void printFood() {
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

    // Player choice to feed the animal
    public void feedAnimal(Player player, Scanner scanner) {
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

        }else {
            checkAnimal(player, scanner);
        }
    }


    public void checkAnimal(Player player, Scanner scan) {
        animalInfo(player);
        System.out.println("Type in the name of animal you want to feed.");
        animalName = scan.nextLine();
        for (int i = 0; i < player.getAnimalList().size(); i++) {
            index = i;
            if (player.getAnimalList().get(i).getName().equalsIgnoreCase(animalName)){
                System.out.println("Remember:\n Bear, Lion [Meat] |Horse,Rabbit [Veggies] | Dog [Mixfood] ");
                System.out.println("-".repeat(15));
                System.out.println("Type in name of the food you want to feed animal.");
                System.out.println("[Meat]    [Veggies]    [Mixfood]");
                String food = scan.nextLine();
                for (int j = 0; j < player.getFoodList().size(); j++) {
                    if (food.equalsIgnoreCase(player.getFoodList().get(j).getName())) {
                        player.getAnimalList().get(i).eatFood(player.getFoodList().get(j));
                        if (Animal.eatSuccess){
                            player.getFoodList().remove(player.getFoodList().get(j));
                            backToMenu = false;
                            break;
                        }else {
                            backToMenu = true;
                            break;
                        }

                    }
                    else if (!food.equalsIgnoreCase(player.getFoodList().get(j).getName())){
                        System.out.println("Wrong type of food for animal.\nReturn to main menu...");
                        backToMenu = true;
                        FormatHelp.threadSleep();
                        FormatHelp.emptyScreen();
                        break;
                    }
                }
                break;
            }
        } if (!player.animalList.get(index).getName().equalsIgnoreCase(animalName)){
            System.out.println("Name not found. Type again...");
            backToMenu = true;
            FormatHelp.threadSleep();
            FormatHelp.emptyScreen();

        }

    }

    public void animalInfo(Player player) {
        System.out.println("Animal list: ");
        if (animalList.isEmpty()) {
            System.out.println("[Empty]");
        }
        backToMenu = true;
        for (int i = 0; i < player.getAnimalList().size(); i++) {
            System.out.println("-".repeat(15));
            System.out.println("Type [" + player.getAnimalList().get(i).getClassName() + "]\n[Name: " + player.getAnimalList().get(i).getName() + "]" +
                    "[Age: " + player.getAnimalList().get(i).getAge() + "] [Gender: " + player.getAnimalList().get(i).getGender() + " )" + "] " +
                    "[Health: " + player.getAnimalList().get(i).getHealth() + "]");

            if (player.getAnimalList().get(i).getAge() == player.getAnimalList().get(i).getMaxAge() ) {
                System.out.println("Animal is dead. Cause: Reached max age.");
                player.getAnimalList().remove(player.getAnimalList().get(i));
                i--;
            } else if (player.getAnimalList().get(i).getHealth() <= 0 ){
                System.out.println("Animal is dead. Cause: Health reached 0.");
                player.getAnimalList().remove(player.getAnimalList().get(i));
                i--;
            }
                else {
                backToMenu = true;
            }
        }
    }
    public static boolean getBackToMenu() {
        return backToMenu;
    }

}



