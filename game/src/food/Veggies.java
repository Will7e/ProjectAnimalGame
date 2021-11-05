package food;

import java.io.Serializable;

public class Veggies extends Food implements Serializable {
    protected String name = "Veggies";
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
