import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * MAIN MENU GUI WORKED ON BY @JEBUS. AFTER CLICKING PLAY ButtonLogic.Java calls in GameGUI.java WHICH HANDLES THE
 * MAIN PLAYING AREA FOR THE PLAYER (AND IT INTERECATS WITH THE REST OF THE CLASSES)
 */

public class GUI {
    protected JFrame frame;
    private JLabel bottomCredits;
    protected Image backgroundImage;

    public GUI() {
        initializeFrame();
        createComponents();
        layoutComponents();
        frame.setVisible(true);
    }

    private void initializeFrame() {
        frame = new JFrame("Boku No Pedro!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setResizable(false);          //Temporary until I figure out how to make shit work
        frame.setLayout(new BorderLayout());

        // Set app icon
        ImageIcon image = new ImageIcon("images/appIcon.png");
        frame.setIconImage(image.getImage());
    }

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

    // Create a custom panel to draw the background image
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