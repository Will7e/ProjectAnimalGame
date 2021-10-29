package resourses;

import animals.*;
import food.Meat;
import food.MixFood;
import food.Veggies;
import gamecontroller.Player;

import java.util.List;
import java.util.Scanner;

public class Store {
    private Scanner console = new Scanner(System.in);
    protected int dogPrice = 30;
    protected int bearPrice = 80;
    protected int horsePrice = 50;
    protected int lionPrice = 99;
    protected int rabbitPrice = 10;
    protected int meatPrice = 10;
    protected int mixFoodPrice = 5;
    protected int veggiesPrice = 1;
    private int input2;
    private char gender;
    private String name;

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
                    System.out.println("Not enough coins. You have to only " + player.getCoins() + " coins. Try again!");
                    animalToBuy(player);

                } else {
                    for (int i = 1; i <= input2; i++) {
                        System.out.println("Bear: " + i);
                        name = setName(player);
                        gender = setGender();
                        player.getAnimalList().add(new Bear(name, gender));
                    }
                    player.setCoins(player.getCoins() - getBearPrice() * input2);
                    System.out.println("You have " + player.getCoins() + " left. ");

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
                    System.out.println("You have " + player.getCoins() + " left. ");
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
                    System.out.println("You have " + player.getCoins() + " left. ");
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
                    System.out.println("You have " + player.getCoins() + " left. ");
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
                        player.getAnimalList().add(new Horse(name, gender));
                    }
                    player.setCoins(player.getCoins() - getRabbitPrice() * input2);
                    System.out.println("You have " + player.getCoins() + " left. ");
                }
                System.out.println();
                break;
            }
        }
    }

    // Sell animals
    public void sellAnimal(Player player) {
        if (player.getAnimalList().size() == 0) {
            System.out.println("You don't own any animals");
        } else {
            System.out.println(player.getName() + " here is a list of the animals you own and the price");
            for (int i = 0; i < player.getAnimalList().size(); i++) {

                System.out.print("[Name] " + player.getAnimalList().get(i).getName());
                System.out.print(" [Type] " + player.getAnimalList().get(i).getClassName());

                if (player.getAnimalList().get(i).getClassName().equals("Bear")) {
                    System.out.println(" [Value] " + getBearPrice() + " coins");
                } else if (player.getAnimalList().get(i).getClassName().equals("Dog")) {
                    System.out.println(" [Value] " + getDogPrice() + " coins");
                } else if (player.getAnimalList().get(i).getClassName().equals("Horse")) {
                    System.out.println(" [Value] " + getHorsePrice() + " coins");
                } else if (player.getAnimalList().get(i).getClassName().equals("Lion")) {
                    System.out.println(" [Value] " + getLionPrice() + " coins");
                } else if (player.getAnimalList().get(i).getClassName().equals("Rabbit")) {
                    System.out.println(" [Value] " + getRabbitPrice() + " coins");
                }

            }
            System.out.println("Which animal do you want to sell? Type in the name of the animal");
            String playerChoice = console.nextLine();

            for (int j = 0; j < player.getAnimalList().size(); j++) {
                if (player.getAnimalList().get(j).getName().equalsIgnoreCase(playerChoice) &&
                        player.getAnimalList().get(j).getClassName().equals("Bear")) {
                    player.getAnimalList().remove(j);

                    player.setCoins(player.getCoins() + getBearPrice());
                    System.out.println("Sale done, your balance is now " + player.getCoins());
                } else if (player.getAnimalList().get(j).getName().equalsIgnoreCase(playerChoice) &&
                        player.getAnimalList().get(j).getClassName().equals("Dog")) {
                    player.getAnimalList().remove(j);

                    player.setCoins(player.getCoins() + getDogPrice());
                    System.out.println("Sale done, your balance is now " + player.getCoins());
                } else if (player.getAnimalList().get(j).getName().equalsIgnoreCase(playerChoice) &&
                        player.getAnimalList().get(j).getClassName().equals("Horse")) {
                    player.getAnimalList().remove(j);
                    player.setCoins(player.getCoins() + getHorsePrice());
                    System.out.println("Sale done, your balance is now " + player.getCoins());

                } else if (player.getAnimalList().get(j).getName().equalsIgnoreCase(playerChoice) &&
                        player.getAnimalList().get(j).getClassName().equals("Lion")) {
                    player.getAnimalList().remove(j);
                    player.setCoins(player.getCoins() + getLionPrice());
                    System.out.println("Sale done, your balance is now " + player.getCoins());

                } else if (player.getAnimalList().get(j).getName().equalsIgnoreCase(playerChoice) &&
                        player.getAnimalList().get(j).getClassName().equals("Rabbit")) {

                    player.getAnimalList().remove(j);
                    player.setCoins(player.getCoins() + getRabbitPrice());
                    System.out.println("Sale done, your balance is now " + player.getCoins());

                } else {
                    System.out.println("You typed the name wrong, please try again");
                    sellAnimal(player);
                }
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
                    System.out.println("Not enough coins. You have to only " + player.getCoins() + " coins. Try again!");
                    buyFood(player);
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
                    System.out.println("Not enough coins. You have to only " + player.getCoins() + " coins. Try again!");
                    buyFood(player);
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
                    System.out.println("Not enough coins. You have to only " + player.getCoins() + " coins. Try again!");
                    buyFood(player);
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
        System.out.println("1. Bear " + "   ( " + this.getBearPrice() + " Coins )\n" +
                "2. Dog " + "    ( " + this.getDogPrice() + " Coins )\n" +
                "3. Horse " + "  ( " + this.getHorsePrice() + " Coins )\n" +
                "4. Lion " + "   ( " + this.getLionPrice() + " Coins )\n" +
                "5. Rabbit " + " ( " + this.getRabbitPrice() + " Coins )");
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

}







