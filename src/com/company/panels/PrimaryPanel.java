package com.company.panels;

import com.company.utils.ColorManager;

import javax.swing.*;
import java.awt.*;

public class PrimaryPanel extends JPanel {

    public PrimaryPanel() {
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(ColorManager.tertiary);

        this.setLayout(new BorderLayout(2, 0));
        this.add(new ControlPanel(), BorderLayout.WEST);
        this.add(new VisualizerPanel(), BorderLayout.CENTER);
    }

}
