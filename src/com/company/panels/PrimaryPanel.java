package com.company.panels;

import com.company.utils.ColorManager;

import javax.swing.*;
import java.awt.*;

public class PrimaryPanel extends JPanel {

    Timer timer;
    ControlPanel cPanel;
    VisualizerPanel vPanel;

    public PrimaryPanel() {
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(ColorManager.tertiary);

        vPanel = new VisualizerPanel();
        cPanel = new ControlPanel(vPanel.vals);

        this.setLayout(new BorderLayout(2, 0));
        this.add(cPanel, BorderLayout.WEST);
        this.add(vPanel, BorderLayout.CENTER);

        // TODO: Pause timer while not sorting.
        timer = new Timer(cPanel.getSpeed(), e -> {
            if (cPanel.getSpeed() != timer.getDelay()) {
                timer.setDelay(cPanel.getSpeed());
                timer.restart();
            }
            vPanel.repaint();
        });
        timer.start();

    }

}
