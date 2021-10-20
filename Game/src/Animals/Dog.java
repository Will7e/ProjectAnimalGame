package Animals;

public class Dog extends Animal{
    protected String className = "Dog";
    protected int health = 100;
    protected int maxAge = 20;
    protected int currentStartAge = 0;
    protected int breedingChance = 50;

    public Dog(String name, char gender) {
        super(name, gender);
    }


    @Override
    public String getName() {
        return className;
    }

    @Override
    public String getClassName() {
        return className;
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
    public int getMaxAge() {
        return maxAge;
    }

    @Override
    public int getCurrentStartAge() {
        return currentStartAge;
    }

    @Override
    public void setCurrentStartAge(int currentStartAge) {
        this.currentStartAge = currentStartAge;

    }

    @Override
    public int getBreedingChance() {
        return breedingChance;
    }

    @Override
    public char getGender() {
        return gender;
    }

    @Override
    public void setGender(char gender) {
        this.gender = gender;
    }


}
