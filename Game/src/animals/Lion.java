package animals;

import food.Food;
import food.Meat;

public class Lion extends Animal{
    protected String className = "Lion";
    protected double health = 100;
    protected int maxAge = 100;
    protected int priceToSell = 100;
    protected int age = 0;
    public Lion(String name, char gender) {
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
        } else {
            System.out.println("I don't eat this kind of food.");
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
