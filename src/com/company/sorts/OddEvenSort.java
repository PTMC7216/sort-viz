package com.company.sorts;

import com.company.panels.VisualizerPanel;
import com.company.utils.Publisher;

public class OddEvenSort extends IterativeWorker {

    private static OddEvenSort instance = null;

    private OddEvenSort() {}

    public static OddEvenSort getInstance() {
        if (instance == null) {
            instance = new OddEvenSort();
        }
        return instance;
    }

    protected void sort(VisualizerPanel vis, int speed) {
        int[] arr = vis.getArr();
        int index_len = arr.length - 1;
        int step = 0;
        int updates = 0;
        boolean loop = true;
        while (loop) {
            loop = false;
            for (int i = 1; i < index_len; i += 2) {
                if (worker.isCancelled()) return;
                step++;
                if (step >= speed) {
                    step = 0;
                    vis.sleep();
                }
                if (arr[i] > arr[i + 1]) {
                    vis.swap(i, (i + 1));
                    updates++;
                    worker.toPublish(new Publisher(0, updates));
                    loop = true;
                }
            }
            for (int i = 0; i < index_len; i += 2) {
                if (worker.isCancelled()) return;
                step++;
                if (step >= speed) {
                    step = 0;
                    vis.sleep();
                }
                if (arr[i] > arr[i + 1]) {
                    vis.swap(i, (i + 1));
                    updates++;
                    worker.toPublish(new Publisher(0, updates));
                    loop = true;
                }
            }
        }
    }

}
