package main.java.sortvisualizer.labels;

import main.java.sortvisualizer.utils.FontManager;

import javax.swing.*;
import java.awt.*;

public class GitVersionLabel extends JLabel {

    public GitVersionLabel() {
        setFont(FontManager.SECONDARY);
        setPreferredSize(new Dimension(50, 22));
        setVerticalAlignment(SwingConstants.BOTTOM);
        setFocusable(false);
        setText("v0.1.1");
    }

}
