import java.io.File;
import java.util.HashMap;

/**
 * Represents a choice in the game with associated text and scene.
 */
public class Choice {
    private String text;
    private File scene;

    /**
     * Constructs a Choice object from a map of choice data.
     *
     * @param choice A map containing the choice's text and scene file path.
     */
    Choice(HashMap<String, String> choice) {
        text = choice.get("text");
        scene = new File(choice.get("scene"));
    }

    /**
     * Gets the text of the choice.
     *
     * @return The text of the choice.
     */
    public String getText() {
        return text;
    }

    /**
     * Gets the scene associated with the choice.
     *
     * @return The scene file associated with the choice.
     */
    public File getScene() {
        return scene;
    }
}
