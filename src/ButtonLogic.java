import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonLogic {

    public static JButton playButton(JFrame frame) {
        JButton playButton = new JButton("Jugar");

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll();
                frame.add(theFunny());
                frame.revalidate();
                frame.repaint();
                // TODO - METER LOGICA PARA EMPEZAR
            }
        });
        playButton.setFont(VisualInfo.buttonFont);
        playButton.setBackground(VisualInfo.buttonBackground);
        playButton.setPreferredSize(new Dimension(180,80));

        return playButton;
    }

    public static JButton quitButton() {
        JButton quitButton = new JButton("Salir");

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        quitButton.setFont(VisualInfo.buttonFont);
        quitButton.setBackground(VisualInfo.buttonBackground);
        quitButton.setPreferredSize(new Dimension(180,80));

        return quitButton;
    }

    private static JPanel theFunny() {
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BorderLayout());

        ImageIcon imageIcon = new ImageIcon("images/sprites/PedroSanchez2.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        imagePanel.add(imageLabel, BorderLayout.CENTER);

        imagePanel.setPreferredSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));

        return imagePanel;
    }
}

