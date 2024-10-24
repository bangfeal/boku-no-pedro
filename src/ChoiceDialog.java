public class ChoiceDialog extends Dialog {
    final Choice choice0;
    final Choice choice1;

    ChoiceDialog(String character, String text, String currentSprite, Choice choice0, Choice choice1) {
        super(character, text, currentSprite);
        this.choice0 = choice0;
        this.choice1 = choice1;
    }

    @Override
    public boolean hasChoice() {
        return true;
    }
}
