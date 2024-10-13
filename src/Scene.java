import java.io.*;
import java.util.*;

public class Scene {
    private Metadata metadata;
    private List<Dialog> dialogs = new ArrayList<>();

    Scene (File sceneFile) {
        Parser parser = new Parser(sceneFile);
        metadata = parser.extractMetadata();
        dialogs = parser.extractDialog();
    }

    public Metadata getMetadata() {
        return metadata;
    }
    public Dialog getDialog(int index) {
        return dialogs.get(index);
    }
}
