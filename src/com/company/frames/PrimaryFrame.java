package com.company.frames;

import com.company.panels.PrimaryPanel;

import javax.swing.*;

public class PrimaryFrame extends JFrame {

    public PrimaryFrame() {
        this.setTitle("Visualizer");
        this.setIconImage(new ImageIcon("./src/com/company/icon.png").getImage());
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);

        PrimaryPanel pPanel = new PrimaryPanel();
        this.add(pPanel);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
