package Animals;

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
    public abstract void foodToEat();
    public abstract int getHealth();
    public abstract int setHealth();
    public abstract int getMaxAge();
    public abstract int getCurrentStartAge();
    public abstract void setCurrentStartAge(int currentStartAge);
    public abstract int getBreedingChance();
    public abstract char  getGender();
    public void setGender(char gender){
        this.gender = gender;
    }


}



