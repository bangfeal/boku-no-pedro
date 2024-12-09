/**
 * Represents a dialog in the game, typically displayed by a character with associated text and sprite.
 */
public class Dialog {
    private String character;
    private String text;
    private String currentSprite;

    /**
     * Constructs a new {@code Dialog} with the specified character, sprite, and text.
     *
     * @param character the name of the character presenting the dialog
     * @param currentSprite the current sprite of the character
     * @param text the dialog text to be displayed
     */
    Dialog(String character, String currentSprite, String text) {
        this.character = character;
        this.text = text;
        this.currentSprite = currentSprite;
    }

    /**
     * @return {@code false} as this dialog has no choices
     */
    public boolean hasChoice() {
        return false;
    }

    /**
     * @return the dialog text
     */
    public String getText() {
        return text;
    }

    /**
     * @return the character's name
     */
    public String getCharacter() {
        return character;
    }

    /**
     * @return the character's current sprite
     */
    public String getCurrentSprite() {
        return currentSprite;
    }
}
