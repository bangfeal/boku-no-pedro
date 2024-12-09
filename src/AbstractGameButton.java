import javax.swing.*;
import java.awt.*;

/**
 * Small abstract class for us to be able to implement buttons such as the menu PLAY & QUIT
 * as well as CHOICE buttons in-game
 */

public abstract class AbstractGameButton extends JButton {
    public AbstractGameButton(String text) {
        super(text);
        setFont(VisualInfo.buttonFont);
        setBackground(VisualInfo.buttonBackground);
        setPreferredSize(new Dimension(360, 80));
        addActionListener(e -> onClick());
    }

    protected abstract void onClick();
}
