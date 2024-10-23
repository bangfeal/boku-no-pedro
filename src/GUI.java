import javax.swing.*;

/*   This GUI class handles sharing the JFrame between the Menu
 *   and the SceneLoading for the game.
 *   Layout and methods for these are handled separately in
 *   their own classes.
 *
 *   ~ bangfeal (2024)
 */


public class GUI {
    private JFrame frame;

    GUI() {
        frame = new JFrame("Boku no Pedro!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(1280, 720);
    }

    public JFrame getFrame() { return frame; }
}
