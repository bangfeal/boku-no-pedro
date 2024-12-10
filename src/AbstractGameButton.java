import javax.swing.*;
import java.awt.*;

/**
 * Abstract class for creating in-game and menu buttons (e.g., PLAY, QUIT, CHOICE).
 */
public abstract class AbstractGameButton extends JButton {

    /**
     * Constructs an AbstractGameButton with specified text.
     *
     * @param text The text to display on the button.
     */
    public AbstractGameButton(String text) {
        super(text);
        setFont(VisualInfo.buttonFont);
        setBackground(VisualInfo.buttonBackground);
        setPreferredSize(new Dimension(360, 80));
        addActionListener(e -> onClick());
    }

    /**
     * Abstract method to handle button click action.
     */
    protected abstract void onClick();
}
