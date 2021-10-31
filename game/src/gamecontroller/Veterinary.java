package gamecontroller;

import animals.*;
import resourses.Store;

import java.util.Random;
import java.util.Scanner;

public class Veterinary {
    private Scanner console;
    private Random random;
    private Store store;
    private int i1;
    private int i2;
    private char gender;
    private String name;
    String animalName;


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
                "[Gender: " + gender + "]\n" +
                " has succeeded add to your bag.");
    }

    public int checkAnimal(Player player) {
        System.out.println("(1).Type in animal name you want to breed.");
        animalName = console.nextLine();
        for (int i = 0; i < player.getAnimalList().size(); i++) {
            if (player.getAnimalList().get(i).getName().equalsIgnoreCase(animalName)) {
                i1 = i;
            }
        }
        if (!player.getAnimalList().get(i1).getName().equalsIgnoreCase(animalName)) {
            System.out.println(animalName + " does not exist in animal list.");
            checkAnimal(player);
        }
        return i1;
    }

    public int checkAnimal2(Player player) {
        System.out.println("(2).Type in animal name you want to breed with [" + animalName +"].");
        String animalName2 = console.nextLine();
        for (int i = 0; i < player.getAnimalList().size(); i++) {
            if (player.getAnimalList().get(i).getName().equalsIgnoreCase(animalName2)) {
                i2 = i;
            }
        }
        if (!player.getAnimalList().get(i2).getName().equalsIgnoreCase(animalName2)) {
            System.out.println(animalName2 + " does not exist in animal list.");
            checkAnimal2(player);
        }
        return i2;
    }

    public void breedAnimal(Player player) {
        if (player.getAnimalList().isEmpty() || player.getAnimalList().size() < 2) {
            System.out.println("You don't have enough animal in your list");
            Game.playerInfos();
        } else {
            printAnimalList(player);
            checkAnimal(player);
            checkAnimal2(player);
            if (!player.getAnimalList().get(i1).getClassName().equalsIgnoreCase(player.getAnimalList().get(i2).getClassName())) {
                System.out.println("Animal need to be same race.");
            }
            if (player.getAnimalList().get(i1).getGender() == player.getAnimalList().get(i2).getGender()) {
                System.out.println("Animal cant have same gender.");
            } else {
                if (random.nextBoolean()) {
                    for (int i = 0; i < player.getAnimalList().size(); i++) {
                        if (player.getAnimalList().get(i1).getClassName().equalsIgnoreCase("Bear")) {
                            System.out.println("Congrats you succeed with bear breeding.");
                            gender = randomGender();
                            name = nameAnimal(player);
                            player.getAnimalList().add(new Bear(name, gender));
                            successMessage();
                            break;
                        }
                        if (player.getAnimalList().get(i1).getClassName().equalsIgnoreCase("Dog")) {
                            System.out.println("Congrats you succeed with dog breeding. You now get 2 dogs.");
                            for (int j = 0; j < 2; j++) {
                                gender = randomGender();
                                name = nameAnimal(player);
                                player.getAnimalList().add(new Dog(name, gender));
                                successMessage();
                            }
                            break;
                        }
                        if (player.getAnimalList().get(i1).getClassName().equalsIgnoreCase("Horse")) {
                            System.out.println("Congrats you succeed with horse breeding.");
                            gender = randomGender();
                            name = nameAnimal(player);
                            player.getAnimalList().add(new Horse(name, gender));
                            successMessage();
                            break;
                        }
                        if (player.getAnimalList().get(i1).getClassName().equalsIgnoreCase("Lion")) {
                            gender = randomGender();
                            name = nameAnimal(player);
                            player.getAnimalList().add(new Lion(name, gender));
                            successMessage();
                            break;
                        }
                        if (player.getAnimalList().get(i1).getClassName().equalsIgnoreCase("Rabbit")) {
                            System.out.println("Congrats you succeed with rabbit breeding. You now get 4 rabbits");
                            for (int j = 0; j < 4; j++) {
                                gender = randomGender();
                                name = nameAnimal(player);
                                player.getAnimalList().add(new Rabbit(name, gender));
                                successMessage();
                            }
                            break;
                        }
                    }
                } else {
                    System.out.println("Sorry breeding failed.Good luck next time");
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
}



