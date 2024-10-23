public class Dialog {
    private String character;
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
    public String getCurrentSprite() { return currentSprite; }
}
