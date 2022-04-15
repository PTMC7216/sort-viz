package com.company.sorts;

import com.company.panels.VisualizerPanel;
import com.company.utils.Publisher;

public class BitonicSort extends RecursiveWorker {

    private static BitonicSort instance = null;
    private int updates;

    private BitonicSort() {}

    public static BitonicSort getInstance() {
        if (instance == null) {
            instance = new BitonicSort();
        }
        return instance;
    }

    protected void sort(VisualizerPanel vis, int[] arr, int left, int right, int speed) {
        updates = 0;
        int direction = 0;
        recurse(vis, arr, left, right, direction, speed);
    }

    private void recurse(VisualizerPanel vis, int[] arr, int low, int len, int direction, int speed) {
        if (worker.isCancelled()) return;
        if (len == -128) {
            len = arr.length;
        }
        if (len > 1) {
            int k = (len / 2);
            recurse(vis, arr, low, k, 1, speed);
            recurse(vis, arr, (low + k), k, 0, speed);
            merge(vis, arr, low, len, direction, speed);
        }
    }

    private void merge(VisualizerPanel vis, int[] arr, int low, int len, int direction, int speed) {
        int step = 0;
        if (len > 1) {
            int k = (len / 2);
            for (int i = low; i < low + k; i++) {
                if (worker.isCancelled()) return;
                if (direction == 0 && (arr[i] > arr[i + k])
                        || direction == 1 && !(arr[i] > arr[i + k])) {
                    step++;
                    if (step >= speed) {
                        step = 0;
                        vis.sleep();
                    }
                    vis.swap(i, i + k);
                    worker.toPublish(new Publisher(0, updates++));
                }
            }
            merge(vis, arr, low, k, direction, speed);
            merge(vis, arr, (low + k), k, direction, speed);
        }
    }
}
