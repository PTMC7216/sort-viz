package main.java.sortvisualizer.labels;

import main.java.sortvisualizer.utils.FontManager;

import javax.swing.*;
import java.awt.*;

public abstract class Label extends JLabel {

    public Label() {
        setFont(FontManager.SECONDARY);
        setPreferredSize(new Dimension(147, 20));
        setHorizontalAlignment(SwingConstants.LEFT);
        setVerticalAlignment(SwingConstants.TOP);
    }

}
