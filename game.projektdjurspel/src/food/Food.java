package food;

import java.io.Serializable;

/**
 * This is the super class we created for other food type classes to arv from.
 * Those methods in this class are all abstract. Because all other food subclasses are force to have those methods.
 * Implements Serializable this for save/load the game later.
 *
 * @author William, Marcus, Ridah.
 */

public abstract class Food implements Serializable {
    /**
     * This abstract method is to get name of the food.
     * @return name of the food.
     */
    public abstract String getName();

    /**
     * This abstract method is to get the percentage of health that are going to increase.
     * @return percentage of health that is going to increase, as double data type.
     */
    public abstract double getHealthIncrease();


}
