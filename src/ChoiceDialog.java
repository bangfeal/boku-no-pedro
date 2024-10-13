public class ChoiceDialog extends Dialog {
    private final Choice choice;

    ChoiceDialog(String character, String text, String currentSprite, Choice choice) {
        super(character, text, currentSprite);
        this.choice = choice;
    }

    @Override
    public boolean hasChoice() {
        return true;
    }
}
