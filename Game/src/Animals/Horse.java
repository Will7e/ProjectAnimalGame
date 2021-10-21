package Animals;

import Food.Food;
import Food.Veggies;

public class Horse extends Animal{
    protected String className = "Horse";
    protected String name;

    protected double health = Math.round(100);
    protected int maxAge = 25;
    protected int currentStartAge = 0;
    protected int breedingChance = 50;

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
            System.out.println("Your health increased by " + Math.round(amountHealthIncreased));
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
    public int getBreedingChance() {
        return breedingChance;
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
