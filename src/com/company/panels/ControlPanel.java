package com.company.panels;

import com.company.buttons.ShuffleButton;
import com.company.buttons.SortButton;
import com.company.comboboxes.SortComboBox;
import com.company.sliders.RangeSlider;
import com.company.sliders.SpeedSlider;
import com.company.sliders.VolumeSlider;
import com.company.utils.ColorManager;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {

    public SortButton sortButton;
    public ShuffleButton shuffleButton;
    SortComboBox sortComboBox;
    RangeSlider rangeSlider;
    SpeedSlider speedSlider;
    VolumeSlider volumeSlider;

    public ControlPanel() {
        setPreferredSize(new Dimension(160, 0));
        setBackground(ColorManager.SECONDARY);

        sortButton = new SortButton();
        shuffleButton = new ShuffleButton();
        sortComboBox = new SortComboBox();
        rangeSlider = new RangeSlider();
        speedSlider = new SpeedSlider();
        volumeSlider = new VolumeSlider();

        add(sortButton);
        add(shuffleButton);
        add(sortComboBox);
        add(rangeSlider.container());
        add(speedSlider.container());
        add(volumeSlider.container());

    }

}
