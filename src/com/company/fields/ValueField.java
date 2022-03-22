package com.company.fields;

import com.company.utils.ColorManager;
import com.company.utils.FontManager;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

public class ValueField extends JFormattedTextField {

    public ValueField() {
        NumberFormat format = NumberFormat.getIntegerInstance();
        format.setGroupingUsed(false);
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setAllowsInvalid(false);
        formatter.setMinimum(0);
        formatter.setMaximum(9999);
        setFormatter(formatter);

        setPreferredSize(new Dimension(32, 12));
        setBorder(BorderFactory.createLineBorder(ColorManager.primary, 1));
        setBackground(ColorManager.secondary);
        setFont(FontManager.secondary);
        setHorizontalAlignment(CENTER);
    }

}
