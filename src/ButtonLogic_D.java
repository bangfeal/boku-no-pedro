import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ButtonLogic_D {

    public static JButton playButton(JFrame frame) {
        JButton playButton = new JButton("Jugar");

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                frame.getContentPane().removeAll();
                frame.add(theFunny());
                frame.revalidate();
                frame.repaint();
                // TODO - METER LOGICA PARA EMPEZAR
                 */

                SceneLoaderGUI gui = new SceneLoaderGUI(frame, new Scene(new File("scene0.json")));
                frame.add(gui);
                frame.setVisible(true);
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

