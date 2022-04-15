package com.company.sorts;

import com.company.panels.VisualizerPanel;
import com.company.utils.Publisher;

public class InsertionSort extends IterativeWorker {

    private static InsertionSort instance = null;

    private InsertionSort() {}

    public static InsertionSort getInstance() {
        if (instance == null) {
            instance = new InsertionSort();
        }
        return instance;
    }

    protected void sort(VisualizerPanel vis, int speed) {
        int[] arr = vis.getArr();
        int step = 0, updates = 0;
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                step++;
                if (step >= speed) {
                    step = 0;
                    vis.sleep();
                }
                vis.update(j + 1, arr[j]);
                worker.toPublish(new Publisher(0, updates++));
                j--;
            }
            vis.update(j + 1, current);
            worker.toPublish(new Publisher(0, updates++));
            if (worker.isCancelled()) return;
        }
    }
}
