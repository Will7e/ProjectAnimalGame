package gamecontroller;

public class FormatHelp {

    public static void threadSleep() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

        public static void emptyScreen() {

            System.out.println("\n".repeat(50));

        }


    }


