import javax.swing.*;
import java.awt.*;

/**
 * GUI Developed by @Jebus.
 * This class handles the main GUI setup and layout for the game.
 */
public class GUI_D {
    private JFrame frame;
    private JLabel mainTitle;
    private JLabel bottomCredits;

    public GUI_D() {
        initializeFrame();
        createComponents();
        layoutComponents();
        frame.setVisible(true);
    }

    public void initializeFrame() {
        frame = new JFrame("Boku No Pedro!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLayout(new BorderLayout());

        // Set app icon and background color
        ImageIcon image = new ImageIcon("images/appIcon.png");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(VisualInfo.background);
    }

    private void createComponents() {
        mainTitle = createLabel("Boku no Pedro!", VisualInfo.menuFont, VisualInfo.menuFontColor);
        bottomCredits = new JLabel("Creditos: Disenado y programado por Felix Arcaya y Roman Palchevskiy");
    }

    private JLabel createLabel(String text, Font font, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        label.setForeground(color);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(VisualInfo.background);
        buttonPanel.setPreferredSize(new Dimension(250, 720));

        JButton playButton = ButtonLogic_D.playButton(frame);
        JButton quitButton = ButtonLogic_D.quitButton();

        buttonPanel.add(Box.createVerticalGlue());
        buttonPanel.add(playButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        buttonPanel.add(quitButton);
        buttonPanel.add(Box.createVerticalGlue());

        return buttonPanel;
    }

    private JPanel createTitlePanel() {
        // Create and resize the game logo
        ImageIcon logoIcon = new ImageIcon("images/GameLogoTOP.png");
        Image logoImage = logoIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(logoImage));
        logoLabel.setBorder(BorderFactory.createEmptyBorder(10, 1, 10, 30));

        // Create a panel for the logo and title
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(VisualInfo.background);
        titlePanel.add(logoLabel);
        titlePanel.add(mainTitle);

        return titlePanel;
    }

    private void layoutComponents() {
        frame.add(createTitlePanel(), BorderLayout.NORTH);
        frame.add(bottomCredits, BorderLayout.SOUTH);
        frame.add(createButtonPanel(), BorderLayout.EAST);
    }

    public JFrame getFrame() { return frame; }
}