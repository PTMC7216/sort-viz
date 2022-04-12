package com.company.sliders;

import com.company.texts.IntField;
import com.company.utils.ColorManager;
import com.company.utils.FontManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public abstract class Slider extends JSlider {

    protected final JLabel label;
    protected final IntField field;

    public Slider(String name, int maxCharacters) {
        setUI(new SliderUI(this));

        label = new JLabel(name);
        label.setFont(FontManager.SECONDARY);

        field = new IntField(maxCharacters);
        field.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, ColorManager.PRIMARY));
        field.addActionListener(e -> processText());
        field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                field.selectAll();
            }

            @Override
            public void focusLost(FocusEvent e) {
                processText();
            }
        });

        addChangeListener(e -> field.setText(String.valueOf(getValue())));
    }

    public JPanel container() {
        JPanel panel = new JPanel();

        panel.addMouseWheelListener(e -> setValue(getValue() - e.getWheelRotation()));

        panel.setBackground(ColorManager.SECONDARY);
        panel.setBorder(BorderFactory.createLineBorder(ColorManager.PRIMARY, 1));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panel.add(label, gbc);

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
        panel.add(field, gbc);

        return panel;
    }

    private void processText() {
        if (field.getText().isEmpty()) {
            field.setText("0");
        }
        else if (field.getText().startsWith("0")) {
            field.setText(field.getText().replaceAll("^0+(?!$)", ""));
        }

        if (Integer.parseInt(field.getText()) < getMinimum()) {
            field.setText(String.valueOf(getMinimum()));
        }
        else if (Integer.parseInt(field.getText()) > getMaximum()) {
            field.setText(String.valueOf(getMaximum()));
        }

        setValue(Integer.parseInt(field.getText()));
    }

}
