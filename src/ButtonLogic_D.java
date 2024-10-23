import javax.swing.*;
import java.io.File;

/**
 * Class that handles the creation of the play and quit buttons
 * on the main screen, coded by @Jebus. Choice buttons are in
 * ChoiceButtonLogic.java because they are too different to implement them here
 */


public class ButtonLogic_D {

    public static JButton playButton(JFrame frame) {
        return new PlayButton(frame);
    }

    public static JButton quitButton() {
        return new QuitButton();
    }

    // Concrete implementation for the Play button
    private static class PlayButton extends AbstractGameButton {
        private JFrame frame;

        public PlayButton(JFrame frame) {
            super("Jugar");
            this.frame = frame;
        }

        @Override
        protected void onClick() {
            SceneLoaderGUI gui = new SceneLoaderGUI(frame, new Scene(new File("scene0.json")));
            frame.add(gui);
            frame.setVisible(true);
        }
    }

    // Concrete implementation for the Quit button
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
