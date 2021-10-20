package Animals;

public class Bear extends Animal {

    private String name = "Bear";
    private int health = 100;
    private int startAge = 0;
    private int maxAge = 50;
    private char gender;
    protected int currentStartAge = 0;
    protected int breedingChance = 50;

    public Bear(String name, char gender) {
        super(name, gender);
    }


    @Override
    public String getName() {
        return null;
    }

    @Override
    public void foodToEat() {

    }

    @Override
    public int getHealth() {
        return 0;
    }

    @Override
    public int setHealth() {
        return 0;
    }

    @Override
    public int getAge() {
        return 0;
    }

    @Override
    public int setAge() {
        return 0;
    }

    @Override
    public char setGender() {
        return 0;
    }

    @Override
    public char getGender() {
        return 0;
    }
}