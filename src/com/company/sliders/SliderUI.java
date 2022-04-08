package com.company.sliders;

import com.company.utils.ColorManager;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.*;

public class SliderUI extends BasicSliderUI {

    public SliderUI(JSlider b) {
        super(b);
        b.setBackground(ColorManager.SECONDARY);
        b.setPreferredSize(new Dimension(113, 16));
        b.setOrientation(0);
    }

    @Override
    protected void installDefaults(JSlider slider) {
        UIManager.put("Slider.highlight", new ColorUIResource(ColorManager.TERTIARY));
        UIManager.put("Slider.shadow", new ColorUIResource(ColorManager.PRIMARY));
        super.installDefaults(slider);
    }

    @Override
    protected Dimension getThumbSize() {
        return new Dimension(11, 16);
    }

    @Override
    public void paintTrack(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(ColorManager.PRIMARY);

        Rectangle trackBounds = trackRect;
        if (slider.getOrientation() == JSlider.HORIZONTAL) {
            int cy = (trackBounds.height / 2) - 2;
            int cw = trackBounds.width;
            g2D.translate(trackBounds.x, trackBounds.y + cy);
            g2D.drawRect(1, 1, cw - 2, 2);
            g2D.translate(-trackBounds.x, -(trackBounds.y + cy));
        } else {
            int cx = (trackBounds.width / 2) - 2;
            int ch = trackBounds.height;
            g2D.translate(trackBounds.x + cx, trackBounds.y);
            g2D.drawRect(1, 1, 2, ch - 2);
            g2D.translate(-(trackBounds.x + cx), -trackBounds.y);
        }
    }

    @Override
    public void paintFocus(Graphics g) {}
}
