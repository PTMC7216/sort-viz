package com.company.panels;

import com.company.buttons.ShuffleButton;
import com.company.buttons.SortButton;
import com.company.comboboxes.SortComboBox;
import com.company.labels.ArrayUpdatesLabel;
import com.company.labels.StatusLabel;
import com.company.labels.SubArrayUpdatesLabel;
import com.company.sliders.ArrSlider;
import com.company.sliders.SpeedSlider;
import com.company.sliders.VolumeSlider;
import com.company.utils.ColorManager;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {

    public SortButton sortButton;
    public ShuffleButton shuffleButton;
    SortComboBox sortComboBox;
    ArrSlider arrSlider;
    SpeedSlider speedSlider;
    VolumeSlider volumeSlider;
    StatusLabel statusLabel;
    ArrayUpdatesLabel arrayUpdatesLabel;
    SubArrayUpdatesLabel subArrayUpdatesLabel;

    public ControlPanel() {
        setPreferredSize(new Dimension(160, 0));
        setBackground(ColorManager.SECONDARY);

        sortButton = new SortButton();
        shuffleButton = new ShuffleButton();
        sortComboBox = new SortComboBox();
        arrSlider = new ArrSlider();
        speedSlider = new SpeedSlider();
        volumeSlider = new VolumeSlider();
        statusLabel = new StatusLabel();
        arrayUpdatesLabel = new ArrayUpdatesLabel();
        subArrayUpdatesLabel = new SubArrayUpdatesLabel();

        add(sortButton);
        add(shuffleButton);
        add(sortComboBox);
        add(arrSlider.container());
        add(speedSlider.container());
        add(volumeSlider.container());
        add(statusLabel);
        add(arrayUpdatesLabel);
        add(subArrayUpdatesLabel);
    }

    public int getArrSliderVal() {
        return arrSlider.getValue();
    }

    public void setStatus(String status) {
        statusLabel.setStatus(status);
    }

    public void updateArrLabel(Integer integer) {
        arrayUpdatesLabel.updateLabel(integer);
    }

    public void updateSubArrLabel(Integer integer) {
        subArrayUpdatesLabel.updateLabel(integer);
    }

    public void resetLabelUpdates() {
        arrayUpdatesLabel.resetLabel();
        subArrayUpdatesLabel.resetLabel();
    }

}
