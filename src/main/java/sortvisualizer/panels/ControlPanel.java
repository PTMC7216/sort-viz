package main.java.sortvisualizer.panels;
import main.java.sortvisualizer.buttons.ShuffleButton;
import main.java.sortvisualizer.buttons.SortButton;
import main.java.sortvisualizer.comboboxes.SortComboBox;
import main.java.sortvisualizer.labels.*;
import main.java.sortvisualizer.sliders.ArrSlider;
import main.java.sortvisualizer.sliders.SpeedSlider;
import main.java.sortvisualizer.sliders.VolumeSlider;
import main.java.sortvisualizer.utils.ColorManager;

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
        setLayout(new BorderLayout(0, 0));

        sortButton = new SortButton();
        shuffleButton = new ShuffleButton();
        sortComboBox = new SortComboBox();
        arrSlider = new ArrSlider();
        speedSlider = new SpeedSlider();
        volumeSlider = new VolumeSlider();
        statusLabel = new StatusLabel();
        arrayUpdatesLabel = new ArrayUpdatesLabel();
        subArrayUpdatesLabel = new SubArrayUpdatesLabel();

        add(centralContainer(), BorderLayout.CENTER);
        add(lowerContainer(), BorderLayout.SOUTH);
    }

    private JPanel centralContainer() {
        JPanel panel = new JPanel();
        panel.setBackground(ColorManager.SECONDARY);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 8));

        panel.add(sortButton);
        panel.add(shuffleButton);
        panel.add(sortComboBox);
        panel.add(arrSlider.container());
        panel.add(speedSlider.container());
        panel.add(volumeSlider.container());
        panel.add(statusLabel);
        panel.add(arrayUpdatesLabel);
        panel.add(subArrayUpdatesLabel);

        return panel;
    }

    private JPanel lowerContainer() {
        JPanel panel = new JPanel();
        panel.setBackground(ColorManager.SECONDARY);
        panel.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, ColorManager.PRIMARY));
        panel.setLayout(new FlowLayout(FlowLayout.LEADING, 4, 2));

        panel.add(new GitHubLabel());
        panel.add(new GitVersionLabel());

        return panel;
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

    public int getArrSliderVal(String name) {
        return arrSlider.getRestrictedValue(name);
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
