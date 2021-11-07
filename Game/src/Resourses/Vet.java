package Resourses;

import Animals.Animal;
import gamecontroller.Player;

import java.util.Random;
import java.util.Scanner;


public class Vet {

    private int index1;
    private int index2;
    private String name1;
    private String name2;
    Scanner console = new Scanner(System.in);
    Random ran;

    public Vet() {

        this.name1 = name1;
        this.name2 = name2;

        ran = new Random();

    }

    public void breedingChance(Player player) {

        System.out.println("Checking if nature will allow your animals to breed...");
        // todo, input wait.
        int random = ran.nextInt(2);

        if (random == 0) {
            System.out.println("Sorry, nature say that the baby factory is closed");
        } else {

            checkAnimalAmount(player);

        }
    }


    public void checkAnimalAmount(Player player) {

        if (player.getAnimalList().size() == 0 || player.getAnimalList().size() == 1) {
            System.out.println("Even if nature allows it, you have to get more animals to be able to breed");

        } else {
            showAnimals(player);
        }
    }


    public void showAnimals(Player player) {

        System.out.println("Here is a list of your animals:  " + player.getName());
        for (int i = 0; i < player.getAnimalList().size(); i++) {
            System.out.println(" [Number] " + i + " [Name] " + player.getAnimalList().get(i).getName() + " [Gender] " +
                    player.getAnimalList().get(i).getGender() + " [Race] " +
                    player.getAnimalList().get(i).getClassName());
        }
        selectAnimal(player);
    }


    public void selectAnimal(Player player) {

        // todo, animals cant have the same name when start the game.
        boolean firstAnimalFound = false;
        boolean secondAnimalFound = false;
        System.out.println("Enter the name of the first animal you want to breed");
        name1 = console.nextLine();



        for (int i = 0; i < player.getAnimalList().size(); i++) {

            if (player.getAnimalList().get(i).getName().equalsIgnoreCase(name1)) {
                index1 = i;
                firstAnimalFound = true;
                break;
            }

        }

        if (!firstAnimalFound) {
            System.out.println("Animal doesnt exist, please try again");
            selectAnimal(player);

        }


        System.out.println("Enter the name of the second animal you want to breed");

        name2 = console.nextLine();

        for (int i = 0; i < player.getAnimalList().size(); i++) {

            if (player.getAnimalList().get(i).getName().equalsIgnoreCase(name2)) {
                index2 = i;
                secondAnimalFound = true;

                break;
            }

        }

        if (!secondAnimalFound) {
            System.out.println("Animal doesnt exist, please try again");
            selectAnimal(player);
        }

        checkAnimalsMatch(player);

    }

    public void checkAnimalsMatch(Player player) {


        if (player.getAnimalList().get(index1).getClassName().equalsIgnoreCase(player.getAnimalList().get(index2).getClassName())) {
            System.out.println("The animal are the same race");
            checkGender(player);
        }

        else {
            System.out.println("Animals arent the same Race, try again");

        }

    }

    public void checkGender(Player player) {
        if (player.getAnimalList().get(index1).getGender() != player.getAnimalList().get(index2).getGender()) {

            System.out.println("The animals are different gender, lets breed");

        }

        else {
            System.out.println("Cant mate, same sex, please try again");
        }
    }
         }








