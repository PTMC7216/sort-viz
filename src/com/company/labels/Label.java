package com.company.labels;

import com.company.utils.FontManager;

import javax.swing.*;
import java.awt.*;

public abstract class Label extends JLabel {

    public Label() {
        setFont(FontManager.SECONDARY);
        setPreferredSize(new Dimension(147, 22));
        setHorizontalAlignment(SwingConstants.LEFT);
        setVerticalAlignment(SwingConstants.TOP);
    }

}
