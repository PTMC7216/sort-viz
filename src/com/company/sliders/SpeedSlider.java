package com.company.sliders;

import com.company.utils.ColorManager;
import com.company.utils.FontManager;

import javax.swing.*;
import java.awt.*;

public class SpeedSlider extends JSlider {

    private final JLabel id;
    private final JLabel value;

    public SpeedSlider() {
        this.setPreferredSize(new Dimension(113, 16));
        this.setBackground(ColorManager.secondary);
        this.setOrientation(0);
        this.setMinimum(1);
        this.setMaximum(10);
        this.setValue(1);

        id = new JLabel("Sorting speed");
        id.setFont(FontManager.secondary);

        value = new JLabel(String.valueOf(this.getValue()));
        value.setFont(FontManager.secondary);
        value.setPreferredSize(new Dimension(22, 12));

        this.addChangeListener(e -> value.setText(String.valueOf(this.getValue())));
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
