package main.java.sortvisualizer.shuffles;

import main.java.sortvisualizer.panels.ControlPanel;
import main.java.sortvisualizer.panels.VisualizerPanel;
import main.java.sortvisualizer.utils.PublishWorker;
import main.java.sortvisualizer.utils.Publisher;

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
                con.setShuffleButtonText("Stop");
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
                con.setShuffleButtonText("Shuffle");
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
        int step = 0, updates = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (worker.isCancelled()) return;
            step++;
            if (step >= speed) {
                step = 0;
                vis.sleep();
            }
            int rand = (int) (Math.random() * i);
            vis.swap(rand, i);
            worker.toPublish(new Publisher(0, updates++));
        }
    }

}

