import java.util.*;

public class Character {
    private String nombre;
    private List<String> sprites;
    private String currentSprite;

    Character(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
