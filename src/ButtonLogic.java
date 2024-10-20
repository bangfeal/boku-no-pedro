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
                GameGUI inGame = new GameGUI(frame);
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
}

