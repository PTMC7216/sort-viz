package com.company.panels;

import com.company.utils.ColorManager;

import javax.swing.*;
import java.awt.*;
import java.util.stream.IntStream;

public class VisualizerPanel extends JPanel {

    Timer timer;

    public VisualizerPanel() {
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(640, 0));
        timer = new Timer(1000, e -> {
            System.out.println("timer");
        });
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.setPaint(ColorManager.tertiary);

        // TODO: Sort/shuffle vals.

        int[] vals = IntStream.range(1, 500).toArray();
        for (int val : vals) {
            g2D.fillRect(val, 600, 1, -val);
        }
    }

}
