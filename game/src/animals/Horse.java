package animals;

import food.Food;
import food.Veggies;

public class Horse extends Animal{
    protected String className = "Horse";
    protected double health = Math.round(100);
    protected int maxAge = 25;
    protected int currentStartAge = 0;

    public Horse(String name, char gender) {
        super(name, gender);

    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void eatFood(Food foodToEat) {
        double amountHealthIncreased;
        if  (foodToEat instanceof Veggies){
            amountHealthIncreased = foodToEat.getHealthIncrease() * getHealth() - health;
            setHealth(getHealth() * foodToEat.getHealthIncrease());
            System.out.println("You've use the food.");
            System.out.println("Health increased by " + (Math.floor(amountHealthIncreased)) +"\n" +
                    "Current health: " + getHealth());
        } else {
            System.out.println("I don't eat this kind of food.");
        }

    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public void setHealth(double health) {
        this.health = Math.round(health);
    }

    @Override
    public int getMaxAge() {
        return maxAge;
    }

    @Override
    public int getCurrentStartAge() {
        return currentStartAge;
    }

    @Override
    public void setCurrentStartAge(int currentStartAge) {
    this.currentStartAge = currentStartAge;
    }

    @Override
    public char getGender() {
        return gender;
    }

    @Override
    public void setGender(char gender) {
        this.gender = gender;
    }
    public String getClassName() {
        return className;
    }


}
