import javax.swing.*;
import java.io.File;

/**
 * Class responsible for creating the play and quit buttons on the main screen.
 * Choice buttons are handled separately in {@link ChoiceButtonLogic}.
 */
public class ButtonLogic_D {

    /**
     * Creates the Play button and associates it with the provided frame.
     *
     * @param frame the JFrame to associate with the Play button
     * @return the created Play button
     */
    public static JButton playButton(JFrame frame) {
        return new PlayButton(frame);
    }

    /**
     * Creates the Quit button.
     *
     * @return the created Quit button
     */
    public static JButton quitButton() {
        return new QuitButton();
    }

    /**
     * Concrete implementation for the Play button.
     */
    private static class PlayButton extends AbstractGameButton {
        private JFrame frame;

        public PlayButton(JFrame frame) {
            super("Jugar");
            this.frame = frame;
        }

        @Override
        protected void onClick() {
            SceneLoaderGUI gameGui = new SceneLoaderGUI(frame, new Scene(new File("Act1_scene1.json")));
            frame.add(gameGui);
            frame.setVisible(true);
        }
    }

    /**
     * Concrete implementation for the Quit button.
     */
    private static class QuitButton extends AbstractGameButton {

        public QuitButton() {
            super("Salir");
        }

        @Override
        protected void onClick() {
            System.exit(0);
        }
    }
}
