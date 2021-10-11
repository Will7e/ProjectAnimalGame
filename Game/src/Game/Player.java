package Game;
import Animals.Animal;
import Food.Food;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String playerName;
    private int playerCoins = 100;
    private List<Animal> ownAnimal;
    private List<Food> ownFood;
    private int currentAnimalOwn = 0;
    private int currentFoodOwn = 0;

    public Player(String name) {
        this.playerName = name;
        this.ownAnimal = new ArrayList<>();
        this.ownFood = new ArrayList<>();
    }

    public String getName() {
        return playerName;
    }

    public void setName(String name) {
        this.playerName = name;
    }

    public int getCoins() {
        return playerCoins;
    }

    public void setCoins(int coins) {
        this.playerCoins = coins;
    }

    public List<Animal> getOwnAnimal() {
        return ownAnimal;
    }

    public List<Food> getOwnFood() {
        return ownFood;
    }

    public void setCurrentAnimalOwn(int currentAnimalOwn) {
        this.currentAnimalOwn = currentAnimalOwn;
    }

    public void setCurrentFoodOwn(int currentFoodOwn) {
        this.currentFoodOwn = currentFoodOwn;
    }


}