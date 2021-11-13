package animals;

import food.Food;
import java.io.Serializable;

/**
 *This is the abstract animal class where we created for other animals type classes inherited.
 * In this class we have all methods abstract because other classes who inherited from this class is
 * force to that those methods.
 * Implements Serializable is for save and load game later.
 * @author William, Marcus, Ridah.
 */


public abstract class Animal implements Serializable {
    protected String name; // Every animal are going to need a name.
    protected char gender; // As well as gender.'
    protected double healthReduced; // Animal health reduce each round.
    protected int priceReduced; // Price reduces each round
    public static boolean eatSuccess = true; // Check if animal be able to eat the right food


    /**
     * Constructor of Animal class
     *
     * @param name   as name in field variable
     * @param gender as gender in field variable
     */
    public Animal(String name, char gender) {
        this.name = name;
        this.gender = gender;

    }

    /**
     * This is get name method.
     *
     * @return name of animal.
     */
    public String getName() {
        return name;
    }

    /**
     * This is set name method. Which is for player to set name for their animals.
     *
     * @param name for animal.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Abstract method to get animal's age.
     *
     * @return age of animal.
     */
    public abstract int getAge();

    /**
     * Abstract method to get animal Class name.
     *
     * @return class name of animal.
     */
    public abstract String getClassName();

    /**
     * Abstract method for which food animal is going to eat. Pass the name of food as argument i parameter.
     *
     * @param foodToEat object of class which is extends of Food class.
     */
    public abstract void eatFood(Food foodToEat);

    /**
     * Abstract method to get animal's health.
     *
     * @return health of animal.
     */
    public abstract double getHealth();

    /**
     * Abstract method to set the health of animal. Pass in double type data in parameter.
     *
     * @param health as the heath going to change
     */
    public abstract void setHealth(double health);

    /**
     * Abstract method to get animal's max age.
     *
     * @return max age of animal.
     */
    public abstract int getMaxAge();

    /**
     * Abstract method to set age of animal, because animal is aging each round.
     *
     * @param age as the age going to change.
     */
    public abstract void setAge(int age);

    /**
     * Abstract method to get animal's gender.
     *
     * @return gender of animal.
     */
    public abstract char getGender();

    /**
     * Abstract method to get animal's sell price.
     *
     * @return animal's price.
     */
    public abstract int getPriceToSell();

    /**
     * Abstract method for set animal's price. As the price changes each round.
     *
     * @param priceToSell as price going to change.
     */


    /**
     * Abstract method to set the price of animal that is going to sell. Pass in int type data in parameter.
     *
     * @param priceToSell as the price going to change
     */
    public abstract void setPriceToSell(int priceToSell);


    /**
     * Abstract method to get amount of health reduced.
     *
     * @return amount of health reduce.
     */
    public abstract double getHealthReduced();


    /**
     * Abstract method to set the health of animal that is going to reduce. Pass in double type data in parameter.
     *
     * @param healthReduced as the health that we're going to get.
     */
    public abstract void setHealthReduced(double healthReduced);

    /**
     * Abstract method to get amount of price reduced.
     *
     * @return amount of price reduce.
     */
    public abstract int getPriceReduced();

    /**
     * Abstract method to set the price of animal that is going to reduce. Pass in int type data in parameter.
     *
     * @param priceReduced as the price that we're going to get.
     */
    public abstract void setPriceReduced(int priceReduced);

}





