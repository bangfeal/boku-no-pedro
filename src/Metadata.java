import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Metadata {
    private String name, decidingFactor, background;
    private List<File> nextScenes = new ArrayList<>();

    public Metadata(String nombre, String decidingFactor, String background, List<File> nextScenes) {
        this.name = nombre;
        this.decidingFactor = decidingFactor;
        this.background = background;
        this.nextScenes = nextScenes;
    }

    public String getName() {
        return name;
    }

    public String getDecidingFactor() {
        return decidingFactor;
    }

    public List<File> getNextScenes() {
        return nextScenes;
    }

    public String getBackground() {
        return background;
    }
}
