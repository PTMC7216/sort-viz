package com.company.panels;

import com.company.utils.ColorManager;

import javax.swing.*;
import java.awt.*;
import java.util.stream.IntStream;

public class VisualizerPanel extends JPanel {

    Timer timer;

    public VisualizerPanel() {
        this.setBackground(Color.BLACK);
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
            g2D.fillRect(1 + val, 560, 1, -val);
        }
    }

}
