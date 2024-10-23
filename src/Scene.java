import java.io.*;
import java.util.*;

public class Scene {
    private Metadata metadata;
    private List<Dialog> dialogs = new ArrayList<>();
    private int currentIndex = 0;

    Scene (File sceneFile) {
        Parser parser = new Parser(sceneFile);
        metadata = parser.extractMetadata();
        dialogs = parser.extractDialog();
    }

    public boolean isOver() {
        return currentIndex == dialogs.size();
    }

    public Metadata getMetadata() {
        return metadata;
    }
    public Dialog getCurrentDialog() {
        return dialogs.get(currentIndex);
    }

    public void increment() {
        currentIndex++;
    }
}
