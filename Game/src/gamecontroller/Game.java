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
        int choice = 0;

           try {

                choice = Integer.parseInt(console.nextLine());

            } catch (Exception e) {
                System.out.println("Please enter a number, try again");
                FormatHelp.threadSleep();
                FormatHelp.emptyScreen();
                startMenu();
            }


            switch (choice) {

                case 1:
                    this.game = new GameLogic();
                    break;

                case 2:
                    System.out.println("Enter a name for the saved file");

                        fileName = console.nextLine();


                        loadSavedGame = FileUtilities.loadSavedGame(fileName);
                        if (loadSavedGame != null) {
                            this.game = new GameLogic(loadSavedGame);
                        }
                        else{

                        System.out.println("Something went wrong. Try again");
                        startMenu();

                        }

            }
        }
    }








