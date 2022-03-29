package com.company.shuffles;

import com.company.panels.ControlPanel;
import com.company.panels.VisualizerPanel;

import javax.swing.*;

public class DurstenfeldShuffle {

    private static DurstenfeldShuffle instance = null;
    private SwingWorker<Void, Void> worker;

    private DurstenfeldShuffle() {}

    public void start(VisualizerPanel vis, ControlPanel con, int speed) {
        worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                vis.setShuffling(true);
                con.shuffleButton.setText("Stop");
                shuffle(vis, speed);
                return null;
            }
            @Override
            protected void done() {
                super.done();
                vis.resetHighlight();
                vis.setShuffling(false);
                con.shuffleButton.setText("Shuffle");
            }
        };
        worker.execute();
    }

    public void stop() {
        if (worker != null) {
            worker.cancel(false);
        }
    }

    private void shuffle(VisualizerPanel vis, int speed) {
        int[] arr = vis.getArr();
        int right = arr.length - 1;
        int step = 0;
        while (right > 0) {
            if (worker.isCancelled()) return;
            step++;
            if (step >= speed) {
                step = 0;
                vis.sleep();
            }
            int rand = (int) (Math.random() * right);
            vis.swap(arr, rand, right);
            right--;
        }
    }

    public static DurstenfeldShuffle getInstance() {
        if (instance == null) {
            instance = new DurstenfeldShuffle();
        }
        return instance;
    }

}
