/**
 * Represents a dialog with two choices for the player to make.
 * Extends the {@link Dialog} class and adds support for two {@link Choice} objects.
 */
public class ChoiceDialog extends Dialog {
    final Choice choice0;
    final Choice choice1;

    /**
     * Constructs a new {@code ChoiceDialog} with the specified character, dialog text,
     * current sprite, and two choices.
     *
     * @param character the name of the character presenting the dialog
     * @param text the dialog text
     * @param currentSprite the current sprite of the character
     * @param choice0 the first choice
     * @param choice1 the second choice
     */
    ChoiceDialog(String character, String text, String currentSprite, Choice choice0, Choice choice1) {
        super(character, text, currentSprite);
        this.choice0 = choice0;
        this.choice1 = choice1;
    }

    /**
     * @return {@code true} since this dialog always has choices
     * *until we implement the ending scene
     */
    @Override
    public boolean hasChoice() {
        return true;
    }
}
