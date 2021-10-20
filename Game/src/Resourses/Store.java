package Resourses;

import Animals.*;
import Food.Meat;
import Food.MixFood;
import Food.Veggies;
import GameController.Player;

import java.util.Scanner;

public class Store {
    Scanner console = new Scanner(System.in);
    protected final int dogPrice = 30;
    protected final int bearPrice = 80;
    protected final int horsePrice = 50;
    protected final int lionPrice = 99;
    protected final int rabbitPrice = 10;
    protected final int meatPrice = 10;
    protected final int mixFoodPrice = 5;
    protected final int veggiesPrice = 1;
    private int input2;

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
        System.out.println("1. Bear " + "   ( " + this.getBearPrice() + " Coins )\n" +
                "2. Dog " + "    ( " + this.getDogPrice() + " Coins )\n" +
                "3. Horse " + "  ( " + this.getHorsePrice() + " Coins )\n" +
                "4. Lion " + "   ( " + this.getLionPrice() + " Coins )\n" +
                "5. Rabbit " + " ( " + this.getRabbitPrice() + " Coins )");
        int input = Integer.parseInt(console.nextLine());
        switch (input) {
            case 1:
                System.out.println("How many bear do you want to buy");
                input2 = Integer.parseInt(console.nextLine());
            {
                if (player.getCoins() < this.getBearPrice() * input2) {
                    System.out.println("No cash. You have to only " + player.getCoins()+". Try again!");
                    animalToBuy(player);

                } else {
                    for (int i = 1; i <= input2; i++) {
                        System.out.println("Bear: " + i);
                        System.out.println("Namn: ");
                        String name = console.nextLine();
                        System.out.println("Gender: ");
                        char gender = console.nextLine().charAt(0);
                        player.getOwnAnimal().add(new Bear(name, gender));
                    }
                    player.setCoins(player.getCoins() - getBearPrice()*input2);
                    System.out.println("You have "+ player.getCoins()+" left. ");
                }
                break;
            }
            case 2:
                System.out.println("How many dogs do you want to buy");
                input2 = Integer.parseInt(console.nextLine());
            {
                if (player.getCoins() < this.getDogPrice() * input2) {
                    System.out.println("No cash. You have to only " + player.getCoins()+". Try again!");
                    animalToBuy(player);

                } else {
                    for (int i = 1; i <= input2; i++) {
                        System.out.println("Dog: " + i);
                        System.out.println("Namn: ");
                        String name = console.nextLine();
                        System.out.println("Gender: ");
                        char gender = console.nextLine().charAt(0);
                        player.getOwnAnimal().add(new Dog(name, gender));
                    }
                    player.setCoins(player.getCoins() - getDogPrice()*input2);
                    System.out.println("You have "+ player.getCoins()+" left. ");
                }
                break;
            }
            case 3:
                System.out.println("How many horses do you want to buy");
                input2 = Integer.parseInt(console.nextLine());
            {
                if (player.getCoins() < this.getHorsePrice() * input2) {
                    System.out.println("No cash. You have to only " + player.getCoins()+". Try again!");
                    animalToBuy(player);

                } else {
                    for (int i = 1; i <= input2; i++) {
                        System.out.println("Horse: " + i);
                        System.out.println("Namn: ");
                        String name = console.nextLine();
                        System.out.println("Gender: ");
                        char gender = console.nextLine().charAt(0);
                        player.getOwnAnimal().add(new Horse(name, gender));
                    }
                    player.setCoins(player.getCoins() - getHorsePrice()*input2);
                    System.out.println("You have "+ player.getCoins()+" left. ");
                }
                break;
            }
            case 4:
                System.out.println("How many lions do you want to buy");
                input2 = Integer.parseInt(console.nextLine());
            {
                if (player.getCoins() < this.getLionPrice() * input2) {
                    System.out.println("No cash. You have to only " + player.getCoins()+". Try again!");
                    animalToBuy(player);

                } else {
                    for (int i = 1; i <= input2; i++) {
                        System.out.println("Lion: " + i);
                        System.out.println("Namn: ");
                        String name = console.nextLine();
                        System.out.println("Gender: ");
                        char gender = console.nextLine().charAt(0);
                        player.getOwnAnimal().add(new Lion(name, gender));
                    }
                    player.setCoins(player.getCoins() - getLionPrice()*input2);
                    System.out.println("You have "+ player.getCoins()+" left. ");
                }
                break;
            }
            case 5:
                System.out.println("How many rabbits do you want to buy");
                input2 = Integer.parseInt(console.nextLine());
            {
                if (player.getCoins() < this.getRabbitPrice() * input2) {
                    System.out.println("No cash. You have to only " + player.getCoins()+". Try again!");
                    animalToBuy(player);

                } else {
                    for (int i = 1; i <= input2; i++) {
                        System.out.println("Rabbit: " + i);
                        System.out.println("Namn: ");
                        String name = console.nextLine();
                        System.out.println("Gender: ");
                        char gender = console.nextLine().charAt(0);
                        player.getOwnAnimal().add(new Rabbit(name, gender));
                    }
                    player.setCoins(player.getCoins() - getRabbitPrice()*input2);
                    System.out.println("You have "+ player.getCoins()+" left. ");
                }
                System.out.println();
                break;
            }

        }
    }

public void buyFood(Player player) {
    System.out.println("1. Meat " + "   ( " + this.getMeatPrice() + " Coins / Kg )\n" +
            "2. Veggies " + " ( " + this.getVeggiesPrice() + " Coins / Kg )\n" +
            "3. MixFood " + " ( " + this.getMixFoodPrice() + " Coins / Kg )");
            int input = Integer.parseInt(console.nextLine());
            switch (input){
                case 1:
                    System.out.println("How many Kg of meat do you want to buy");
                    input2 = Integer.parseInt(console.nextLine());
                    if (player.getCoins() < getMeatPrice() * input2){
                        System.out.println("Coins are not enough. You have only " + player.getCoins());
                        buyFood(player);
                    } else {
                        for (int i =0 ; i < input2; i++){
                            player.getOwnFood().add(new Meat());
                        }
                        player.setCoins(player.getCoins() - getMeatPrice() * input2);
                        System.out.println("You have : " + player.getCoins() + "left.");
                    }
                    break;
                case 2:
                    System.out.println("How many Kg of veggies do you want to buy");
                    input2 = Integer.parseInt(console.nextLine());
                    if (player.getCoins() < getVeggiesPrice() * input2){
                        System.out.println("Coins are not enough. You have only " + player.getCoins());
                        buyFood(player);
                    } else {
                        for (int i =0 ; i < input2; i++){
                            player.getOwnFood().add(new Veggies());
                        }
                        player.setCoins(player.getCoins() - getVeggiesPrice() * input2);
                        System.out.println("You have : " + player.getCoins() + "left.");
                    }
                    break;
                case 3:
                    System.out.println("How many Kg of mix foods do you want to buy");
                    input2 = Integer.parseInt(console.nextLine());
                    if (player.getCoins() < getMixFoodPrice() * input2){
                        System.out.println("Coins are not enough. You have only " + player.getCoins());
                        buyFood(player);
                    } else {
                        for (int i = 0 ; i < input2; i++){
                            player.getOwnFood().add(new MixFood());
                        }
                        player.setCoins(player.getCoins() - getMixFoodPrice() * input2);
                        System.out.println("You have : " + player.getCoins() + "left.");
                    }
                    break;
            }
            }
            }






