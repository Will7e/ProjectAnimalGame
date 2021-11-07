package gamecontroller;

import animals.*;
import resourses.Store;

import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

public class Veterinaryimplements Serializable {
    private Scanner console;
    private Random random;
    private Store store;
    private int index1;
    private int index2;
    private char gender;
    private String name;
    String animalName;
    private boolean backToMenu;

    public Veterinary() {
        this.console = new Scanner(System.in);
        this.random = new Random();
        this.store = new Store();
    }

    public char randomGender() {
        if (random.nextBoolean()) {
            return 'M';
        }
        return 'F';
    }

    public void successMessage() {
        System.out.println("[Name : " + name + "]\n" +
                "[Gender: " + gender + "]");
    }

    public int checkAnimal(Player player) {
        System.out.println("(1).Type in animal name you want to breed.");
        animalName = console.nextLine();
        for (int i = 0; i < player.getAnimalList().size(); i++) {
            if (player.getAnimalList().get(i).getName().equalsIgnoreCase(animalName)) {
                index1 = i;
            }
        }
        if (!player.getAnimalList().get(index1).getName().equalsIgnoreCase(animalName)) {
            System.out.println(animalName + " does not exist in animal list.");
            checkAnimal(player);
        }
        return index1;
    }

    public int checkAnimal2(Player player) {
        System.out.println("(2).Type in animal name you want to breed with [" + animalName +"].");
        String animalName2 = console.nextLine();
        for (int i = 0; i < player.getAnimalList().size(); i++) {
            if (player.getAnimalList().get(i).getName().equalsIgnoreCase(animalName2)) {
                index2 = i;
            }
        }
        if (!player.getAnimalList().get(index2).getName().equalsIgnoreCase(animalName2)) {
            System.out.println(animalName2 + " does not exist in animal list.");
            checkAnimal2(player);
        }
        return index2;
    }

    public void breedAnimal(Player player) {
        if (player.getAnimalList().isEmpty() || player.getAnimalList().size() < 2) {
            System.out.println("You don't have enough animal in your list");
            System.out.println("Return to main menu...");
            backToMenu= true;
            setBackToMenu(true);
            FormatHelp.threadSleep();
            FormatHelp.emptyScreen();


        } else {
            printAnimalList(player);
            checkAnimal(player);
            checkAnimal2(player);
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
                return;
            } else {
                if (random.nextBoolean()) {
                    for (int i = 0; i < player.getAnimalList().size(); i++) {
                        if (player.getAnimalList().get(index1).getClassName().equalsIgnoreCase("Bear")) {
                            System.out.println("Congrats! You succeed with Bear's breeding.");
                            gender = randomGender();
                            name = nameAnimal(player);
                            player.getAnimalList().add(new Bear(name, gender));
                            successMessage();
                            break;
                        }
                        if (player.getAnimalList().get(index1).getClassName().equalsIgnoreCase("Dog")) {
                            System.out.println("Congrats! You succeed with Dog's breeding. You now get 2 dogs.");
                            for (int j = 0; j < 2; j++) {
                                System.out.println("Dog: " + (j+1));
                                gender = randomGender();
                                name = nameAnimal(player);
                                player.getAnimalList().add(new Dog(name, gender));
                                successMessage();
                            }
                            break;
                        }
                        if (player.getAnimalList().get(index1).getClassName().equalsIgnoreCase("Horse")) {
                            System.out.println("Congrats! You succeed with Horse's breeding.");
                            gender = randomGender();
                            name = nameAnimal(player);
                            player.getAnimalList().add(new Horse(name, gender));
                            successMessage();
                            break;
                        }
                        if (player.getAnimalList().get(index1).getClassName().equalsIgnoreCase("Lion")) {
                            System.out.println("Congrats! You succeed with Lion's breeding.");
                            gender = randomGender();
                            name = nameAnimal(player);
                            player.getAnimalList().add(new Lion(name, gender));
                            successMessage();
                            break;
                        }
                        if (player.getAnimalList().get(index1).getClassName().equalsIgnoreCase("Rabbit")) {
                            System.out.println("Congrats! You succeed with Rabbit's breeding. You now get 4 rabbits.");
                            for (int j = 0; j < 4; j++) {
                                System.out.println("Rabbit: " + (j+1));
                                gender = randomGender();
                                name = nameAnimal(player);
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

    public String nameAnimal(Player player) {
        System.out.print("Name your animal: ");
        name = console.nextLine();
        if (store.hasThisName(player.getAnimalList(), name)) {
            System.out.println("This name already exist. Choose another name. ");
            return nameAnimal(player);
        }
        return name;
    }

    public void printAnimalList(Player player) {
        System.out.println("Your animal list: ");
        for (Animal animal : player.getAnimalList()) {
            System.out.println("[Type: " + animal.getClassName() + "] [Name: " + animal.getName() + "] [Gender: " + animal.getGender() + "]");
        }
    }

    public void setBackToMenu(boolean backToMenu) {
        this.backToMenu = backToMenu;
    }

    public boolean getBackToMenu() {
        return this.backToMenu;
    }

}



