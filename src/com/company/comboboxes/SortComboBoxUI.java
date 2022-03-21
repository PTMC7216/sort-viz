package com.company.comboboxes;

import com.company.utils.ColorManager;
import com.company.utils.FontManager;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;

public class SortComboBoxUI extends BasicComboBoxUI {

    @Override
    protected void installDefaults() {
        super.installDefaults();

        LookAndFeel.uninstallBorder(comboBox);
        comboBox.setBorder(BorderFactory.createLineBorder(ColorManager.primary, 1));

        Color sharedBackground = ColorManager.secondary;
        UIManager.put("ComboBox.selectionBackground", new ColorUIResource(sharedBackground));
        UIManager.put("ComboBox.background", new ColorUIResource(sharedBackground));

        comboBox.setFont(FontManager.secondary);

        comboBox.setPreferredSize(new Dimension(147, 18));

        comboBox.setRenderer(new Renderer());

    }

    @Override
    protected JButton createArrowButton() {
        UIManager.put("ComboBox.buttonBackground", new ColorUIResource(ColorManager.secondary));
        UIManager.put("ComboBox.buttonShadow", new ColorUIResource(ColorManager.primary));
        UIManager.put("ComboBox.buttonDarkShadow", new ColorUIResource(Color.BLACK));
        UIManager.put("ComboBox.buttonHighlight", new ColorUIResource(ColorManager.tertiary));

        JButton button = new BasicArrowButton(BasicArrowButton.SOUTH,
                UIManager.getColor("ComboBox.buttonBackground"),
                UIManager.getColor("ComboBox.buttonShadow"),
                UIManager.getColor("ComboBox.buttonDarkShadow"),
                UIManager.getColor("ComboBox.buttonHighlight"));
        button.setName("ComboBox.arrowButton");

        return button;
    }

    private static class Renderer extends DefaultListCellRenderer {

        public Component getListCellRendererComponent(JList list,
                                                      Object value,
                                                      int index,
                                                      boolean isSelected,
                                                      boolean cellHasFocus) {

            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            setHorizontalAlignment(SwingConstants.CENTER);

            if (isSelected) {
                setBackground(ColorManager.primary);
            }
            else {
                setBackground(ColorManager.secondary);
            }

            return this;
        }
    }

}
