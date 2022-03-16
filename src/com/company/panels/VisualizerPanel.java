package com.company.panels;

import com.company.utils.ColorManager;

import javax.swing.*;
import java.awt.*;
import java.util.stream.IntStream;

public class VisualizerPanel extends JPanel {

    int[] vals;

    public VisualizerPanel() {
        this.setPreferredSize(new Dimension(640, 0));
        this.setBackground(Color.BLACK);

        vals = IntStream.range(1, 500).toArray();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(ColorManager.tertiary);

        for (int i = 0; i < vals.length; i++) {
            g2D.fillRect(i, 600, 1, -vals[i]);
        }
    }

}
