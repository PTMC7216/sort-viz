package com.company.panels;

import com.company.buttons.ShuffleButton;
import com.company.buttons.SortButton;
import com.company.comboboxes.SortComboBox;
import com.company.sliders.SortingSpeedSlider;
import com.company.utils.ColorManager;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {

    public ControlPanel() {
        this.setBackground(ColorManager.secondary);
        this.setPreferredSize(new Dimension(160, 0));

        this.add(new SortButton());
        this.add(new ShuffleButton());

        this.add(new SortComboBox());

        this.add(new SortingSpeedSlider().container());
    }

}
