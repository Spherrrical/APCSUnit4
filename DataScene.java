import org.code.theater.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataScene extends Scene {

    public static String[] toStringArray(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            StringBuilder content = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            reader.close();
            return content.toString().split("\n");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int[] toIntArray(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            StringBuilder content = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            reader.close();
            String[] stringArray = content.toString().split("\n");
            int[] intArray = new int[stringArray.length];

            for (int i = 0; i < stringArray.length; i++) {
                intArray[i] = Integer.parseInt(stringArray[i]);
            }

            return intArray;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static double[] toDoubleArray(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            StringBuilder content = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            reader.close();
            String[] stringArray = content.toString().split("\n");
            double[] doubleArray = new double[stringArray.length];

            for (int i = 0; i < stringArray.length; i++) {
                doubleArray[i] = Double.parseDouble(stringArray[i]);
            }

            return doubleArray;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String[] names;
    private String[] teams;
    private double[] ages;
    private String[] positions;

    public DataScene(String[] names, String[] teams, double[] ages, String[] positions) {
        this.names = names;
        this.teams = teams;
        this.ages = ages;
        this.positions = positions;
    }

    public void showPlayer(int index) {
        int randomIndex = (int) (Math.random() * names.length);
        double randomAge = ages[randomIndex];
        double squaredAge = Math.pow(randomAge, 2);
      
        drawText("Name: " + names[index], 20, 325);
        drawText("Team: " + teams[index], 20, 350);
        drawText("Age: " + ages[index], 20, 375);
        drawText("Position: " + positions[index], 20, 400);
        drawText("Squared Age: " + squaredAge, 20, 300);
    }

    public void removePlayer() {
        setFillColor("white");
        drawRectangle(0, 0, getWidth(), getHeight());
    }

    public void createPlayerScene(int index) {
        drawText("Top 10 NFL Kickers", 65, 40);
        showPlayer(index);
        pause(3);
        playNote(Instrument.PIANO, 74, 0.5);
        pause(0.7);
        playNote(Instrument.PIANO, 71, 0.5);
        pause(1); 
        removePlayer();
    }

    public void createScene() {
        for (int i = 0; i < names.length; i++) {
            createPlayerScene(i);
        }
    }

}