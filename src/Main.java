import javax.swing.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        File testFile = new File("scene0.json");
        Scene testScene = new Scene(testFile);
        System.out.println(testScene.getMetadata().getName());
        System.out.println(testScene.getCurrentDialog().getCharacter() + ": " + testScene.getCurrentDialog().getText());
        JFrame test  = new JFrame("Boku no Pedro!");
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SceneLoaderGUI gui = new SceneLoaderGUI(test, testScene);
        test.add(gui);
        test.setVisible(true);
    }
}