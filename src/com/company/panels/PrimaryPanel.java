package com.company.panels;

import com.company.shuffles.DurstenfeldShuffle;
import com.company.sorts.Sort;

import javax.swing.*;
import java.awt.*;
import java.util.Queue;

public class PrimaryPanel extends JPanel {

    private final ControlPanel con;
    private final VisualizerPanel vis;
    private final DurstenfeldShuffle shuffle;

    private Sort sort;
    private int speed;
    private final Queue<Sort> queue;

    public PrimaryPanel() {
        setBackground(Color.GRAY);

        con = new ControlPanel();
        vis = new VisualizerPanel();
        shuffle = DurstenfeldShuffle.getInstance();
        queue = vis.getQueue();

        setLayout(new BorderLayout(2, 0));
        add(con, BorderLayout.WEST);
        add(vis, BorderLayout.CENTER);

        con.sortButton.addActionListener(e -> {
            sort = con.sortComboBox.getSort();
            speed = con.speedSlider.getValue();
            if (vis.isSorting()) {
                queue.element().stop();
            } else {
                if (vis.isShuffling()) {
                    shuffle.stop();
                }
                queue.offer(sort);
                queue.element().start(vis, con, speed);
            }
        });

        con.shuffleButton.addActionListener(e -> {
            speed = con.speedSlider.getValue();
            if (vis.isShuffling()) {
                shuffle.stop();
            } else {
                if (vis.isSorting()) {
                    queue.element().stop();
                }
                if (vis.getArr().length != con.rangeSlider.getValue()) {
                    vis.setArr(con.rangeSlider.getValue());
                }
                shuffle.start(vis, con, speed);
            }
        });

    }

}
