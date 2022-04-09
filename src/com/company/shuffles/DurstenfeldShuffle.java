package com.company.shuffles;

import com.company.panels.ControlPanel;
import com.company.panels.VisualizerPanel;
import com.company.utils.PublishWorker;
import com.company.utils.Publisher;

import java.util.List;

public class DurstenfeldShuffle {

    private static DurstenfeldShuffle instance = null;
    private PublishWorker<Void, Publisher> worker;

    private DurstenfeldShuffle() {}

    public static DurstenfeldShuffle getInstance() {
        if (instance == null) {
            instance = new DurstenfeldShuffle();
        }
        return instance;
    }

    public void start(VisualizerPanel vis, ControlPanel con, int speed) {
        worker = new PublishWorker<>() {
            @Override
            protected Void doInBackground() {
                vis.setShuffling(true);
                con.shuffleButton.setText("Stop");
                con.setStatus("SHUFFLING");
                con.resetLabelUpdates();
                shuffle(vis, speed);
                return null;
            }
            @Override
            protected void process(List<Publisher> chunks) {
                for (Publisher p : chunks){
                    if (p.getCategory() == 0) {
                        con.updateArrLabel(p.getData());
                    }
                }
            }
            @Override
            protected void done() {
                vis.resetHighlight();
                vis.setShuffling(false);
                con.shuffleButton.setText("Shuffle");
                con.setStatus("IDLE");
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
        int updates = 0;
        while (right > 0) {
            if (worker.isCancelled()) return;
            step++;
            if (step >= speed) {
                step = 0;
                vis.sleep();
            }
            int rand = (int) (Math.random() * right);
            vis.swap(rand, right);
            worker.toPublish(new Publisher(0, updates++));
            right--;
        }
    }

}

