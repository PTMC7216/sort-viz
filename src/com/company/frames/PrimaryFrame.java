package com.company.frames;

import com.company.panels.PrimaryPanel;

import javax.swing.*;
import java.awt.*;

public class PrimaryFrame extends JFrame {

    public PrimaryFrame() {
        this.setTitle("Visualizer");
        this.setIconImage(new ImageIcon("./src/com/company/icon.png").getImage());
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.getContentPane().setPreferredSize(new Dimension(800, 600));
        this.setMinimumSize(new Dimension(340, 140));

        PrimaryPanel pPanel = new PrimaryPanel();
        this.add(pPanel);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
