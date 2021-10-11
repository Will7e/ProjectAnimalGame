package Animals;

public class Horse extends Animal{
    private String name = "Horse";
    private int health = 100;
    private int startAge = 0;
    private int maxAge = 25;



    @Override
    public String getName() {
        return name;
    }

    @Override
    public void foodToEat() {

    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int setHealth() {
        return health;
    }

    @Override
    public int getAge() {
        return startAge;
    }

    @Override
    public int setAge() {
        return startAge;
    }

}
