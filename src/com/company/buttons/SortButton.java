package com.company.buttons;

import com.company.utils.ColorManager;
import com.company.utils.FontManager;

import javax.swing.*;
import java.awt.*;

public class SortButton extends JButton {

    public SortButton() {
        this.setPreferredSize(new Dimension(65, 20));

        this.setBackground(ColorManager.secondary);
        this.setBorder(BorderFactory.createBevelBorder(0));

        this.setFont(FontManager.primary);
        this.setText("Sort");
        this.setFocusable(false);

    }

}
