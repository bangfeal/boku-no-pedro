import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class SceneLoaderGUI extends JPanel {
    JFrame frame;
    Scene scene;

    // Uses a default 16:9 aspect ratio
    int width = 1920;
    int height = width * 9 / 16;

    boolean clicked = false;

    SceneLoaderGUI(JFrame frame, Scene scene) {
        this.scene = scene;
        this.frame = frame;
        frame.getContentPane().removeAll();
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clicked = true;
                repaint();
            }
        });
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

                if (clicked) {
                    scene.increment();
                    clicked = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
