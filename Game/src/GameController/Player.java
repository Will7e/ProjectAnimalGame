package GameController;


import Animals.Animal;
import Food.Food;

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
    transient Scanner console = new Scanner(System.in);
    private String name;
    private int playerCoins = 100;
    private ArrayList<Animal> animalList; // ArrayList
    private ArrayList<Food> foodList; // ArrayList, use size() to retrieve total amount of ...


    public Player(String name) {
        this.name = name;
        this.animalList = new ArrayList<>();
        this.foodList = new ArrayList<>();
        this.playerCoins = playerCoins;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoins() {
        return this.playerCoins;
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

    // Prints out list of animal that player own.
    public void printAnimal(Player player) {
        System.out.println("Animal list:");
        if (animalList.isEmpty()) {
            System.out.println("[Empty]");
        } else {
            for (Animal animal : animalList) {
                System.out.println("---------------");
                System.out.println("Type [" + animal.getClassName() + "]\n[Name: " + animal.getName() + "]" +
                        "\n[Gender:( " + animal.getGender() + " )" + "]\n[Health: " + animal.getHealth() + "]");
                System.out.println("---------------");
            }
        }
    }

    // Prints out list of players food and amounts.
    public void printFood(Player player) {
        System.out.println("Food list:");
        if (foodList.isEmpty()) {
            System.out.println("---------------");
            System.out.println("[Empty]");
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
                if (food.getName().equalsIgnoreCase("MixFood")) {
                    countMeat += 1;
                }
            }
            System.out.println("---------------");
            System.out.println("Meat : " + countMeat + " / Kilos\n" +
                    "Veggies: " + countVeggies + " / Kilos\n" +
                    "MixFood: " + countMixFood + " / Kilos");
            System.out.println("---------------");
        }
    }
// Player choice to feed the animal 
    public void feedAnimal(Player player) {
        if (foodList.isEmpty()) {
            System.out.println("You don't have food");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Type in the name of animal you want to feed.");
            printAnimal(player);
            String animalName = console.nextLine();
            for (int i = 0; i < animalList.size(); i++) {
                if (animalName.equalsIgnoreCase(animalList.get(i).getName())) {
                    System.out.println("Type in name of the food you want to feed animal.");
                    System.out.println("[Meat]    [Veggies]    [Mix Food]");
                    String food = console.nextLine();
                    for (int j = 0; j < foodList.size(); j++) {
                        if (food.equalsIgnoreCase(foodList.get(i).getName())) {
                            animalList.get(i).eatFood(foodList.get(i));
                            foodList.remove(foodList.get(i));
                        }
                    }
                } else {
                    System.out.println("Animal not found. Type again.");
                }
            }
        }
    }
}


