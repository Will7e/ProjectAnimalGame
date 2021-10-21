package food;

public class MixFood extends Food{
    protected String name = "MixFood";
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
