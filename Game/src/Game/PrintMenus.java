package Game;


public class PrintMenus {

    //Skapa metoder för att skriva ut menyer till spelet
    public static void startMenu(){
        System.out.println("Hi and welcome to the Animal Game!");
        System.out.println("This is a game where you buy and sell animals.");
        System.out.println("Chose an option to start a new game:");
        System.out.println("1. Start a new game 2. Start from a saved file");
    }

    public static void roundsMenu(){
        System.out.println("How many rounds would you like to play (5-30)?");
    }

    public static void numberOfPlayersMenu(){
        System.out.println("How many players will participate (2-4)?");
    }

    // Här vill vi kanske addera "player 1", "player 2" i printen för att förtydliga
    // vilken spelare som ska mata in sitt namn.

    public static void playerNameMenu(){
        System.out.println("Please enter your name:");
    }

    public static void playerChoiceMenu {
        System.out.println("It's your turn to make a choice.");
        System.out.println("Here are your available resources:");
    }


}
