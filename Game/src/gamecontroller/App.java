package gamecontroller;
import gamecontroller.Game;

import java.util.Scanner;

public class App {

    private Game game;
    private SaveRunTimeGame loadSavedGame;
    private boolean activateGame = true;
    Scanner console;
    String fileName;

    public App() {

        console = new Scanner(System.in);
        this.fileName = fileName;
        startMenu();


    }

    public void startMenu() {

        System.out.println("Welcome to the animal game!");
        System.out.println("1. Start a new game 2. Load old file");
        int choice = Integer.parseInt(console.nextLine());

        switch (choice) {

            case 1:
                this.game = new Game();
                break;

            case 2:
                System.out.println("Please enter a name of the saved file");
                fileName = console.nextLine();
                loadSavedGame = FileUtilities.loadSavedGame(fileName);
                if (loadSavedGame != null) {
                    this.game = new Game(loadSavedGame);

                }
                else {


                }




        }
    }
}
