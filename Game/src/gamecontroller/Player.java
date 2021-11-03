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
    transient Scanner console = new Scanner(System.in);
    private String name;
    protected int playerCoins = 100;
    private ArrayList<Animal> animalList; // ArrayList
    private ArrayList<Food> foodList; // ArrayList, use size() to retrieve total amount of ...
    private Store store;

    public Player(String name) {
        this.store = new Store();
        this.name = name;
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

    // Prints out list of animal that player own.
    public void printAnimal(Player player) {
        System.out.println("Animal list:");
        if (animalList.isEmpty()) {
            System.out.println("[Empty]");
        } else {
            for (Animal animal : animalList) {
                if (animal.getHealth() == 0){
                    System.out.println("Your animal is death! ");
                    System.out.println("[Your ["+animal.getName()+"]. Health: "+ animal.getHealth() +
                            " .Have been remove.");
                    animalList.remove(animal);
                    animalInfo(animal);

                }
                    if (animal.getAge() == animal.getMaxAge()){
                        System.out.println("Your ["+ animal.getClassName()+ "] is death! ");
                        System.out.println("[Type: "+animal.getClassName()+ "] [Name: "+animal.getName()+"] [Age: "+ animal.getAge()+
                                "] is no longer in your animal list.");
                        animalList.remove(animal);
                        animalInfo(animal);

                    }
                if (animalList.isEmpty()) {
                    System.out.println("-".repeat(5));
                    System.out.println("[Empty]");

                }
                animalInfo(animal);
                }
            }
        }
    // Prints out list of players food and amounts.
    public void printFood(Player player) {
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
                if (food.getName().equalsIgnoreCase("MixFood")) {
                    countMeat += 1;
                }
            }
            System.out.println("---------------");
            System.out.println("Meat : " + countMeat + " / Kilos\n" +
                    "Veggies: " + countVeggies + " / Kilos\n" +
                    "MixFood: " + countMixFood + " / Kilos");
        }
    }

    // Player choice to feed the animal
    public void feedAnimal(Player player) {
        if (foodList.isEmpty()) {
            System.out.println("You don't have any food, please come back after you buy some more");
            System.out.println("Next players turn, back to menu...");
            FormatHelp.threadSleep();
            FormatHelp.emptyScreen();

        } else if(player.getAnimalList().size() == 0) {
            System.out.println("You dont own any animals to feed");
            System.out.println("Please come back after you bought some animals");
            System.out.println("Next players turn, back to menu...");
            FormatHelp.threadSleep();
            FormatHelp.emptyScreen();



        } else {
            checkAnimal(player);
        }
    }
    public void checkAnimal(Player player) {
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
                    break;
                }
            } else {
                System.out.println("Name not found. Type again.");
                checkAnimal(player);
            }
        }
    }
    public void animalInfo(Animal animal){
        System.out.println("---------------");
        System.out.println("Type [" + animal.getClassName() + "]\n[Name: " + animal.getName() + "]" +
                "[Age: "+ animal.getAge()+"] [Gender: " + animal.getGender() + " )" + "] " +
                "[Health: " + animal.getHealth() + "]");

    }


    }



