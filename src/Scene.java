import java.io.*;
import java.util.*;

/**
 * Represents a scene in the game, which includes a background image and a list of dialogs.
 * The class allows navigation through the dialogs and checks if the scene is over.
 * design pattern is that of a dependency injection
 */
public class Scene {
    private File background;
    private List<Dialog> dialogs = new ArrayList<>();
    private int currentIndex = 0;

    /**
     * Constructs a new {@code Scene} object by parsing the specified scene file.
     *
     * @param sceneFile the file representing the scene's data
     */
    Scene(File sceneFile) {
        Parser parser = new Parser(sceneFile);
        background = parser.extractBackground();
        dialogs = parser.extractDialog();
    }

    /**
     * @return the background {@link File} for the scene
     */
    public File getBackground() {
        return background;
    }

    /**
     * Checks if all dialogs in the scene have been displayed.
     *
     * @return {@code true} if all dialogs are over, otherwise {@code false}
     */
    public boolean isOver() {
        return currentIndex == dialogs.size();
    }

    /**
     * @return the current {@link Dialog} object
     */
    public Dialog getCurrentDialog() {
        return dialogs.get(currentIndex);
    }

    /**
     * Increments the dialog index to move to the next dialog.
     */
    public void increment() {
        currentIndex++;
    }
}
