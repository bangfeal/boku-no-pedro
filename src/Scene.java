import java.io.*;
import java.util.*;

public class Scene {
    private File background;
    private List<Dialog> dialogs = new ArrayList<>();
    private int currentIndex = 0;

    Scene (File sceneFile) {
        Parser parser = new Parser(sceneFile);
        background = parser.extractBackground();
        dialogs = parser.extractDialog();
    }

    public File getBackground() {
        return background;
    }

    public boolean isOver() {
        return currentIndex == dialogs.size();
    }

    public Dialog getCurrentDialog() {
        return dialogs.get(currentIndex);
    }

    public void increment() {
        currentIndex++;
    }
}
