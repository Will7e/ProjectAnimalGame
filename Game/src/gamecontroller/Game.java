package gamecontroller;

import java.util.Scanner;

public class Game {

    private GameLogic game;
    private SaveRunTimeGame loadSavedGame;
    Scanner console;
    String fileName;

    /**
     * Class constructor, starts startMenu()
     */
    public Game() {
        console = new Scanner(System.in);
        startMenu();
    }

    /**
     * Welcomes user to game, either starts new game, or loads saved file
     */
    public void startMenu() {

        System.out.println("[ -  Welcome to the animal game  - ]");
        System.out.println("   1. New game      2. Load game");

        int choice = 0;
        try {
            choice = Integer.parseInt(console.nextLine());
        } catch (Exception e) {
            System.out.println("Enter a number. Try again");
            FormatHelp.threadSleep();
            FormatHelp.emptyScreen();
            startMenu();
        }
        switch (choice) {
            case 1:
                this.game = new GameLogic();
                break;
            case 2:
                System.out.print("Enter saved file's name: ");
                fileName = console.nextLine();
                loadSavedGame = FileUtilities.loadSavedGame(fileName);
                if (loadSavedGame != null) {
                    this.game = new GameLogic(loadSavedGame);
                } else {


                    startMenu();

                }

        }
    }
}








