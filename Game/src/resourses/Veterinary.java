package resourses;

import animals.*;
import gamecontroller.FormatHelp;
import gamecontroller.Player;

import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

/**
 * This is the class where we create for animal to breed with each other. In this we have difference method and logic
 * that if player have animals so he/she can breed to get more of those animals.
 *
 * @author William, Marcus, Ridah
 */

public class Veterinary  implements Serializable {
    private Scanner console; // Scanner for player's input
    private Random random; // Randomize chances of animals breed and gender
    private Store store; // To use a method that exist in Store class.
    private int index1; // To retrieve the index of animal to breed
    private int index2;// To retrieve the index of second animal to breed
    private char gender; // To store gender as Character.
    private String name; // store name.
    private String animalName; // store animal name to compare within the arraylist.
    private boolean backToMenu; // For player to return to main menu if he/she types in wrong.

    /**
     * Constructor for this class.
     */
    public Veterinary() {
        this.console = new Scanner(System.in); // Initialize Scanner.
        this.random = new Random();// Initialize Random.
        this.store = new Store();// Initialize Store.
    }

    /**
     * This method we create to get the gender that randomize when animals success breed.
     * @return M or F as gender.
     */
    public char randomGender() {
        if (random.nextBoolean()) {
            return 'M';
        }
        return 'F';
    }

    /**
     * This method prints if animals success breed. As message to let player knows.
     */
    public void successMessage() {
        System.out.println("[Name : " + name + "]\n" +
                "[Gender: " + gender + "]");
    }


    /**
     * This method check if the name of animal player types in is correct or exist in his animal list.
     * @param player who types in.
     * @return index of the animal that is existed in his animal list.
     */
    public int checkFirstAnimal(Player player) {
        System.out.println("(1).Type in animal name you want to breed.");
        animalName = console.nextLine();
        for (int i = 0; i < player.getAnimalList().size(); i++) {
            if (player.getAnimalList().get(i).getName().equalsIgnoreCase(animalName)) {
                index1 = i;
            }
        }
        if (!player.getAnimalList().get(index1).getName().equalsIgnoreCase(animalName)) {
            System.out.println(animalName + " does not exist in animal list.");
            checkFirstAnimal(player);
        }
        return index1;
    }

    /**
     * This method check if the name of animal player types in is correct or exist in his animal list.
     * @param player who types in.
     * @return index of the animal that is existed in his animal list.
     */
    public int checkSecondAnimal(Player player) {
        System.out.println("(2).Type in animal name you want to breed with [" + animalName +"].");
        String animalName2 = console.nextLine();
        for (int i = 0; i < player.getAnimalList().size(); i++) {
            if (player.getAnimalList().get(i).getName().equalsIgnoreCase(animalName2)) {
                index2 = i;
            }
        }
        if (!player.getAnimalList().get(index2).getName().equalsIgnoreCase(animalName2)) {
            System.out.println(animalName2 + " does not exist in animal list.");
            checkSecondAnimal(player);
        }
        return index2;
    }


    /**
     * This method is the logic behind breed animal as whole. It checks possibility of those animal that player types in.
     * It randomizes the chances of any to have baby as 50/50. If success this adds those new animals to player animal list.
     * @param player that choose to breed animal.
     */
    public void animalBreeding(Player player) {
        if (player.getAnimalList().isEmpty() || player.getAnimalList().size() < 2) {
            System.out.println("You don't have enough animal in your list");
            System.out.println("Return to main menu...");
            backToMenu= true;
            FormatHelp.threadSleep();
            FormatHelp.emptyScreen();

        } else {
            printAnimalList(player);
            checkFirstAnimal(player);
            checkSecondAnimal(player);
            if (!player.getAnimalList().get(index1).getClassName().equalsIgnoreCase(player.getAnimalList().get(index2).getClassName())) {
                System.out.println("Animal need to be same race.");
                System.out.println();
                System.out.println("Return to main menu...");
                backToMenu = true;
            }
            if (player.getAnimalList().get(index1).getGender() == player.getAnimalList().get(index2).getGender()) {
                System.out.println("Animal can't have same gender.");
                System.out.println();
                System.out.println("Return to main menu...");
                FormatHelp.threadSleep();
                FormatHelp.emptyScreen();
                backToMenu = true;
            } else {
                if (random.nextBoolean()) {
                    for (int i = 0; i < player.getAnimalList().size(); i++) {
                        if (player.getAnimalList().get(index1).getClassName().equalsIgnoreCase("Bear")) {
                            System.out.println("Congrats! You succeed with Bear's breeding.");
                            gender = randomGender();
                            name = giveAnimalName(player);
                            player.getAnimalList().add(new Bear(name, gender));
                            successMessage();
                            break;
                        }
                        if (player.getAnimalList().get(index1).getClassName().equalsIgnoreCase("Dog")) {
                            System.out.println("Congrats! You succeed with Dog's breeding. You now get 2 dogs.");
                            for (int j = 0; j < 2; j++) {
                                System.out.println("Dog: " + (j+1));
                                gender = randomGender();
                                name = giveAnimalName(player);
                                player.getAnimalList().add(new Dog(name, gender));
                                successMessage();
                            }
                            break;
                        }
                        if (player.getAnimalList().get(index1).getClassName().equalsIgnoreCase("Horse")) {
                            System.out.println("Congrats! You succeed with Horse's breeding.");
                            gender = randomGender();
                            name = giveAnimalName(player);
                            player.getAnimalList().add(new Horse(name, gender));
                            successMessage();
                            break;
                        }
                        if (player.getAnimalList().get(index1).getClassName().equalsIgnoreCase("Lion")) {
                            System.out.println("Congrats! You succeed with Lion's breeding.");
                            gender = randomGender();
                            name = giveAnimalName(player);
                            player.getAnimalList().add(new Lion(name, gender));
                            successMessage();
                            break;
                        }
                        if (player.getAnimalList().get(index1).getClassName().equalsIgnoreCase("Rabbit")) {
                            System.out.println("Congrats! You succeed with Rabbit's breeding. You now get 4 rabbits.");
                            for (int j = 0; j < 4; j++) {
                                System.out.println("Rabbit: " + (j+1));
                                gender = randomGender();
                                name = giveAnimalName(player);
                                player.getAnimalList().add(new Rabbit(name, gender));
                                successMessage();
                            }
                            System.out.println("Animals succeeded add to your bag.");
                            break;
                        }

                    }
                } else {
                    System.out.println("Breeding failed. Good luck next time");
                    System.out.println();
                    backToMenu = false;
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    /**
     * This method let player name animal that he/she successes to breed.
     * @param player that success the breed and name animal.
     * @return animal's name
     */
    public String giveAnimalName(Player player) {
        System.out.print("Name your animal: ");
        name = console.nextLine();
        if (store.hasThisName(player.getAnimalList(), name)) {
            System.out.println("This name already exist. Choose another name. ");
            return giveAnimalName(player);
        }
        return name;
    }

    /**
     * This method prints animal list for player to know what animals he/she has.
     * @param player that choose to breed animal.
     */
    public void printAnimalList(Player player) {
        System.out.println("Your animal list: ");
        for (Animal animal : player.getAnimalList()) {
            System.out.println("[Type: " + animal.getClassName() + "] [Name: " + animal.getName() + "] [Gender: " + Character.toUpperCase(animal.getGender())  + "]");
        }
    }

    /**
     * This method is to call from GameLogic for recursion of return to main menu
     * @return boolean as true or false.
     */
    public boolean getBackToMenu() {
        return this.backToMenu;
    }

}



