package animals;

import food.Food;

import java.util.Random;

public abstract class Animal {
    protected String name;
    protected char gender;
    public Animal(String name, char gender){
        this.name = name;
        this.gender = gender;

    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public abstract String getClassName();
    public abstract void eatFood(Food foodToEat);
    public abstract double getHealth();
    public abstract void setHealth(double health);
    public abstract int getMaxAge();
    public abstract int getCurrentStartAge();
    public abstract void setCurrentStartAge(int currentStartAge);
    public abstract char  getGender();
    public void setGender(char gender){
        this.gender = gender;
    }
    // health reduce by random 10-30%
    public double healthReduce(){
        Random random = new Random();
        int rn = random.nextInt(3) + 1;
        switch (rn){
            case 1: setHealth(0.1 * getHealth());
                return getHealth();

            case 2:setHealth(0.2 *getHealth());
                return getHealth();

            case 3: setHealth(0.*3);
        }
        return getHealth();

    }


}



