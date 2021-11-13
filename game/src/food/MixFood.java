package food;

import java.io.Serializable;

/**
 * This is the class we created to have specific stats of food. This class we name it Mixfood. Mixfood is arv from Food.
 * This class has a name and amount of health it helps to increase for animal that use it.
 * The methods we have in this class are inherited from super class Food.
 *
 * @author William, Marcus, Ridah
 */

public class Mixfood extends Food implements Serializable {
    protected String name = "Mixfood"; // Name of this class.
    protected double healthIncrease = 1.1; // 10% health increase.

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getHealthIncrease() {
        return healthIncrease;
    }
}
