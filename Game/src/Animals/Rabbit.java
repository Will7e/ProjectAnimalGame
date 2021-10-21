package Animals;

import Food.Food;
import Food.Veggies;

public class Rabbit extends Animal{
    protected String className = "Rabbit";
    protected double health = 100;
    protected int maxAge = 10;
    protected int currentStartAge = 0;
    protected int breedingChance = 50;

    public Rabbit(String name, char gender) {
        super(name, gender);
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getClassName() {
        return className;
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
        this.health = health;
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


}


