package com.company.panels;

import com.company.shuffles.DurstenfeldShuffle;
import com.company.sorts.Sort;
import com.company.utils.ColorManager;

import javax.swing.*;
import java.awt.*;

public class PrimaryPanel extends JPanel {

    Timer repaintTick;
    ControlPanel con;
    VisualizerPanel vis;

    public PrimaryPanel() {
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(ColorManager.tertiary);

        repaintTick = new Timer(10, e -> repaint());
        vis = new VisualizerPanel();
        con = new ControlPanel();

        this.setLayout(new BorderLayout(2, 0));
        this.add(con, BorderLayout.WEST);
        this.add(vis, BorderLayout.CENTER);

        con.sortButton.addActionListener(e -> {
            Sort sort = con.sortComboBox.getSort();
            SwingWorker<Void, Void> sortWorker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() {
                    sort.start(vis.vals, 10);
                    return null;
                }
            };
            sortWorker.execute();
        });

        con.shuffleButton.addActionListener(e -> {
            DurstenfeldShuffle shuffle = new DurstenfeldShuffle();
            shuffle.start(vis.vals);
        });

//        timer = new Timer(con.speedSlider.getValue(), e -> {
//            if (con.speedSlider.getValue() != timer.getDelay()) {
//                timer.setDelay(con.speedSlider.getValue());
//                timer.restart();
//            }
//            vis.repaint();
//        });
//        timer.start();

        repaintTick.start();
    }

}
