package GameController;
import Animals.Animal;
import Food.Food;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    protected int playerCoins = 100;
    private List<Animal> ownAnimal;
    private List<Food> ownFood;
    private int currentAnimalOwn = 0;
    private int currentFoodOwn = 0;

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

    public void setCurrentAnimalOwn(int currentAnimalOwn) {
        this.currentAnimalOwn = currentAnimalOwn;
    }

    public void setCurrentFoodOwn(int currentFoodOwn) {
        this.currentFoodOwn = currentFoodOwn;
    }


    public int getCurrentAnimalOwn() {
        return currentAnimalOwn;
    }

    public int getCurrentFoodOwn() {
        return currentFoodOwn;
    }
}