import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Handles the creation and behavior of choice buttons in the game.
 */
public class ChoiceButtonLogic {

    /**
     * Creates a choice button associated with a specific {@link Choice} and {@link SceneLoaderGUI}.
     *
     * @param gui the SceneLoaderGUI instance to associate with the button
     * @param choice the Choice object that the button represents
     * @return the created choice button
     */
    public static JButton createChoiceButton(SceneLoaderGUI gui, Choice choice) {
        return new ChoiceButton(gui, choice);
    }

    /**
     * Concrete implementation of a choice button.
     */
    private static class ChoiceButton extends AbstractGameButton {
        private final SceneLoaderGUI gui;
        private final Choice choice;

        public ChoiceButton(SceneLoaderGUI gui, Choice choice) {
            super(choice.getText());
            this.gui = gui;
            this.choice = choice;
        }

        @Override
        protected void onClick() {
            // Load the new scene associated with the choice
            Scene newScene = new Scene(choice.getScene());
            gui.loadNewScene(newScene);
        }
    }
}
