package food;

import java.io.Serializable;

/**
 * This is the class we created to have specific stats of food. This class we name it Meat. Meat is arv from Food.
 * This class has a name and amount of health it helps to increase for animal that use it.
 * The methods we have in this class are inherited from super class Food.
 *
 * @author William, Marcus, Ridah
 */



public class Meat extends Food implements Serializable {
    protected String name = "Meat";
    protected double healthIncrease = 1.1;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getHealthIncrease() {
        return healthIncrease;
    }

}
