package main.java.sortvisualizer.frames;

import main.java.sortvisualizer.panels.PrimaryPanel;
import main.java.sortvisualizer.utils.ResourceManager;

import javax.swing.*;
import java.awt.*;

public class PrimaryFrame extends JFrame {

    public PrimaryFrame() {
        setTitle("Visualizer");
        ResourceManager resource = new ResourceManager("title_icon.png");
        setIconImage(resource.set());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setPreferredSize(new Dimension(800, 600));
        setMinimumSize(new Dimension(464, 342));

        add(new PrimaryPanel());

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
