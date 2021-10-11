package Animals;

public class Lion extends Animal{
    private String name = "Lion";
    private int health = 100;
    private int startAge = 0;
    private int maxAge = 100;


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
