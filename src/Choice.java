import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Choice {
    String text;
    File scene;
    Choice(HashMap<String, String> choice) {
        text = choice.get("text");
        scene = new File(choice.get("scene"));
    }

    public String getText() {
        return text;
    }

    public File getScene() {
        return scene;
    }
}
