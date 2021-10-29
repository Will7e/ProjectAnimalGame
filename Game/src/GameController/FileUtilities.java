package GameController;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileUtilities {


    public static SaveRunTimeGame loadSavedGame(String fileName) {

        SaveRunTimeGame loadGame = null;
        try {
            FileInputStream streamIn = new FileInputStream(fileName +".ser");
            ObjectInputStream oi = new ObjectInputStream(streamIn);
            loadGame = (SaveRunTimeGame) oi.readObject();


            oi.close();
            streamIn.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
        return loadGame;
    }

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



