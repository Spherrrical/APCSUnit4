import org.code.theater.*;

public class TheaterRunner {
    public static void main(String[] args) {
  
        String[] names = DataScene.toStringArray("names.txt");
        String[] teams = DataScene.toStringArray("teams.txt");
        double[] ages = DataScene.toDoubleArray("age.txt");
        String[] positions = DataScene.toStringArray("position.txt");

        DataScene myDataScene = new DataScene(names, teams, ages, positions);
        myDataScene.createScene();

        Theater.playScenes(myDataScene);
    }
}