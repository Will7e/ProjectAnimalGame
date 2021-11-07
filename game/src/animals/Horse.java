package animals;

import food.Food;
import food.Veggies;
import gamecontroller.FormatHelp;

import java.io.Serializable;
/**
 *This is the class where we created for this specific animal ( Horse ). This class is subclass arv from Animal (super).
 * This class has specific stats of animal, such as amount of health, price to sell, age, max age, class name.
 * This class methods are exact same methods we have in super class Animal. But it has logics and implementations.
 *
 * @author William, Marcus, Ridah.
 */

public class Horse extends Animal implements Serializable {
    protected String className = "Horse";
    protected double health = Math.round(100);
    protected int maxAge = 25;
    protected int priceToSell = 50;
    protected int age = 0;
    public Horse(String name, char gender) {
        super(name, gender);

    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    /**
     * This method calculate the amount of health that are going to increase for this animal.
     * In this case it's ( 10% of the current health). But only if the type of food pass in parameter is
     * an object of "Veggies" class.
     */
    public void eatFood(Food foodToEat) {
        double amountHealthIncreased;
        if  (foodToEat instanceof Veggies){
            amountHealthIncreased = foodToEat.getHealthIncrease() * getHealth() - health;
            setHealth(getHealth() * foodToEat.getHealthIncrease());
            System.out.println("You've use the food.");
            System.out.println("Health increased by " + (Math.floor(amountHealthIncreased)) +"\n" +
                    "Current health: " + getHealth());
            System.out.println("Next player's turn...");
            FormatHelp.threadSleep();
            FormatHelp.emptyScreen();

        }

    }
    @Override
    public double getHealth() {
        return (int)health;
    }

    @Override
    public void setHealth(double health) {
        this.health = (int) health;
    }

    @Override
    public int getMaxAge() {
        return maxAge;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public char getGender() {
        return gender;
    }

    @Override
    public int getPriceToSell() {
        return priceToSell;
    }

    public String getClassName() {
        return className;
    }
    public void setPriceToSell(int priceToSell) {
        this.priceToSell = priceToSell;
    }


}
