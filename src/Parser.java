import org.json.simple.*;
import org.json.simple.parser.*;
import java.util.*;
import java.io.*;

public class Parser {

    private File file;
    private BufferedReader reader;
    private JSONObject mainObject;

    Parser(File file) {
        this.file = file;

        try (FileReader fileReader = new FileReader(file)) {

            reader = new BufferedReader(fileReader);
            JSONParser parser = new JSONParser();
            mainObject = (JSONObject) parser.parse(reader);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    Metadata extractMetadata() {                                                    // handles all JSON
        JSONObject metadata = (JSONObject) mainObject.get("metadata");              // objects instead of passing a
        List<File> nextScenes = new ArrayList<>();                                  // HashMap

        try {
            JSONArray nextScenesArray = (JSONArray) metadata.get("nextScenes");
            for (Object nextScene : nextScenesArray) {
                nextScenes.add((new File((String) nextScene)));
            }

        } catch (ClassCastException | NullPointerException  e) {
            e.printStackTrace();
        }

        return new Metadata((String) metadata.get("name"),
                (String) metadata.get("decidingFactor"),
                nextScenes);
    }

    List<Dialog> extractDialog() {
        List<Dialog> dialogs = new ArrayList<>();
        JSONObject dialogObject = (JSONObject) mainObject.get("dialog");
        JSONArray text = (JSONArray) dialogObject.get("text");

        // using integers instead of constants or enum because these
        // seem to add more complexity and verbosity
        // 0 = CHARACTER | 1 = SPRITE | 2 = CHOICE | 3 = TEXT

        for (int i = 0; i < text.toArray().length; i++) {
            JSONArray innerArray = (JSONArray) text.get(i);

            if (innerArray.get(2) == null) {
                dialogs.add(new Dialog((String) innerArray.get(0),
                                       (String) innerArray.get(1),
                                       (String) innerArray.get(3)));
            } else {
                JSONArray choices = (JSONArray) dialogObject.get("choices");
                JSONObject choiceObject = (JSONObject) choices.get((((Long) innerArray.get(2)).intValue()));

                List<Object> contents = List.of(choiceObject.get("contents"));
                List<Object> effect0 = List.of(choiceObject.get("effect0"));
                List<Object> effect1 = List.of(choiceObject.get("effect1"));

                dialogs.add(new ChoiceDialog((String) innerArray.get(0),
                                             (String) innerArray.get(1),
                                             (String) innerArray.get(3),
                                             new Choice(contents, effect0, effect1)));
            }
        }

        return dialogs;
    }
}
