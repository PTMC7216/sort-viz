package com.company.panels;

import com.company.shuffles.DurstenfeldShuffle;
import com.company.sorts.Sort;
import com.company.utils.ColorManager;

import javax.swing.*;
import java.awt.*;
import java.util.Queue;

public class PrimaryPanel extends JPanel {

    private final ControlPanel con;
    private final VisualizerPanel vis;
    private final DurstenfeldShuffle shuffle;
    private final Queue<Sort> queue;

    private Sort sort;
    private int speed;

    public PrimaryPanel() {
        setBackground(ColorManager.PRIMARY);

        con = new ControlPanel();
        vis = new VisualizerPanel();
        shuffle = DurstenfeldShuffle.getInstance();
        queue = vis.getQueue();

        setLayout(new BorderLayout(2, 0));
        add(con, BorderLayout.WEST);
        add(vis, BorderLayout.CENTER);

        buttonListeners();
        sliderListeners();
    }

    private void buttonListeners() {
        con.sortButton.addActionListener(e -> {
            sort = con.sortComboBox.getSort();
            speed = con.speedSlider.getValue();

            if (vis.getSorting()) {
                queue.element().stop();
            } else {
                 if (vis.getArr().length != con.getArrSliderVal()) {
                    vis.setArr(con.getArrSliderVal());
                    shuffle.start(vis, con, speed);
                } else if (vis.isSorted()) {
                    shuffle.start(vis, con, speed);
                } else {
                    if (vis.getShuffling()) {
                        shuffle.stop();
                    }
                    queue.offer(sort);
                    queue.element().start(vis, con, speed);
                }
            }
        });

        con.shuffleButton.addActionListener(e -> {
            speed = con.speedSlider.getValue();
            if (vis.getShuffling()) {
                shuffle.stop();
            } else {
                if (vis.getSorting()) {
                    queue.element().stop();
                }
                if (vis.getArr().length != con.getArrSliderVal()) {
                    vis.setArr(con.getArrSliderVal());
                }
                shuffle.start(vis, con, speed);
            }
        });
    }

    private void sliderListeners() {
        con.volumeSlider.addChangeListener(e -> vis.setVolume(con.volumeSlider.getValue()));
    }

}
