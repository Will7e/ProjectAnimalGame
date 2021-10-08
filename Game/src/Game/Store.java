package Game;

/*
 * animalPrice: int (så småningom lionPrice, dogPrice osv)
 * foodPrice: int (så småningom meatPrice, vegPrice osv)
 * Animal
 * Food
 *
 * buyAnimal();
 */

public class Store {
    public final int lionPrice = 100;
    public final int bearPrice = 80;
    public final int horsePrice = 50;
    public final int dogPrice = 30;
    public final int rabbitPrice = 10;

    public final int meatPrice = 10;
    public final int mixedPrice = 5;
    public final int vegPrice = 1;


    public Store (int lionPrice, int bearPrice, int horsePrice, int dogPrice, int rabbitPrice, int meatPrice, int mixedPrice, int vegPrice) {
        this.lionPrice = lionPrice;
        this.bearPrice = bearPrice;
        this.horsePrice = horsePrice;
        this.dogPrice = dogPrice;
        this.rabbitPrice = rabbitPrice;

        this.meatPrice = meatPrice;
        this.mixedPrice = mixedPrice;
        this.vegPrice = vegPrice;
        
    }
}
