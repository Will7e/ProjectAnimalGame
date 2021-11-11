package resourses;

import animals.*;
import food.Meat;
import food.Mixfood;
import food.Veggies;
import gamecontroller.FormatHelp;
import gamecontroller.Player;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;


/**
 * This is the store class where we have prices of animals. In this class we have methods for players to buy animal,
 * buy foods and sell animals.
 * Implements Serializable for save and load game.
 *
 * @author William, Marcus, Ridah
 */


public class Store implements Serializable {
    transient Scanner console = new Scanner(System.in);
    private int dogPrice = 30; // Initialize price for animals
    private int bearPrice = 80;
    private int horsePrice = 50;
    private int lionPrice = 100;
    private int rabbitPrice = 10;
    private int meatPrice = 10;
    private int mixFoodPrice = 5;
    private int veggiesPrice = 1;
    private int input; // Player's input
    private int input2; // Player's input
    private int userInput; // Player's input
    private char gender; // Animal's gender
    private String name; // Animal's name
    private boolean backToMenu; // boolean = true;

    /**
     * This method start with calling another metod at start ( get the animalPrice method).
     * This method is using Switch case. Take in player's input as choices.
     * In this method can players choose which animal their want to buy and amount.
     * It reduces player's coins as player gets the animal he has bought.
     * @param player who chooses to buy animal.
     */
    public void animalToBuy(Player player) {
        animalPrice();
        try {
            input = Integer.parseInt(console.nextLine());
        } catch (Exception e) {
            System.out.println("Incorrect input. Enter a number.");
        }

        switch (input) {
            case 1:
                System.out.println("How many bears do you want to buy ?");
                try {
                    input2 = Integer.parseInt(console.nextLine());
                } catch (Exception e) {
                    System.out.println("Incorrect input. Enter a number.");
                    animalToBuy(player);
                    break;
                }
            {
                if (player.getCoins() < this.getBearPrice() * input2) {
                    System.out.println("Not enough coins. You only have " + player.getCoins() + " coins. Try again!");
                    FormatHelp.threadSleep();
                    FormatHelp.emptyScreen();
                    animalToBuy(player);

                } else {
                    for (int i = 1; i <= input2; i++) {
                        System.out.println("Bear: " + i);
                        name = setName(player);
                        gender = setGender();
                        player.getAnimalList().add(new Bear(name, gender));
                    }
                    player.setCoins(player.getCoins() - getBearPrice() * input2);
                    System.out.println("You've bought " + input2 + " Bear(s)!");
                    System.out.println("You have " + player.getCoins() + " coins left. ");
                    System.out.println("Next player's turn...");
                    FormatHelp.threadSleep();
                    FormatHelp.emptyScreen();


                }
                break;
            }
            case 2:
                System.out.println("How many dogs do you want to buy ?");
                try {
                    input2 = Integer.parseInt(console.nextLine());
                } catch (Exception e) {
                    System.out.println("Incorrect input. Enter a number.");
                    animalToBuy(player);
                    break;
                }
            {
                if (player.getCoins() < this.getDogPrice() * input2) {
                    System.out.println("Not enough coins. You have to only " + player.getCoins() + " coins. Try again!");
                    FormatHelp.threadSleep();
                    FormatHelp.emptyScreen();
                    animalToBuy(player);

                } else {
                    for (int i = 1; i <= input2; i++) {
                        System.out.println("Dog: " + i);
                        name = setName(player);
                        gender = setGender();
                        player.getAnimalList().add(new Dog(name, gender));
                    }
                    player.setCoins(player.getCoins() - getDogPrice() * input2);
                    System.out.println("You've bought " + input2 + " Dog(s)!");
                    System.out.println("You have " + player.getCoins() + " coins left. ");
                    backToMenu = false;
                    System.out.println("Next player's turn...");
                    FormatHelp.threadSleep();
                    FormatHelp.emptyScreen();
                }
                break;
            }
            case 3:
                System.out.println("How many horses do you want to buy ?");
                try {
                    input2 = Integer.parseInt(console.nextLine());
                } catch (Exception e) {
                    System.out.println("Incorrect input. Enter a number.");
                    animalToBuy(player);
                    break;
                }
            {
                if (player.getCoins() < this.getHorsePrice() * input2) {
                    System.out.println("Not enough coins. You have to only " + player.getCoins() + " coins. Try again!");
                    animalToBuy(player);
                } else {
                    for (int i = 1; i <= input2; i++) {
                        System.out.println("Horse: " + i);
                        name = setName(player);
                        gender = setGender();
                        player.getAnimalList().add(new Horse(name, gender));
                    }
                    player.setCoins(player.getCoins() - getHorsePrice() * input2);

                    System.out.println("You've bought " + input2 + " Horse(s)!");
                    System.out.println("You have " + player.getCoins() + " coins left. ");
                    backToMenu = false;
                    System.out.println("Next player's turn...");
                    FormatHelp.threadSleep();
                    FormatHelp.emptyScreen();

                }
                break;
            }
            case 4:
                System.out.println("How many lions do you want to buy ?");
                try {
                    input2 = Integer.parseInt(console.nextLine());
                } catch (Exception e) {
                    System.out.println("Incorrect input. Enter a number.");
                    animalToBuy(player);
                    break;
                }
            {
                if (player.getCoins() < this.getLionPrice() * input2) {
                    System.out.println("Not enough coins. You have to only " + player.getCoins() + " coins. Try again!");
                    animalToBuy(player);

                } else {
                    for (int i = 1; i <= input2; i++) {
                        System.out.println("Lion: " + i);
                        name = setName(player);
                        gender = setGender();
                        player.getAnimalList().add(new Lion(name, gender));
                    }
                    player.setCoins(player.getCoins() - getLionPrice() * input2);
                    System.out.println("You've bought " + input2 + " Lion(s)!");
                    System.out.println("You have " + player.getCoins() + " coins left. ");
                    backToMenu = false;
                    System.out.println("Next player's turn...");
                    FormatHelp.threadSleep();
                    FormatHelp.emptyScreen();
                }
                break;
            }
            case 5:
                System.out.println("How many rabbits do you want to buy ?");
                try {
                    input2 = Integer.parseInt(console.nextLine());
                } catch (Exception e) {
                    System.out.println("Incorrect input. Enter a number.");
                    animalToBuy(player);
                    break;
                }
            {
                if (player.getCoins() < this.getRabbitPrice() * input2) {
                    System.out.println("Not enough coins. You have to only " + player.getCoins() + " coins. Try again!");
                    animalToBuy(player);
                } else {
                    for (int i = 1; i <= input2; i++) {
                        System.out.println("Rabbit: " + i);
                        name = setName(player);
                        gender = setGender();
                        player.getAnimalList().add(new Rabbit(name, gender));
                    }
                    player.setCoins(player.getCoins() - getRabbitPrice() * input2);
                    System.out.println("You've bought " + input2 + " Rabbit(s)!");
                    System.out.println("You have " + player.getCoins() + " coins left. ");
                    System.out.println("Next player's turn...");
                    backToMenu = false;
                    FormatHelp.threadSleep();
                    FormatHelp.emptyScreen();
                }
                System.out.println();
                break;
            }
            case 6:
                System.out.println("Return to main menu...");
                backToMenu = true;
                FormatHelp.threadSleep();
                FormatHelp.emptyScreen();
                break;

            default:
                System.out.println();
                animalToBuy(player);
                break;
        }


    }

    /**
     * This method is ask for player's input and use it as switch case to support another method of selling animal.
     * It checks whether if player has animals to start with if not player will not be able to sell animal
     *
     * @param player who chooses to sell animal.
     */
    public void saleStart(Player player) {

        if (player.getAnimalList().size() == 0) {
            System.out.println("You don't own any animal.");
            System.out.println("Return to main menu...");
            backToMenu = true;
            FormatHelp.threadSleep();
            FormatHelp.emptyScreen();

        } else {
            System.out.println("Welcome to the Store!");
            System.out.println("Do you want to sell animals?");
            System.out.println("1. Yes. 2. No");
            try {
                userInput = Integer.parseInt(console.nextLine());
            } catch (Exception e) {
                System.out.println("Incorrect input. Enter a number.");
            }

            switch (userInput) {
                case 1:
                    getAnimalsForSale(player);
                    System.out.println("Return to main menu...");
                    backToMenu = false;
                    FormatHelp.threadSleep();
                    FormatHelp.emptyScreen();
                    break;

                case 2:
                    System.out.println("Return to main menu...");
                    backToMenu = true;
                    FormatHelp.threadSleep();
                    FormatHelp.emptyScreen();
                    break;

                default:
                    FormatHelp.threadSleep();
                    FormatHelp.emptyScreen();
                    saleStart(player);
                    break;
            }

        }
    }


    /**
     * This method prints out the animal that player current own in the list.
     *
     * @param player who chooses to sell animal.
     */
    public void getAnimalsForSale(Player player) {

        System.out.println(player.getName() + " Your animals list: ");
        for (int i = 0; i < player.getAnimalList().size(); i++) {

            System.out.println("[Name: " + player.getAnimalList().get(i).getName() + "] " +
                    "[Type: " + player.getAnimalList().get(i).getClassName() + "] " +
                    "[Value: " + player.getAnimalList().get(i).getPriceToSell() + "]");

        }

        sellAnimal(player);
    }


    /**
     * This method allow player to type in the name of animal he/she wants to sell. If the name is match with the name in
     * the list that player owns. Then the animal remove from his list, and he receives its price.
     * @param player choose to sell animal.
     */
    public void sellAnimal(Player player) {
        System.out.println("Type in the name of the animal you want to sell.");
        String playerChoice = console.nextLine();

        for (int i = 0; i < player.getAnimalList().size(); i++) {

            if (player.getAnimalList().get(i).getName().equalsIgnoreCase(playerChoice)) {
                player.setCoins(player.getCoins() + player.getAnimalList().get(i).getPriceToSell());
                System.out.println("Sale done. Your current balance: " + player.getCoins() + " coins.");
                player.getAnimalList().remove(i);

                if (player.getAnimalList().size() >= 1) {
                    sellMoreAnimals(player);
                    return;
                }
                return;

            }
        }
        System.out.println("Animal doesn't exist. Try again.");
        sellAnimal(player);
    }


    /**
     * This metod ask player if he wants to sell more animals. If yes then start the selling methods again. Else its next
     * player's turn.
     * @param player who chooses to sell animal.
     */
    public void sellMoreAnimals(Player player) {

        System.out.println("Do you want to sell more animals?");
        System.out.println("1. Yes 2. No");
        try {
            userInput = Integer.parseInt(console.nextLine());
        } catch (Exception e) {
            System.out.println("Incorrect input. Enter a number between 1 - 2.");
        }

        switch (userInput) {

            case 1:
                getAnimalsForSale(player);
                break;

            case 2:
                break;


            default:
                System.out.println("Invalid input. Choose 1 - 2.");
                sellMoreAnimals(player);

        }

    }


    /**
     * This method allow player to buy the food and the amount of it as he wants. It adds food to player's list and
     * reduces player's coins as amount he has bought.
     * @param player who chooses to buy food.
     */
    public void buyFood(Player player) {

        foodPrice();
        try {
            input = Integer.parseInt(console.nextLine());
        } catch (Exception e) {
            System.out.println("Incorrect input. Enter a number between 1-4.");
        }

        switch (input) {
            case 1:
                System.out.println("How many Kilos of meat do you want to buy ?");
                try {
                    input2 = Integer.parseInt(console.nextLine());
                } catch (Exception e) {
                    System.out.println("Incorrect input. Enter a number.");
                    buyFood(player);
                    break;
                }
                if (player.getCoins() < getMeatPrice() * input2) {
                    System.out.println("Not enough coins. You only have " + player.getCoins() + " coins.");
                    System.out.println("Return to main menu...");
                    backToMenu = true;
                    FormatHelp.threadSleep();
                    FormatHelp.emptyScreen();
                    break;


                } else {
                    for (int i = 0; i < input2; i++) {
                        player.getFoodList().add(new Meat());
                    }
                    player.setCoins(player.getCoins() - getMeatPrice() * input2);
                    System.out.println("You've bought " + input2 + " kilos of meat!");
                    System.out.println("You have : " + player.getCoins() + " coins left.");
                    System.out.println("Next player's turn...");
                    backToMenu = false;
                    FormatHelp.threadSleep();
                    FormatHelp.emptyScreen();

                }
                break;
            case 2:
                System.out.println("How many Kilos of veggies do you want to buy ?");
                try {
                    input2 = Integer.parseInt(console.nextLine());
                } catch (Exception e) {
                    System.out.println("Incorrect input. Enter a number.");
                    buyFood(player);
                    break;
                }
                if (player.getCoins() < getVeggiesPrice() * input2) {

                    System.out.println("Not enough coins. You have : " + player.getCoins() + " coins left.");
                    System.out.println("Return to main menu...");
                    backToMenu = true;
                    FormatHelp.threadSleep();
                    FormatHelp.emptyScreen();
                    break;

                } else {
                    for (int i = 0; i < input2; i++) {
                        player.getFoodList().add(new Veggies());
                    }
                    player.setCoins(player.getCoins() - getVeggiesPrice() * input2);
                    System.out.println("You've bought " + input2 + " kilos of veggies!");
                    System.out.println("You have : " + player.getCoins() + " coins left.");
                    System.out.println("Next player's turn...");
                    backToMenu = false;
                    FormatHelp.threadSleep();
                    FormatHelp.emptyScreen();

                }
                break;
            case 3:
                System.out.println("How many Kilos of mix foods do you want to buy ?");
                try {
                    input2 = Integer.parseInt(console.nextLine());
                } catch (Exception e) {
                    System.out.println("Incorrect input. Enter a number.");
                    buyFood(player);
                    break;
                }
                if (player.getCoins() < getMixFoodPrice() * input2) {
                    System.out.println("Not enough coins. You only have " + player.getCoins() + " coins.");
                    System.out.println("Return to main menu...");
                    backToMenu = true;

                } else {
                    for (int i = 0; i < input2; i++) {
                        player.getFoodList().add(new Mixfood());
                    }
                    player.setCoins(player.getCoins() - getMixFoodPrice() * input2);
                    System.out.println("You've bought " + input2 + " kilos of mixed food!");
                    System.out.println("You have : " + player.getCoins() + " coins left.");
                    System.out.println("Next player's turn");
                    backToMenu = false;
                }
                FormatHelp.threadSleep();
                FormatHelp.emptyScreen();
                break;
            case 4:
                System.out.println("Return to main menu...");
                backToMenu = true;
                FormatHelp.threadSleep();
                FormatHelp.emptyScreen();
                break;
            default:
                buyFood(player);
        }
    }


    /**
     * This method prints out the price of animals that players need to know.
     */
    public void animalPrice() {
        System.out.println("Welcome to the store!");
        System.out.println("Here is a list of animals you can buy");
        System.out.println("1. Bear " + "   ( " + this.getBearPrice() + " Coins )\n" +
                "2. Dog " + "    ( " + this.getDogPrice() + " Coins )\n" +
                "3. Horse " + "  ( " + this.getHorsePrice() + " Coins )\n" +
                "4. Lion " + "   ( " + this.getLionPrice() + " Coins )\n" +
                "5. Rabbit " + " ( " + this.getRabbitPrice() + " Coins )\n" +
                "6. Return to main menu");
    }

    /**
     * This method prints out the price of foods that players need to know.
     */
    public void foodPrice() {
        System.out.println("Welcome to the Store! Here you can buy some foods");
        System.out.println("1. Meat " + "   ( " + this.getMeatPrice() + " Coins / Kg )\n" +
                "2. Veggies " + " ( " + this.getVeggiesPrice() + " Coins / Kg )\n" +
                "3. Mixfood " + " ( " + this.getMixFoodPrice() + " Coins / Kg \n" +
                "4. Return to main menu.");


    }


    /**
     * This method controls player input when he chooses animal gender.
     * @return M or F as gender for animal.
     */
    public char setGender() {
        System.out.println("Gender (M / F): ");
        gender = console.nextLine().charAt(0);
        if (gender == 'f' || gender == 'm' || gender == 'F' || gender == 'M') {
            return gender;
        }
        System.out.println("Gender has to be M or F. Try again");
        return setGender();
    }


    /**
     * This method let player to names his/her animal.
     * @param player who buy animal.
     * @return name of animal
     */
    public String setName(Player player) {
        System.out.print("Namn: ");
        name = console.nextLine();
        if (hasThisName(player.getAnimalList(), name)) {
            System.out.println("This name already exist. Choose another name. ");
            return setName(player);
        }
        return name;
    }

    /**
     * This method check if the name is already exist in his animal list.
     * @param animalList current animal list that player owns.
     * @param givenName the name player is going to name his/her animal
     * @return true or false.
     */
    public boolean hasThisName(List<Animal> animalList, String givenName) {
        for (Animal animal : animalList) {
            if (animal.getName().equalsIgnoreCase(givenName)) {
                return true;
            }
        }
        return false;
    }


    /**
     * This method helps player to return to main menu if he wants to make another choice.
     * @return as true;
     */
    public boolean returnMainMenu() {
        return this.backToMenu;
    }


    /**
     * Get dog's price that has been initialized
     * @return dog price
     */
    public int getDogPrice() {
        return dogPrice;
    }

    /**
     * Get bear's price that has been initialized
     * @return bear price
     */
    public int getBearPrice() {
        return bearPrice;
    }
    /**
     * Get horse's price that has been initialized
     * @return horse price
     */
    public int getHorsePrice() {
        return horsePrice;
    }

    /**
     * Get lion's price that has been initialized
     * @return lion price
     */
    public int getLionPrice() {
        return lionPrice;
    }

    /**
     * Get rabbit's price that has been initialized
     * @return rabbit price
     */
    public int getRabbitPrice() {
        return rabbitPrice;
    }

    /**
     * Get meat's price that has been initialized
     * @return meat price
     */
    public int getMeatPrice() {
        return meatPrice;
    }

    /**
     * Get mixfood's price that has been initialized
     * @return mixfood price
     */
    public int getMixFoodPrice() {
        return mixFoodPrice;
    }
    /**
     * Get veggies's price that has been initialized
     * @return veggies price
     */
    public int getVeggiesPrice() {
        return veggiesPrice;
    }


}







