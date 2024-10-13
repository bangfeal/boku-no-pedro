import java.io.*;

public class Main {
    public static void main(String[] args) {
        File testFile = new File("scene0.json");
        Scene testScene = new Scene(testFile);
        System.out.println(testScene.getMetadata().getName());
        System.out.println(testScene.getDialog(1).getCharacter() + ": " + testScene.getDialog(1).getText());
    }
}