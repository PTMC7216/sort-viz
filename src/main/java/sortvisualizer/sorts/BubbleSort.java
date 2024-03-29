package main.java.sortvisualizer.sorts;

import main.java.sortvisualizer.panels.VisualizerPanel;
import main.java.sortvisualizer.utils.Publisher;

public class BubbleSort extends IterativeWorker {

    private static BubbleSort instance = null;

    private BubbleSort() {}

    public static BubbleSort getInstance() {
        if (instance == null) {
            instance = new BubbleSort();
        }
        return instance;
    }

    protected void sort(VisualizerPanel vis, int speed) {
        int[] arr = vis.getArr();
        int arrIndices = arr.length - 1;
        int step = 0, updates = 0;
        boolean loop = true;
        while (loop) {
            loop = false;
            for (int i = 0; i < arrIndices; i++) {
                if (worker.isCancelled()) return;
                step++;
                if (step >= speed) {
                    step = 0;
                    vis.sleep();
                }
                if (arr[i] > arr[i + 1]) {
                    vis.swap(i, i + 1);
                    worker.toPublish(new Publisher(0, updates++));
                    loop = true;
                }
            }
            arrIndices--;
        }
    }

}
