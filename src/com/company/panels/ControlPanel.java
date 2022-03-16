package com.company.panels;

import com.company.buttons.ShuffleButton;
import com.company.buttons.SortButton;
import com.company.comboboxes.SortComboBox;
import com.company.sliders.SpeedSlider;
import com.company.utils.ColorManager;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {

    SpeedSlider speedSlider;
    SortComboBox sortComboBox;
    SortButton sortButton;
    ShuffleButton shuffleButton;

    public ControlPanel() {
        this.setPreferredSize(new Dimension(160, 0));
        this.setBackground(ColorManager.secondary);

        speedSlider = new SpeedSlider();
        sortComboBox = new SortComboBox();
        sortButton = new SortButton();
        shuffleButton = new ShuffleButton();

        this.add(sortButton);
        this.add(shuffleButton);
        this.add(sortComboBox);
        this.add(speedSlider.container());

    }

}
