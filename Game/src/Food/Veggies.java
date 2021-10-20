package Food;

public class Veggies extends Food{
    protected String name = "Veggies";
    protected double healthIncrease = 1.1;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double setHealthIncrease() {
        return Math.round(healthIncrease);
    }
}
