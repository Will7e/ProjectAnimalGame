package gamecontroller;

import java.io.Serializable;

/**
 *     Helping class for the game
 *     Contains features for output in the game
 */
public class FormatHelp implements Serializable {

    /*
    threadSleep() pauses the program for 2 seconds
     */
    public static void threadSleep() {
        try {
            Thread.sleep(2000);
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


