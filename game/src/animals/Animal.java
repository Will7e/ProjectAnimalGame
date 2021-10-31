package animals;

import food.Food;

public abstract class Animal {
    protected String name;
    protected char gender;
    protected int age = 0;
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
    public abstract int getAge();
    public abstract String getClassName();
    public abstract void eatFood(Food foodToEat);
    public abstract double getHealth();
    public abstract void setHealth(double health);
    public abstract int getMaxAge();
    public abstract void setAge(int age);
    public abstract char  getGender();
    public abstract int getPriceToSell();
    public abstract void setPriceToSell(int priceToSell);

}



