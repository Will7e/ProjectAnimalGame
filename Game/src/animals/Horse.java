package animals;

import food.Food;
import food.Veggies;
import gamecontroller.FormatHelp;

import java.io.Serializable;

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
    public void eatFood(Food foodToEat) {
        double amountHealthIncreased;
        if  (foodToEat instanceof Veggies){
            amountHealthIncreased = foodToEat.getHealthIncrease() * getHealth() - health;
            setHealth(getHealth() * foodToEat.getHealthIncrease());
            System.out.println("You've use the food.");
            System.out.println("Health increased by " + (Math.floor(amountHealthIncreased)) +"\n" +
                    "Current health: " + getHealth());

            System.out.println("Going back to main menu");
            System.out.println("Next player's turn");
            FormatHelp.threadSleep();
            FormatHelp.emptyScreen();



        } else {
            System.out.println("I don't eat this kind of food.");
            System.out.println("Going back to main menu");
            System.out.println("Next player's turn");
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
