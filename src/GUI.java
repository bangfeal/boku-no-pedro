import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Main menu GUI class that sets up and displays the main menu for the game.
 */
public class GUI {
    protected JFrame frame;
    private JLabel bottomCredits;
    protected Image backgroundImage;

    private final int width = 1800;
    private final int height = width * 9 / 16;

    /**
     * Constructs the main menu GUI and initializes its components.
     */
    public GUI() {
        initializeFrame();
        createComponents();
        layoutComponents();
        frame.setVisible(true);
    }

    /**
     * Initializes the main frame for the menu.
     */
    private void initializeFrame() {
        frame = new JFrame("Boku No Pedro!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setResizable(false);  // Temporary until resolution is fixed
        frame.setLayout(new BorderLayout());

        // Set app icon
        ImageIcon image = new ImageIcon("images/appIcon.png");
        frame.setIconImage(image.getImage());
    }

    /**
     * Creates the components for the menu, including the background and credits label.
     */
    private void createComponents() {
        bottomCredits = new JLabel("Creditos: Diseñado y programado por Felix Arcaya y Roman Palchevskiy");
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
     * Creates a custom panel to display the background image.
     *
     * @return A JPanel displaying the background image.
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
     * Lays out the components in the main menu, including the background and buttons.
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
     * Creates the panel containing the Play and Quit buttons.
     *
     * @return A JPanel containing the Play and Quit buttons.
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
}
