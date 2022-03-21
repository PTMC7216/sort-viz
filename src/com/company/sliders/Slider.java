package com.company.sliders;

import com.company.utils.ColorManager;
import com.company.utils.FontManager;

import javax.swing.*;
import java.awt.*;

public class Slider extends JSlider {

    protected final JLabel id;
    protected final JLabel value;

    public Slider() {
        setPreferredSize(new Dimension(113, 16));
        setBackground(ColorManager.secondary);
        setOrientation(0);
        setMinimum(1);
        setMaximum(1000);
        setValue(1);

        id = new JLabel("Slider");
        id.setFont(FontManager.secondary);

        value = new JLabel(String.valueOf(getValue()));
        value.setFont(FontManager.secondary);
        value.setPreferredSize(new Dimension(32, 12));

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
        gbc.weightx = 1;
        gbc.weighty = 1;
        panel.add(id, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        panel.add(this, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipady = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        panel.add(value, gbc);

        return panel;
    }

}
