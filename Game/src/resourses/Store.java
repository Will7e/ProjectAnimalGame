package resourses;

import animals.*;
import food.Meat;
import food.MixFood;
import food.Veggies;
import gamecontroller.FormatHelp;
import gamecontroller.Player;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

// We should have a price to sell for animal because price in store for animal to buy can not change.

public class Store implements Serializable {
    transient Scanner console = new Scanner(System.in);
    public int dogPrice = 30;
    public int bearPrice = 80;
    public int horsePrice = 50;
    public int lionPrice = 100;
    public int rabbitPrice = 10;
    protected int meatPrice = 10;
    protected int mixFoodPrice = 5;
    protected int veggiesPrice = 1;
    private int input2;
    private char gender;
    private String name;
    private boolean backToMenu;

    public int getDogPrice() {
        return dogPrice;
    }

    public int getBearPrice() {
        return bearPrice;
    }

    public int getHorsePrice() {
        return horsePrice;
    }

    public int getLionPrice() {
        return lionPrice;
    }

    public int getRabbitPrice() {
        return rabbitPrice;
    }

    public int getMeatPrice() {
        return meatPrice;
    }

    public int getMixFoodPrice() {
        return mixFoodPrice;
    }

    public int getVeggiesPrice() {
        return veggiesPrice;
    }

    // Prints out animal choices for player. Add animal to player,
    public void animalToBuy(Player player) {
        animalPrice();
        int input = Integer.parseInt(console.nextLine());
        switch (input) {
            case 1:
                System.out.println("How many bear do you want to buy ?");
                input2 = Integer.parseInt(console.nextLine());
            {
                if (player.getCoins() < this.getBearPrice() * input2) {
                    System.out.println("Not enough coins. You only have " + player.getCoins() + " coins. Try again!");
                    input2 = Integer.parseInt(console.nextLine());
                    animalToBuy(player);

                } else {
                    for (int i = 1; i <= input2; i++) {
                        System.out.println("Bear: " + i);
                        name = setName(player);
                        gender = setGender();
                        player.getAnimalList().add(new Bear(name, gender));
                    }
                    player.setCoins(player.getCoins() - getBearPrice() * input2);
                    System.out.println("You bought " + input2 + " Bear(s)!");
                    System.out.println("You have " + player.getCoins() + " coins left. ");
                    System.out.println("Next players turn, back to menu...");
                    FormatHelp.threadSleep();
                    FormatHelp.emptyScreen();


                }
                break;
            }
            case 2:
                System.out.println("How many dogs do you want to buy ?");
                input2 = Integer.parseInt(console.nextLine());
            {
                if (player.getCoins() < this.getDogPrice() * input2) {
                    System.out.println("Not enough coins. You have to only " + player.getCoins() + " coins. Try again!");
                    animalToBuy(player);

                } else {
                    for (int i = 1; i <= input2; i++) {
                        System.out.println("Dog: " + i);
                        name = setName(player);
                        gender = setGender();
                        player.getAnimalList().add(new Dog(name, gender));
                    }
                    player.setCoins(player.getCoins() - getDogPrice() * input2);
                    System.out.println("You bought " + input2 + " Dog(s)!");
                    System.out.println("You have " + player.getCoins() + " coins left. ");
                    System.out.println("Next players turn, back to menu...");
                    FormatHelp.threadSleep();
                    FormatHelp.emptyScreen();


                }
                break;
            }
            case 3:
                System.out.println("How many horses do you want to buy ?");
                input2 = Integer.parseInt(console.nextLine());
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

                    System.out.println("You bought " + input2 + " Horse(s)!");
                    System.out.println("You have " + player.getCoins() + " coins left. ");
                    System.out.println("Next players turn, back to menu...");
                    FormatHelp.threadSleep();
                    FormatHelp.emptyScreen();




                }
                break;
            }
            case 4:
                System.out.println("How many lions do you want to buy ?");
                input2 = Integer.parseInt(console.nextLine());
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
                    System.out.println("You bought " + input2 + " Lion(s)!");
                    System.out.println("You have " + player.getCoins() + " coins left. ");
                    System.out.println("Next players turn, back to menu...");
                    FormatHelp.threadSleep();
                    FormatHelp.emptyScreen();
                }
                break;
            }
            case 5:
                System.out.println("How many rabbits do you want to buy ?");
                input2 = Integer.parseInt(console.nextLine());
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
                    System.out.println("You bought " + input2 + " Rabbit(s)!");
                    System.out.println("You have " + player.getCoins() + " coins left. ");
                    System.out.println("Next players turn, back to menu...");
                    FormatHelp.threadSleep();
                    FormatHelp.emptyScreen();
                }
                System.out.println();
                break;
            }
            case 6:
                System.out.println("Going back to main menu");
                System.out.println("Next players turn");
                FormatHelp.threadSleep();
                FormatHelp.emptyScreen();
                break;

            default:
                System.out.println("Incorrect input");
                System.out.println("Please try again");
                FormatHelp.threadSleep();
                FormatHelp.emptyScreen();
                animalToBuy(player);
                break;
        }


    }

    // Sell animals
    public void saleStart(Player player) {

        if (player.getAnimalList().size() == 0) {
            System.out.println("You don't own any animals");
            System.out.println("Please make another choice, going back to menu");
            boolean backToMenu = true;
            setBackToMenu(backToMenu);
            FormatHelp.threadSleep();
            FormatHelp.emptyScreen();

        } else {
            System.out.println("Welcome to the Store!");
            System.out.println("Do you want to sell animals?");
            System.out.println("1. Yes. 2. No");
            int userInput = Integer.parseInt(console.nextLine());
            switch (userInput) {
                case 1:
                    System.out.println("Yes");
                    getAnimalsForSale(player);
                    break;

                case 2:
                    System.out.println("Going back to main menu");
                    System.out.println("Next players turn.");
                    FormatHelp.threadSleep();
                    FormatHelp.emptyScreen();
                    break;



                default:
                    System.out.println("Invalid input, please try again");
                    FormatHelp.threadSleep();
                    FormatHelp.emptyScreen();
                    saleStart(player);
                    break;
            }

        }
    }

    public void getAnimalsForSale(Player player) {

        System.out.println(player.getName() + " here is a list of the animals you own and the price");
        for (int i = 0; i < player.getAnimalList().size(); i++) {

            System.out.println("[Name: " + player.getAnimalList().get(i).getName() +"] "+
                    "[Type: " + player.getAnimalList().get(i).getClassName() + "] "+
                    "[Value: " + player.getAnimalList().get(i).getPriceToSell() +"]");
        }
        sellAnimal(player);
    }

    public void sellAnimal(Player player) {

        System.out.println("Which animal do you want to sell? Type in the name of the animal");
        String playerChoice = console.nextLine();
        boolean animalExist = true;
        for (int i = 0; i < player.getAnimalList().size(); i++) {

            if (player.getAnimalList().get(i).getName().equalsIgnoreCase(playerChoice)) {
                player.setCoins(player.getCoins() + player.getAnimalList().get(i).getPriceToSell());
                System.out.println("Sale done, your balance is now " + player.getCoins());
                player.getAnimalList().remove(i);
                animalExist = true;
                break;
            }
            animalExist = false;

        }
        if (!animalExist) {
            System.out.println("Animal doesn't exist, please try again");

        } else {
            System.out.println("Do you want to sell more animals?");
            System.out.println("1. Yes 2. No");
            int userInput = Integer.parseInt(console.nextLine());
            switch (userInput) {
                case 1:
                    getAnimalsForSale(player);

                case 2:
                    System.out.println("Closing the shop, see you next time!");
                    System.out.println("Next players turn, back to main menu");
                    FormatHelp.threadSleep();
                    FormatHelp.emptyScreen();
                    break;

                default:
                    System.out.println("Invalid output, please try again");
                    sellAnimal(player);
            }
        }
    }

    //Prints out food to buy for players. Then add to list.
    public void buyFood(Player player) {
        foodPrice();
        int input = Integer.parseInt(console.nextLine());
        switch (input) {
            case 1:
                System.out.println("How many Kilos of meat do you want to buy ?");
                input2 = Integer.parseInt(console.nextLine());
                if (player.getCoins() < getMeatPrice() * input2) {
                    System.out.println("Not enough coins. You have to only " + player.getCoins() + " coins.");

                } else {
                    for (int i = 0; i < input2; i++) {
                        player.getFoodList().add(new Meat());
                    }
                    player.setCoins(player.getCoins() - getMeatPrice() * input2);
                    System.out.println("You have : " + player.getCoins() + "left.");
                }
                break;
            case 2:
                System.out.println("How many Kilos of veggies do you want to buy ?");
                input2 = Integer.parseInt(console.nextLine());
                if (player.getCoins() < getVeggiesPrice() * input2) {
                    System.out.println("Not enough coins. You have to only " + player.getCoins() + " coins.");

                } else {
                    for (int i = 0; i < input2; i++) {
                        player.getFoodList().add(new Veggies());
                    }
                    player.setCoins(player.getCoins() - getVeggiesPrice() * input2);
                    System.out.println("You have : " + player.getCoins() + "left.");
                }
                break;
            case 3:
                System.out.println("How many Kilos of mix foods do you want to buy ?");
                input2 = Integer.parseInt(console.nextLine());
                if (player.getCoins() < getMixFoodPrice() * input2) {
                    System.out.println("Not enough coins. You have to only " + player.getCoins() + " coins. ");

                } else {
                    for (int i = 0; i < input2; i++) {
                        player.getFoodList().add(new MixFood());
                    }
                    player.setCoins(player.getCoins() - getMixFoodPrice() * input2);
                    System.out.println("You have : " + player.getCoins() + "left.");
                }
                break;
        }
    }

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
    public void foodPrice() {
        System.out.println("1. Meat " + "   ( " + this.getMeatPrice() + " Coins / Kg )\n" +
                "2. Veggies " + " ( " + this.getVeggiesPrice() + " Coins / Kg )\n" +
                "3. MixFood " + " ( " + this.getMixFoodPrice() + " Coins / Kg )");

    }

    public char setGender() {
        System.out.println("Gender (M / F): ");
        gender = console.nextLine().charAt(0);
        if (gender == 'f' || gender == 'm' || gender == 'F' || gender == 'M') {
            return gender;
        }
        System.out.println("Gender has to be M or F. Try again");
        return setGender();
    }

    public String setName(Player player) {
        System.out.print("Namn: ");
        name = console.nextLine();
        if (hasThisName(player.getAnimalList(), name)) {
            System.out.println("This name already exist. Choose another name. ");
            return setName(player);
        }
        return name;
    }

    public boolean hasThisName(List<Animal> animalList, String givenName) {
        for (Animal animal : animalList) {
            if (animal.getName().equalsIgnoreCase(givenName)) {
                return true;
            }
        }
        return false;
    }

    public void setBackToMenu(boolean backToMenu) {
        this.backToMenu = backToMenu;

    }

    public boolean getbackToMenu() {
        return this.backToMenu;
    }
}







