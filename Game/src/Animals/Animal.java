package Animals;

public abstract class Animal {
    protected String name;
    protected String gender;

    public abstract String getName();
    public abstract void foodToEat();
    public abstract int getHealth();
    public abstract int setHealth();
    public abstract int getMaxAge();
    public abstract int getCurrentStartAge();
    public abstract void setCurrentStartAge(int currentStartAge);
    public abstract int getBreedingChance();
    public abstract String getGender();
    public abstract void setGender(String gender);

    public  boolean canBreed(Animal animal){
        if (this.name.equalsIgnoreCase(animal.name) && this.gender == animal.gender){
            return true;
        }
        return false;
    }




}



