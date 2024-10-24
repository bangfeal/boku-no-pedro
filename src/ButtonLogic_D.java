import javax.swing.*;
import java.io.File;

/**
 * Class that handles the creation of the play and quit buttons
 * on the main screen, coded by @Jebus. Choice buttons are in
 * ChoiceButtonLogic.java because they are too different to implement them here
 */
public abstract class ButtonLogic_D extends AbstractGameButton {

    private static JFrame frame;

    protected ButtonLogic_D(String text, JFrame frame) {
        super(text);
        ButtonLogic_D.frame = frame; // Store the frame for later use
    }

    public static JButton playButton(JFrame frame) {
        return new AbstractGameButton("Jugar") {
            @Override
            protected void onClick() {
                SceneLoaderGUI gameGui = new SceneLoaderGUI(frame, new Scene(new File("Act1_scene1.json"))); // Loads JSON act 1 scene 1
                frame.add(gameGui);
                frame.setVisible(true);
            }
        };
    }

    public static JButton quitButton() {
        return new AbstractGameButton("Salir") {
            @Override
            protected void onClick() {
                System.exit(0);
            }
        };
    }
}
