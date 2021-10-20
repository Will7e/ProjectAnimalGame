package GameController;
import Animals.Animal;
import Food.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * The player should be able to store his money, his owned animals and the food he/she owns.
 * The player should also have a name.
 * @author william, ridah, marcus
 */
public class Player {
    private String name;
    protected int playerCoins = 100;
    private ArrayList<Animal> ownAnimal; // ArrayList
    private ArrayList<Food> ownFood; // ArrayList, use size() to retrieve total amount of ...


    public Player(String name) {
        this.name = name;
        this.ownAnimal = new ArrayList<>();
        this.ownFood = new ArrayList<>();
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

    public List<Animal> getOwnAnimal() {
        return ownAnimal;
    }

    public List<Food> getOwnFood() {
        return ownFood;
    }


}