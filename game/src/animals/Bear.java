package animals;

import food.Food;
import food.Meat;
import gamecontroller.FormatHelp;

public class Bear extends Animal{
    protected final String className = "Bear";
    protected double health = 100;
    protected int maxAge = 50;
    protected int priceToSell = 80;
    protected int age = 0;
    public Bear(String name, char gender) {
        super(name, gender);
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public void eatFood(Food foodToEat) {
        double amountHealthIncreased;
        if  (foodToEat instanceof Meat){
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

    public void setPriceToSell(int priceToSell) {
        this.priceToSell = priceToSell;
    }

}
