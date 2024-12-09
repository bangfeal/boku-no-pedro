import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Represents the main menu GUI of the game, which is displayed when the game starts.
 * After clicking the Play button, the {@link ButtonLogic_D} class triggers the loading of the main game area
 * through {@link SceneLoaderGUI}. This class handles the setup and layout of the main menu interface.
 */
public class GUI {
    protected JFrame frame;
    private JLabel bottomCredits;
    protected Image backgroundImage;

    /**
     * Initializes the main menu GUI by setting up the frame, creating components,
     * and laying them out. The window is made visible at the end.
     */
    public GUI() {
        initializeFrame();
        createComponents();
        layoutComponents();
        frame.setVisible(true);
    }

    /**
     * Sets up the main frame of the application, including its title, close operation,
     * size, and layout. Also sets the application icon.
     */
    private void initializeFrame() {
        frame = new JFrame("Boku No Pedro!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setResizable(false);          //Temporary until the layout is finalized
        frame.setLayout(new BorderLayout());

        // Set app icon
        ImageIcon image = new ImageIcon("images/appIcon.png");
        frame.setIconImage(image.getImage());
    }

    /**
     * Creates and initializes the components for the main menu, including the credits label
     * and background image.
     */
    private void createComponents() {
        bottomCredits = new JLabel("Creditos: Disenado y programado por Felix Arcaya y Roman Palchevskiy");
        bottomCredits.setHorizontalAlignment(SwingConstants.CENTER);
        bottomCredits.setForeground(Color.WHITE);

        // Load the background image
        try {
            File menuImg = new File("src/images/MainMenu.png");
            backgroundImage = ImageIO.read(menuImg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a custom JPanel that draws the background image.
     *
     * @return a JPanel that paints the background image
     */
    protected JPanel createBackgroundPanel() {
        return new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
    }

    /**
     * Lays out the components on the frame, including the background panel, credits,
     * and buttons (Play, Quit).
     */
    private void layoutComponents() {
        JPanel backgroundPanel = createBackgroundPanel();
        backgroundPanel.setLayout(new BorderLayout());

        // Add components on top of the background panel
        backgroundPanel.add(bottomCredits, BorderLayout.SOUTH);
        backgroundPanel.add(createButtonPanel(), BorderLayout.CENTER);

        frame.setContentPane(backgroundPanel);
        frame.revalidate();
        frame.repaint();
    }

    /**
     * Creates the panel containing the buttons (Play and Quit) for the main menu.
     *
     * @return a JPanel with the buttons arranged vertically
     */
    protected JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setOpaque(false); // Make the button panel transparent to show the background
        buttonPanel.setPreferredSize(new Dimension(500, 720));

        JButton playButton = ButtonLogic_D.playButton(frame);
        JButton quitButton = ButtonLogic_D.quitButton();

        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.add(playButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        buttonPanel.add(quitButton);
        buttonPanel.add(Box.createVerticalGlue());

        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        return buttonPanel;
    }

    /**
     * @return the JFrame for the main menu
     */
    public JFrame getGUIFrame() {
        return frame;
    }
}
