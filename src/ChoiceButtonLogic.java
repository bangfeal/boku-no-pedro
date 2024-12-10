import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Class that handles the creation of choice buttons in the game.
 */
public class ChoiceButtonLogic {

    /**
     * Creates and returns a Choice button.
     *
     * @param gui The SceneLoaderGUI instance for scene management.
     * @param choice The Choice object representing the choice's text and scene.
     * @return The created Choice button.
     */
    public static JButton createChoiceButton(SceneLoaderGUI gui, Choice choice) {
        return new ChoiceButton(gui, choice);
    }

    /**
     * Concrete implementation of a Choice button.
     */
    private static class ChoiceButton extends AbstractGameButton {
        private final SceneLoaderGUI gui;
        private final Choice choice;

        /**
         * Constructs a ChoiceButton.
         *
         * @param gui The SceneLoaderGUI instance for scene management.
         * @param choice The Choice object representing the choice's text and scene.
         */
        public ChoiceButton(SceneLoaderGUI gui, Choice choice) {
            super(choice.getText());
            this.gui = gui;
            this.choice = choice;
        }

        /**
         * Defines the action when the Choice button is clicked (loads the new scene).
         */
        @Override
        protected void onClick() {
            // Load the new scene when the button is clicked
            Scene newScene = new Scene(choice.getScene());
            gui.loadNewScene(newScene);
        }
    }
}
