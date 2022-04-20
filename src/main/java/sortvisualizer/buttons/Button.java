package main.java.sortvisualizer.buttons;

import main.java.sortvisualizer.utils.ColorManager;
import main.java.sortvisualizer.utils.FontManager;

import javax.swing.*;
import java.awt.*;

public abstract class Button extends JButton {

    public Button() {
        setPreferredSize(new Dimension(70, 20));

        setBackground(ColorManager.SECONDARY);
        setBorder(BorderFactory.createBevelBorder(0));

        setFont(FontManager.PRIMARY);
        setFocusPainted(false);
    }

}
