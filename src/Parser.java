import org.json.simple.*;
import org.json.simple.parser.*;
import java.util.*;
import java.io.*;

/**
 * Parses a JSON file to extract data related to the game's scenes, including background,
 * dialog, and choices, and provides methods for accessing the parsed information.
 * The code design pattern is that of a factory
 */
public class Parser {

    private File file;
    private BufferedReader reader;    private JSONObject mainObject;

    /**
     * Constructs a new {@code Parser} object that parses the given JSON file.
     *
     * @param file the JSON file to parse
     */
    Parser(File file) {
        this.file = file;

        try (FileReader fileReader = new FileReader(file)) {

            reader = new BufferedReader(fileReader);
            JSONParser parser = new JSONParser();
            mainObject = (JSONObject) parser.parse(reader);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Extracts the background file path from the parsed JSON data.
     *
     * @return a {@link File} representing the background image
     */
    File extractBackground() {
        return new File(mainObject.get("background").toString());
    }

    /**
     * Extracts the dialog and choices from the parsed JSON data.
     * This method handles both regular dialog and choice-based dialog.
     *
     * @return a list of {@link Dialog} objects containing both standard dialog and choice dialog
     */
    List<Dialog> extractDialog() {
        List<Dialog> dialogs = new ArrayList<>();
        JSONObject dialogObject = (JSONObject) mainObject.get("dialog");
        JSONArray text = (JSONArray) dialogObject.get("text");
        JSONArray choices = (JSONArray) dialogObject.get("choice");

        // Using integers instead of constants or enums to reduce complexity and verbosity
        // 0 = CHARACTER | 1 = SPRITE | 2 = CHOICE | 3 = TEXT

        JSONArray innerArray;

        // Iterate through all dialog texts except the last one
        for (int i = 0; i < text.toArray().length - 1; i++) {
            innerArray = (JSONArray) text.get(i);

            dialogs.add(new Dialog((String) innerArray.get(0),
                    (String) innerArray.get(1),
                    (String) innerArray.get(2)
            ));
        }

        // Handle the last dialog with choices
        innerArray = (JSONArray) text.get(text.toArray().length - 1);

        try {
            dialogs.add(new ChoiceDialog((String) innerArray.get(0),
                    (String) innerArray.get(1),
                    (String) innerArray.get(2),
                    new Choice((HashMap) choices.get(0)),
                    new Choice((HashMap) choices.get(1))
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dialogs;
    }
}
