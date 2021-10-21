package animals;

import food.Food;

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
    public abstract int getBreedingChance();
    public abstract char  getGender();
    public void setGender(char gender){
        this.gender = gender;
    }


}



