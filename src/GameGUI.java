import javax.swing.*;
import java.awt.*;

public class GameGUI {
    private JFrame frame;
    private JPanel ImagePanel,CharacterName;
    private JTextArea dialogueArea;

    public GameGUI(JFrame frame) {
        this.frame = frame;
        frame.getContentPane().removeAll(); // Clear existing components to transition to the game screen
        frame.revalidate();
        frame.repaint();
        frame.setLayout(new BorderLayout());


        frame.setVisible(true);
    }
}
