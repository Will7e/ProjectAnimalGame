package gamecontroller;

/**
 *     Helping class for the game
 *     Contains features for output in the game
 */
public class FormatHelp {

    /*
    threadSleep() pauses the program for 3000 millisecunders
     */
    public static void threadSleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * emptyScreen() prints ut 50 blank lines.
     */
    public static void emptyScreen() {
            System.out.println("\n".repeat(50));

        }

    }


