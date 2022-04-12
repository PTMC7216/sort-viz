package com.company.texts;

import com.company.utils.ColorManager;
import com.company.utils.FontManager;

import javax.swing.*;
import java.awt.*;

public class DescriptionArea extends JTextArea {

    // TODO: Consider implementing
    public DescriptionArea() {
        setPreferredSize(new Dimension(147, 290));
        setBorder(BorderFactory.createLineBorder(ColorManager.PRIMARY, 1));
        setBackground(ColorManager.SECONDARY);
        setFont(FontManager.SECONDARY);
        setLineWrap(true);
        setWrapStyleWord(true);
        setFocusable(false);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        setText("");

    }

}
