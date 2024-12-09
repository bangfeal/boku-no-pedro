import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class SceneLoaderGUI extends JPanel {
    private JFrame frame;
    private Scene scene;
    private JPanel choicePanel;

    // Uses a default 16:9 aspect ratio
    private final int width = 1920;
    private final int height = width * 9 / 16;
    private boolean clicked = false;

    public SceneLoaderGUI(JFrame frame, Scene scene) {
        this.frame = frame;
        this.scene = scene;
        initializeGUI();

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!scene.getCurrentDialog().hasChoice() && !clicked) {
                    scene.increment();
                    clicked = true;
                    repaint();
                }
            }
        });
    }

    private void initializeGUI() {
        frame.getContentPane().removeAll();
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);

        choicePanel = new JPanel();
        choicePanel.setLayout(new FlowLayout());
        choicePanel.setOpaque(false); // Make the panel transparent
        choicePanel.setVisible(false); // Initially hide it until choices appear

        this.setLayout(new BorderLayout());
        this.add(choicePanel, BorderLayout.SOUTH);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;
        g.setFont(new Font("Cantarell", Font.PLAIN, 25));

        if (!scene.isOver()) {
            try {
                graphics.drawImage(ImageIO.read(scene.getBackground()), 0, 0, width, height, this);
                graphics.drawImage(ImageIO.read(new File(scene.getCurrentDialog().getCurrentSprite())), 550, 100, 850, 1500, this);

                graphics.drawImage(ImageIO.read(new File("text_box.png")), 450, 700, this);
                graphics.drawString(scene.getCurrentDialog().getText(), 545, 800);

                if (scene.getCurrentDialog().hasChoice()) {
                    showChoiceButtons();
                } else {
                    hideChoiceButtons();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        clicked = false;
    }

    private void showChoiceButtons() {
        choicePanel.removeAll();

        ChoiceDialog choiceDialog = (ChoiceDialog) scene.getCurrentDialog();
        JButton choice0 = ChoiceButtonLogic.createChoiceButton(this, choiceDialog.choice0);
        JButton choice1 = ChoiceButtonLogic.createChoiceButton(this, choiceDialog.choice1);

        choicePanel.add(choice0);
        choicePanel.add(choice1);
        choicePanel.setVisible(true);
        revalidate();
        repaint();
    }

    private void hideChoiceButtons() {
        choicePanel.setVisible(false);
    }

    public void loadNewScene(Scene newScene) {
        this.scene = newScene;
        repaint();
    }
}
