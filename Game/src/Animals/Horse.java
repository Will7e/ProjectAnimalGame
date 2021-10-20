package Animals;

public class Horse extends Animal {

    private String name = "Horse";
    private int health = 100;
    private int startAge = 0;
    private int maxAge = 25;
    private int currentStartAge = 0;
    private int breedingChance = 50;
    private char gender;

    public Horse(String name, char gender) {
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

