package com.company.frames;

import com.company.panels.PrimaryPanel;

import javax.swing.*;
import java.awt.*;

public class PrimaryFrame extends JFrame {

    public PrimaryFrame() {
        setTitle("Visualizer");
        setIconImage(new ImageIcon("./src/com/company/icon.png").getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setPreferredSize(new Dimension(800, 600));
        setMinimumSize(new Dimension(340, 174));

        add(new PrimaryPanel());

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
