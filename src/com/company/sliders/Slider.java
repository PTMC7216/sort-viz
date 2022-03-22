package com.company.sliders;

import com.company.fields.ValueField;
import com.company.utils.ColorManager;
import com.company.utils.FontManager;

import javax.swing.*;
import java.awt.*;

public class Slider extends JSlider {

    protected final JLabel id;
    protected final ValueField value;

    public Slider() {
        setPreferredSize(new Dimension(113, 16));
        setBackground(ColorManager.secondary);
        setOrientation(0);
        setMinimum(1);
        setMaximum(1000);
        setValue(1);

        id = new JLabel("Slider");
        id.setFont(FontManager.secondary);

        value = new ValueField();
        value.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, ColorManager.primary));
        value.addActionListener(e -> setValue((Integer) value.getValue()));

        // TODO: Fix ValueField allowing invalid characters
        //  when clicking in and out of different ValueFields
        //  despite formatter.setAllowsInvalid(false)

        addChangeListener(e -> value.setText(String.valueOf(getValue())));
    }

    public JPanel container() {
        JPanel panel = new JPanel();
        panel.setBackground(ColorManager.secondary);
        panel.setBorder(BorderFactory.createLineBorder(ColorManager.primary, 1));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panel.add(id, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panel.add(this, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.ipady = 1;
        gbc.fill = 1;
        panel.add(value, gbc);

        return panel;
    }

}
