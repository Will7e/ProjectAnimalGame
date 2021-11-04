package gamecontroller;
import java.util.Scanner;

public class Game {

    private GameLogic game;
    private SaveRunTimeGame loadSavedGame;
    private boolean activateGame = true;
    Scanner console;
    String fileName;

    public Game() {

        console = new Scanner(System.in);
        this.fileName = fileName;
        startMenu();


    }

    public void startMenu() {

        System.out.println("[ -  Welcome to the animal game  - ]");
        System.out.println("   1. New game      2. Load game");
        int choice = Integer.parseInt(console.nextLine());

        switch (choice) {

            case 1:
                this.game = new GameLogic();
                break;

            case 2:
                System.out.println("Please enter a name of the saved file");
                fileName = console.nextLine();
                loadSavedGame = FileUtilities.loadSavedGame(fileName);
                if (loadSavedGame != null) {
                    this.game = new GameLogic(loadSavedGame);

                }
                else {


                }




        }
    }
}
