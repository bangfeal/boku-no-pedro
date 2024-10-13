public class Dialog {
    private String character; // Should change to a Character object once the
                              // GUI passing is complete
    private String text,
                   currentSprite;

    Dialog(String character, String currentSprite, String text) {
        this.character = character;
        this.text = text;
        this.currentSprite = currentSprite;
    }

    public boolean hasChoice() {
        return false;
    }

    public String getText() { return text; }
    public String getCharacter() { return character; }
}
