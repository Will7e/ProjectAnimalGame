package Animals;

public class Lion extends Animal {

    private String name = "Lion";
    private int health = 100;
    private int startAge = 0;
    private int maxAge = 100;
    private int currentStartAge = 0;
    private int breedingChance = 50;
    private char gender;

    public Lion(String name, char gender) {
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





