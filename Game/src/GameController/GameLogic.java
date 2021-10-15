package GameController;

import Animals.*;
import Food.Food;
import Food.Meat;
import Food.MixFood;
import Food.Veggies;
import Resourses.Store;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class GameLogic {
    Scanner console = new Scanner(System.in);
    Scanner sc = new Scanner(System.in);
    Scanner scanner = new Scanner(System.in);
    protected Dog dog;
    protected Bear bear;
    protected Horse horse;
    protected Lion lion;
    protected Rabbit rabbit;
    protected Meat meat;
    protected MixFood mixFood;
    protected Veggies veggies;
    protected List<Player> playerList;
    protected Player player;
    protected ArrayList<Food> foodsList;
    protected ArrayList<Animal> animalArrayList;
    protected Store store = new Store();
    private int playerAmount;
    int playerShoppingInput;
    int setGender;


    public GameLogic(){
        this.dog = new Dog() ;
        this.bear = new Bear();
        this.lion = new Lion();
        this.horse = new Horse();
        this.rabbit = new Rabbit();
        this.meat = new Meat();
        this.mixFood = new MixFood();
        this.veggies = new Veggies();
        this.playerList = new ArrayList<>();
        this.foodsList = new ArrayList<>();
        this.animalArrayList = new ArrayList<>();



        startGame();
    }

    // This method for player's choice how many rounds they want to play.  5- 30 rounds with do-while loop.
    public void startGame(){
        int spin = 0;
        System.out.println("How many rounds do you want to play? ");
        int input = console.nextInt();
        if (input < 5 || input > 30){
            System.out.println("Between 5 - 30 rounds.");
            startGame();
        } else {
            do {
                askAmountPlayers();
                addPlayer();
                playerChoice();

                spin++;
            }while (spin<= input );
        }
    }

    private void askAmountPlayers(){
        // This method ask for how many players are going to play.
        do {
            System.out.println("How many players do you want to play? ");
            playerAmount = sc.nextInt();
            if (playerAmount < 2 || playerAmount > 4) {
                System.out.println("Between 2 - 4");
            }
        } while (playerAmount <2 || playerAmount > 4);
    }
    // This method is for adding players to the list
    // Players can input names without having duplicate names.
    public void addPlayer() {
        int i = 1;
        do {
            System.out.println("Enter player" + i + "name");
             String name = scanner.nextLine();
            if (hasThisName(playerList, name)) {
                System.out.println("You cant take this name");
                continue;
            }
            playerList.add(new Player(name));
            i++;
        } while (i <= playerAmount);

        // This method is checking if player's name already exist.
    }
    public boolean hasThisName(List<Player> playerList, String givenName){
        for (Player player : playerList){
            if (player.getName().equalsIgnoreCase(givenName)){
                return true;
            }
        }
        return false;

    }

    // prints player's choice.
    //Case 1 - Buy animal / Set gender.
    public void playerChoice(){
        Iterator<Player> iterator = playerList.iterator();
        while (iterator.hasNext()){
            Player player = iterator.next();
            System.out.println("Player :" + player.getName());
            System.out.println("What do you want to buy?");
            System.out.println("1. Buy animals    2. Feed animals    3. Buy food");
            int input = console.nextInt();
            switch (input){
                case 1: buyAnimalsChoice();
                    playerShoppingInput = console.nextInt();
                    setGenderChoice();
                    setGender = console.nextInt();
                    // Another switch menu
                        switch (playerShoppingInput){
                        case 1:
                            if (setGender == 1){
                            this.bear.setGender("Male");
                        }
                        else {
                            this.bear.setGender("Female");
                        }
                            player.setCoins(player.getCoins() - store.getBearPrice());
                            player.getOwnAnimal().add(bear);
                            player.setCurrentAnimalOwn(player.getCurrentAnimalOwn() + 1);
                            System.out.println("Congrats you got a bear "+ "("+this.bear.getGender()+")"+
                                    "you have " + player.getCoins() +"coins left." );
                            break;
                        case 2  :
                            if (setGender == 1){
                                this.dog.setGender("Male");
                            }
                            else {
                                this.dog.setGender("Female");
                            }
                            player.setCoins(player.getCoins() - store.getDogPrice());
                            player.getOwnAnimal().add(dog);
                            player.setCurrentAnimalOwn(player.getCurrentAnimalOwn() + 1);
                            System.out.println("Congrats you got a bear: \n" +
                                    "you have " + player.getCoins() +"coins left." );
                            break;
                        case 3: if (setGender == 1){
                            this.horse.setGender("Male");
                        }
                        else {
                            this.horse.setGender("Female");
                        }
                            player.setCoins(player.getCoins() - store.getHorsePrice());
                            player.getOwnAnimal().add(horse);
                            player.setCurrentAnimalOwn(player.getCurrentAnimalOwn() + 1);
                            System.out.println("Congrats you got a bear: \n" +"you have " + player.getCoins() +"coins left." );
                            break;
                        case 4: if (setGender == 1){
                            this.lion.setGender("Male");
                        }
                        else {
                            this.lion.setGender("Female");
                        }
                            player.setCoins(player.getCoins() - store.getLionPrice());
                            player.getOwnAnimal().add(lion);
                            player.setCurrentAnimalOwn(player.getCurrentAnimalOwn() + 1);
                            System.out.println("Congrats you got a bear: \n" +
                                    "you have " + player.getCoins() +"coins left." );
                            break;
                        case 5: if (setGender == 1){
                            this.rabbit.setGender("Male");
                        }
                        else {
                            this.rabbit.setGender("Female");
                        }
                            player.setCoins(player.getCoins() - store.getRabbitPrice());
                            player.getOwnAnimal().add(rabbit);
                            player.setCurrentAnimalOwn(player.getCurrentAnimalOwn() + 1);
                            System.out.println("Congrats you got a bear: \n" +
                                    "you have " + player.getCoins() +"coins left." );
                            break;
                        default:
                            System.out.println("nothing");

                    }

                    break;
                case 2: feedAnimal();
                    break;
                case 3: buyFoodChoice();
                    break;
                default:
                    System.out.println(" Incorrect input");

            }
        }
        }

    // prints animals to buy and price for players.
    public void buyAnimalsChoice(){
        System.out.println("1. Bear "+"   ( "+store.getBearPrice()+" Coins )\n"+
                "2. Dog "+"    ( "+store.getDogPrice()+" Coins )\n"+
                "3. Horse "+"  ( "+store.getHorsePrice()+" Coins )\n"+
                "4. Lion "+"   ( "+store.getLionPrice()+" Coins )\n"+
                "5. Rabbit "+" ( "+store.getRabbitPrice()+" Coins )");


    }

    // INCOMPLETE method for picking which animal to feed.
    public void feedAnimal(){
        System.out.println("Which animal do you want to feed? ");


    }
    // Prints foods to buy and price for players
    public void buyFoodChoice(){
        System.out.println("What food do you want to buy?");
        System.out.println("1. Meat "+"   ( "+store.getMeatPrice()+" Coins)\n"+
                "2. Mixfood " +"( "+store.getMixFoodPrice()+" Coins )\n"+
                "3. Veggies "+"( "+store.getVeggiesPrice()+" Coins )");
    }
    public void setGenderChoice(){
        System.out.println("Välj kön: 1. Male     2. Female");
    }


}










