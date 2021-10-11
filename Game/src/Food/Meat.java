package Food;

public class Meat extends Food {
    private String name = "Meat";
    private double healthIncrease = 1.1;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double setHealthIncrease() {
        return Math.round(healthIncrease);
    }

}
