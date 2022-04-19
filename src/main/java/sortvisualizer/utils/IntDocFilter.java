package main.java.sortvisualizer.utils;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;

public class IntDocFilter extends DocumentFilter {

    private final int maxCharacters;

    public IntDocFilter(int maxCharacters) {
        this.maxCharacters = maxCharacters;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
            throws BadLocationException {

        if ((fb.getDocument().getLength() + string.length()) <= maxCharacters
                && string.matches("^[0-9]+$")) {
            super.insertString(fb, offset, string, attr);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
            throws BadLocationException {

        if ((fb.getDocument().getLength() + text.length() - length) <= maxCharacters
                && text.matches("^[0-9]+$")) {
            super.replace(fb, offset, length, text, attrs);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }
}
