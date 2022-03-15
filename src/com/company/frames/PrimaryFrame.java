package com.company.frames;

import com.company.panels.ControlPanel;
import com.company.panels.VisualizerPanel;
import com.company.utils.ColorManager;

import javax.swing.*;
import java.awt.*;

public class PrimaryFrame extends JFrame {

    public PrimaryFrame() {
        this.setTitle("Visualizer");
        this.setIconImage(new ImageIcon("./src/com/company/icon.png").getImage());
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(ColorManager.tertiary);
        this.setLayout(new BorderLayout(2, 0));

        this.add(new ControlPanel(), BorderLayout.WEST);
        this.add(new VisualizerPanel(), BorderLayout.CENTER);

        this.setVisible(true);
    }

}
