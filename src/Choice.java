import java.io.File;
import java.util.HashMap;

/**
 * Represents a choice in the game, with associated text and a scene file.
 */
public class Choice {
    private String text;
    private File scene;

    /**
     * Constructs a new {@code Choice} object using a map of choice properties.
     *
     * @param choice a map containing the choice's text and scene file path
     */
    Choice(HashMap<String, String> choice) {
        text = choice.get("text");
        scene = new File(choice.get("scene"));
    }

    /**
     * Returns the text of the choice.
     *
     * @return the choice's text
     */
    public String getText() {
        return text;
    }

    /**
     * Returns the scene file associated with the choice.
     *
     * @return the scene file
     */
    public File getScene() {
        return scene;
    }
}
