import javax.swing.*;
import java.awt.*;

/**
 * Abstract base class for game buttons such as menu and choice buttons.
 * Sets custom font, background, and preferred size, and provides an
 * abstract {@code onClick} method to define button click behavior.
 */
public abstract class AbstractGameButton extends JButton {

    /**
     * Initializes the button with specified text, custom font, background,
     * and preferred size. Adds an action listener to trigger {@code onClick}.
     *
     * @param text the button's display text
     */
    public AbstractGameButton(String text) {
        super(text);
        setFont(VisualInfo.buttonFont);
        setBackground(VisualInfo.buttonBackground);
        setPreferredSize(new Dimension(360, 80));
        addActionListener(e -> onClick());
    }

    /**
     * Defines the behavior on button click. Must be implemented by subclasses.
     */
    protected abstract void onClick();
}
