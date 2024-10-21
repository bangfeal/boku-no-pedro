import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * GameGUI.java worked on by @Jebus - Handles the main visuals of the game such as the main "scene"
 * options, text box dialogue and so on. Handles tasks over to other classes.
 */

public class GameGUI extends JPanel {
    private JTextArea dialogueArea;
    private Image mainSceneBackground;

    public GameGUI(JFrame frame) {
        frame.getContentPane().removeAll(); // Clear existing components to transition to the game screen
        frame.setLayout(new BorderLayout());

        try {
            File sceneBackground = new File("src/images/MainSceneBackground.png");
            mainSceneBackground = ImageIO.read(sceneBackground);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create the background panel and add it to the frame
        JPanel backgroundPanel = createSceneBackground();
        frame.setContentPane(backgroundPanel);

        dialogueArea = new JTextArea(5, 20);
        dialogueArea.setEditable(false);        //TODO Replace later and adjust to fit JSON needs
        dialogueArea.setOpaque(false);
        backgroundPanel.add(dialogueArea, BorderLayout.SOUTH); // Positioning the dialogue area

        frame.revalidate();
        frame.repaint(); // Refreshes screen
        frame.setVisible(true);
    }

    private JPanel createSceneBackground() {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (mainSceneBackground != null) {
                    g.drawImage(mainSceneBackground, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
    }
}
