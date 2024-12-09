/**
 * Represents a dialog with two choices in the game.
 */
public class ChoiceDialog extends Dialog {
    final Choice choice0;
    final Choice choice1;

    /**
     * Constructs a ChoiceDialog with the given character, text, sprite, and choices.
     *
     * @param character The name of the character in the dialog.
     * @param text The text of the dialog.
     * @param currentSprite The current sprite to display.
     * @param choice0 The first choice in the dialog.
     * @param choice1 The second choice in the dialog.
     */
    ChoiceDialog(String character, String text, String currentSprite, Choice choice0, Choice choice1) {
        super(character, text, currentSprite);
        this.choice0 = choice0;
        this.choice1 = choice1;
    }

    /**
     * Indicates that this dialog has choices.
     *
     * @return true, as the dialog includes choices.
     */
    @Override
    public boolean hasChoice() {
        return true;
    }
}
