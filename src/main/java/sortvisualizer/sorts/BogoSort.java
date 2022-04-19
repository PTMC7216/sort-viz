package main.java.sortvisualizer.sorts;

import main.java.sortvisualizer.panels.VisualizerPanel;
import main.java.sortvisualizer.utils.Publisher;

public class BogoSort extends IterativeWorker {

    private static BogoSort instance = null;

    private BogoSort() {}

    public static BogoSort getInstance() {
        if (instance == null) {
            instance = new BogoSort();
        }
        return instance;
    }

    protected void sort(VisualizerPanel vis, int speed) {
        int[] arr = vis.getArr();
        int step = 0, updates = 0;
        while (!vis.isSorted()) {
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
}
