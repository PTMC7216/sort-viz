package com.company.panels;

import com.company.buttons.ShuffleButton;
import com.company.buttons.SortButton;
import com.company.comboboxes.SortComboBox;
import com.company.sliders.SpeedSlider;
import com.company.sorts.Sort;
import com.company.utils.ColorManager;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {

    SpeedSlider speedSlider;
    SortComboBox sortComboBox;
    SortButton sortButton;
    ShuffleButton shuffleButton;

    public ControlPanel(int[] arr) {
        this.setPreferredSize(new Dimension(160, 0));
        this.setBackground(ColorManager.secondary);

        speedSlider = new SpeedSlider();
        sortComboBox = new SortComboBox();

        sortButton = new SortButton();
        sortButton.addActionListener(e -> {
            Sort sort = sortComboBox.getSort();
            sort.start(arr);
        });

        shuffleButton = new ShuffleButton(arr);

        this.add(sortButton);
        this.add(shuffleButton);
        this.add(sortComboBox);
        this.add(speedSlider.container());

    }

    public int getSpeed() {
        return speedSlider.getValue();
    }

}
