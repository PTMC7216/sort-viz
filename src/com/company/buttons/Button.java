package com.company.buttons;

import com.company.utils.ColorManager;
import com.company.utils.FontManager;

import javax.swing.*;
import java.awt.*;

public abstract class Button extends JButton {

    public Button() {
        setPreferredSize(new Dimension(70, 20));

        setBackground(ColorManager.SECONDARY);
        setBorder(BorderFactory.createBevelBorder(0));

        setFont(FontManager.PRIMARY);
        setText("Button");
        setFocusable(false);
    }

}
