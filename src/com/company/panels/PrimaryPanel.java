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
    private Queue<Sort> queue;

    public PrimaryPanel() {
        setBackground(Color.GRAY);

        con = new ControlPanel();
        vis = new VisualizerPanel();
        shuffle = new DurstenfeldShuffle();

        setLayout(new BorderLayout(2, 0));
        add(con, BorderLayout.WEST);
        add(vis, BorderLayout.CENTER);

        con.sortButton.addActionListener(e -> {
            sort = con.sortComboBox.getSort();
            speed = con.speedSlider.getValue();
            queue = vis.getQueue();
            if (vis.isSorting()) {
                queue.element().stop();
            } else {
                queue.offer(sort);
                queue.element().start(vis, speed);
            }
        });

        con.shuffleButton.addActionListener(e -> {
            vis.setArr(con.rangeSlider.getValue());
            sort = con.sortComboBox.getSort();
            queue = vis.getQueue();
            if (vis.isSorting()) {
                queue.element().stop();
            }
            shuffle.start(vis);
        });

    }

}
