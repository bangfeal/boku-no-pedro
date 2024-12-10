/**
 * Represents a dialog with a character, text, and sprite.
 */
public class Dialog {
    private String character;
    private String text, currentSprite;

    /**
     * Constructs a Dialog with the given character, sprite, and text.
     *
     * @param character The name of the character in the dialog.
     * @param currentSprite The current sprite to display.
     * @param text The text of the dialog.
     */
    Dialog(String character, String currentSprite, String text) {
        this.character = character;
        this.text = text;
        this.currentSprite = currentSprite;
    }

    /**
     * Indicates that this dialog does not have choices.
     *
     * @return false, as the dialog does not have choices.
     */
    public boolean hasChoice() {
        return false;
    }

    /**
     * Gets the text of the dialog.
     *
     * @return The text of the dialog.
     */
    public String getText() { return text; }

    /**
     * Gets the character associated with the dialog.
     *
     * @return The character's name.
     */
    public String getCharacter() { return character; }

    /**
     * Gets the current sprite associated with the dialog.
     *
     * @return The current sprite.
     */
    public String getCurrentSprite() { return currentSprite; }
}
