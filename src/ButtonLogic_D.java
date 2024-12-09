import javax.swing.*;
import java.io.File;

/**
 * Class responsible for creating the play and quit buttons on the main screen.
 * Choice buttons are handled separately in ChoiceButtonLogic.java.
 */
public class ButtonLogic_D {

    /**
     * Creates and returns the Play button.
     *
     * @param frame The main frame for the game.
     * @return The Play button.
     */
    public static JButton playButton(JFrame frame) {
        return new PlayButton(frame);
    }

    /**
     * Creates and returns the Quit button.
     *
     * @return The Quit button.
     */
    public static JButton quitButton() {
        return new QuitButton();
    }

    /**
     * Concrete implementation of the Play button.
     */
    private static class PlayButton extends AbstractGameButton {
        private JFrame frame;

        /**
         * Constructs a PlayButton.
         *
         * @param frame The main frame for the game.
         */
        public PlayButton(JFrame frame) {
            super("Jugar");
            this.frame = frame;
        }

        /**
         * Defines the action when the Play button is clicked (loads the game scene).
         */
        @Override
        protected void onClick() {
            SceneLoaderGUI gameGui = new SceneLoaderGUI(frame, new Scene(new File("Act1_scene1.json")));
            frame.add(gameGui);
            frame.setVisible(true);
        }
    }

    /**
     * Concrete implementation of the Quit button.
     */
    private static class QuitButton extends AbstractGameButton {

        /**
         * Constructs a QuitButton.
         */
        public QuitButton() {
            super("Salir");
        }

        /**
         * Defines the action when the Quit button is clicked (exits the application).
         */
        @Override
        protected void onClick() {
            System.exit(0);
        }
    }
}
