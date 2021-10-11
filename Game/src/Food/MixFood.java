package Food;

public class MixFood extends Food{
    private String name = "MixFood";
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
