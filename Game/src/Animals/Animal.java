package Animals;

public abstract class Animal {

    private String name;
    private char gender;

    public Animal(String name, char gender) {
        this.name = name;
        this.gender = gender;
    }


    public abstract String getName();

    public abstract void foodToEat();

    public abstract int getHealth();

    public abstract int setHealth();

    public abstract int getAge();

    public abstract int setAge();

    public abstract char setGender();

    public abstract char getGender();


}







