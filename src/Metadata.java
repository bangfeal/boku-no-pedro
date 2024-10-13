import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Metadata {
    private String name, decidingFactor;
    private List<File> nextScenes = new ArrayList<>();

    public Metadata(String nombre, String decidingFactor, List<File> nextScenes) {
        this.name = nombre;
        this.decidingFactor = decidingFactor;
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
}
