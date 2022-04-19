package main.java.sortvisualizer.texts;

import main.java.sortvisualizer.utils.ColorManager;
import main.java.sortvisualizer.utils.IntDocFilter;
import main.java.sortvisualizer.utils.FontManager;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;

public class IntField extends JTextField {

    public IntField(int maxCharacters) {
        setPreferredSize(new Dimension(32, 12));
        setBorder(BorderFactory.createLineBorder(ColorManager.PRIMARY, 1));
        setBackground(ColorManager.SECONDARY);
        setFont(FontManager.SECONDARY);
        setHorizontalAlignment(CENTER);

        AbstractDocument doc = (AbstractDocument)getDocument();
        doc.setDocumentFilter(new IntDocFilter(maxCharacters));
    }
}
