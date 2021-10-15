package Animals;

public class Bear extends Animal{
    protected final String name = "Bear";
    protected final int health = 100;
    protected final int maxAge = 50;
    protected int currentStartAge = 0;
    protected int breedingChance = 50;
    protected String gender;

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
    public String getGender() {
        return gender;
    }

    @Override
    public void setGender(String gender) {
        this.gender = gender;
    }


}
