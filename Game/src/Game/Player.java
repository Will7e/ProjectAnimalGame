package Game;

/* name: String
 * coins: int
 * animalOwned: int (förmodligen en per sorts animal senare - lionOwned, dogOwned osv)
 * foodOwned: int (förmodligen en per sorts mat senare - mixedOwned, meatOwned osv)
 */

public class Player {
    private String playerName;
    private int playerCoins = 100;
    private List<Animal> ownAnimal;
    private List<Food> ownFood;
    private int currentAnimalOwn = 0;
    private int currentFoodOwn = 0;
}
