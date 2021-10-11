package Game;

import java.util.Scanner;

public class PrintMenus {

    //Skapa metoder för att skriva ut menyer till spelet
    public static void startMenu {
        System.out.println("Hi and welcome to the Animal Game!");
        System.out.println("This is a game where you buy and sell animals.");
        System.out.println("Chose an option to start a new game:");
        System.out.println("1. Start a new game 2. Start from a saved file");

        Scanner myScanner = new Scanner(System.in);
        String startMenuChoice = myScanner.nextLine();
        
    }
}
