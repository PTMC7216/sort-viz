package com.company.panels;

import com.company.shuffles.DurstenfeldShuffle;
import com.company.sorts.Sort;
import com.company.utils.ColorManager;

import javax.swing.*;
import java.awt.*;

public class PrimaryPanel extends JPanel {

    private final ControlPanel con;
    private final VisualizerPanel vis;
    private final DurstenfeldShuffle shuffle;

    private Sort sort;

    public PrimaryPanel() {
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(ColorManager.tertiary);

        con = new ControlPanel();
        vis = new VisualizerPanel();
        shuffle = new DurstenfeldShuffle();

        this.setLayout(new BorderLayout(2, 0));
        this.add(con, BorderLayout.WEST);
        this.add(vis, BorderLayout.CENTER);

        con.sortButton.addActionListener(e -> {
            // TODO: Track previous sort when changing sorts mid-sort.
            sort = con.sortComboBox.getSort();
            if (vis.isSorting()) {
                sort.stop();
            } else {
                shuffle.start(vis);
                sort.start(vis, con.speedSlider.getValue());
            }
        });

        con.shuffleButton.addActionListener(e -> {
            sort = con.sortComboBox.getSort();
            if (vis.isSorting()) {
                sort.stop();
            }
            shuffle.start(vis);
        });

    }

}
