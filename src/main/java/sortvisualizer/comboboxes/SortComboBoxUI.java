package main.java.sortvisualizer.comboboxes;

import main.java.sortvisualizer.utils.ColorManager;
import main.java.sortvisualizer.utils.FontManager;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.*;
import java.awt.*;

public class SortComboBoxUI extends BasicComboBoxUI {

    public SortComboBoxUI(JComboBox<String> b) {
        b.setFont(FontManager.SECONDARY);
        b.setPreferredSize(new Dimension(147, 18));
    }

    @Override
    protected void installDefaults() {
        super.installDefaults();
        LookAndFeel.uninstallBorder(comboBox);
        comboBox.setRenderer(new Renderer());
        comboBox.setBorder(BorderFactory.createLineBorder(ColorManager.PRIMARY, 1));
        Color sharedBackground = ColorManager.SECONDARY;
        UIManager.put("ComboBox.selectionBackground", new ColorUIResource(sharedBackground));
        UIManager.put("ComboBox.background", new ColorUIResource(sharedBackground));

    }

    @Override
    protected JButton createArrowButton() {
        return directionalButton(BasicArrowButton.SOUTH);
    }

    private static class Renderer extends DefaultListCellRenderer {
        public Component getListCellRendererComponent(JList list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            setHorizontalAlignment(CENTER);
            if (isSelected) {
                setBackground(ColorManager.PRIMARY);
            } else {
                setBackground(ColorManager.SECONDARY);
            }
            return this;
        }
    }

    @Override
    protected ComboPopup createPopup() {
        return new BasicComboPopup(comboBox) {
            @Override
            protected JScrollPane createScroller() {
                JScrollPane scroller = new JScrollPane(list,
                        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

                scroller.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                    @Override
                    protected void configureScrollBarColors() {
                        thumbHighlightColor = ColorManager.TERTIARY;
                        thumbLightShadowColor = ColorManager.PRIMARY;
                        thumbDarkShadowColor = ColorManager.QUATERNARY;
                        thumbColor = ColorManager.SECONDARY;
                        trackColor = ColorManager.SECONDARY;
                    }
                    @Override
                    protected JButton createDecreaseButton(int orientation) {
                        return directionalButton(BasicArrowButton.NORTH);
                    }
                    @Override
                    protected JButton createIncreaseButton(int orientation) {
                        return directionalButton(BasicArrowButton.SOUTH);
                    }
                    @Override
                    public Dimension getPreferredSize(JComponent c) {
                        return new Dimension(16, super.getPreferredSize(c).height);
                    }
                });
                return scroller;
            }
        };
    }

    private JButton directionalButton(int orientation) {
        JButton button = new BasicArrowButton(orientation,
                ColorManager.SECONDARY,
                ColorManager.PRIMARY,
                ColorManager.QUATERNARY,
                ColorManager.TERTIARY);
        button.setName("ComboBox.arrowButton");
        return button;
    }

}
