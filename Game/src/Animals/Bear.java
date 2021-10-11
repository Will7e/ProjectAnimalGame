package Animals;

public class Bear extends Animal{
    private String name = "Bear";
    private int health = 100;
    private int startAge = 0;
    private int maxAge = 50;

    public Bear() {
        super();
    }


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
