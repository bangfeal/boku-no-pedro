import java.io.*;
import java.util.*;

/**
 * Represents a scene in the game, consisting of background and dialogs.
 */
public class Scene {
    private File background;
    private List<Dialog> dialogs = new ArrayList<>();
    private int currentIndex = 0;

    /**
     * Constructs a Scene by parsing the given scene file.
     *
     * @param sceneFile The file containing the scene data.
     */
    Scene(File sceneFile) {
        Parser parser = new Parser(sceneFile);
        background = parser.extractBackground();
        dialogs = parser.extractDialog();
    }

    /**
     * Gets the background file for the scene.
     *
     * @return The background file.
     */
    public File getBackground() {
        return background;
    }

    /**
     * Checks if the scene has finished (all dialogs have been displayed).
     *
     * @return true if the scene is over, false otherwise.
     */
    public boolean isOver() {
        return currentIndex == dialogs.size();
    }

    /**
     * Gets the current dialog of the scene.
     *
     * @return The current Dialog object.
     */
    public Dialog getCurrentDialog() {
        return dialogs.get(currentIndex);
    }

    /**
     * Moves to the next dialog in the scene.
     */
    public void increment() {
        currentIndex++;
    }
}
