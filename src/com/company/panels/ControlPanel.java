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

    protected SortButton sortButton;
    protected ShuffleButton shuffleButton;
    protected SortComboBox sortComboBox;
    protected ArrSlider arrSlider;
    protected SpeedSlider speedSlider;
    protected VolumeSlider volumeSlider;
    protected StatusLabel statusLabel;
    protected ArrayUpdatesLabel arrayUpdatesLabel;
    protected SubArrayUpdatesLabel subArrayUpdatesLabel;

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

        setLayout(new FlowLayout(FlowLayout.CENTER, 8, 8));
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

    public void setSortButtonText(String string) {
        sortButton.setText(string);
    }

    public void setShuffleButtonText(String string) {
        shuffleButton.setText(string);
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
