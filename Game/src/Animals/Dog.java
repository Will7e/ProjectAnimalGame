package Animals;


import Food.Food;
import Food.MixFood;;

public class Dog extends Animal{
    protected String className = "Dog";
    protected double health = 100;
    protected int maxAge = 20;
    protected int currentStartAge = 0;
    protected int breedingChance = 50;

    public Dog(String name, char gender) {
        super(name, gender);
        this.name = name;
        this.gender = gender;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public void eatFood(Food foodToEat) {
        double amountHealthIncreased;
        if  (foodToEat instanceof MixFood){
            amountHealthIncreased = foodToEat.getHealthIncrease() * getHealth() - health;
            setHealth(getHealth() * foodToEat.getHealthIncrease());
            System.out.println("Your health increased by " + Math.round(amountHealthIncreased));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("I don't eat this kind of food.");
        }
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public void setHealth(double health) {
        this.health = Math.round(health);
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
