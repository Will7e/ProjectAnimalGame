package gamecontroller;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**    A File Utility class that serves the purpose of writing and reading
 * instances of the SaveRunTimeGame class. With the help of this class
 * we can store runtime instances to files and also retrieve them and start the program
 * from old instances.
 *
 */



public class FileUtilities {

    /**
     * This method lets us load old GameLogic saved data.
     * @param fileName the filename from which we want to retrieve GameLogic data
     * @return the instance of SaveRunTimeGame we retrieved
     */

    public static SaveRunTimeGame loadSavedGame(String fileName) {

        SaveRunTimeGame loadGame = null;
        try {
            FileInputStream streamIn = new FileInputStream(fileName +".ser");
            ObjectInputStream oi = new ObjectInputStream(streamIn);
            loadGame = (SaveRunTimeGame) oi.readObject();


            oi.close();
            streamIn.close();

        } catch (Exception e) {

            System.out.println( e.getMessage() );
            // e.printStackTrace();
        }
        return loadGame;
    }

    /**
     * This method lets us save a new instance of SavedRunTimeGame to a chosen file.
     * @param saveRunTime the instance to write to a file
     * @param fileName the filename to where we want to write the file
     */

    public static void saveGameRunTime (SaveRunTimeGame saveRunTime, String fileName) {

        try {
            FileOutputStream streamOut = new FileOutputStream(fileName + ".ser", false);
            ObjectOutputStream objectOut = new ObjectOutputStream(streamOut);
            objectOut.writeObject(saveRunTime);


            objectOut.close();
            streamOut.close();

        }   catch (Exception e) {
            e.printStackTrace();
        }

    }





}



