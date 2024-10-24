import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ChoiceButtonLogic {

    public static JButton createChoiceButton(SceneLoaderGUI gui, Choice choice) {
        return new ChoiceButton(gui, choice);
    }

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
            // Load the new scene when the button is clicked
            Scene newScene = new Scene(choice.getScene());
            gui.loadNewScene(newScene);
        }
    }
}
