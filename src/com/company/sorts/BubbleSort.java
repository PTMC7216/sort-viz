package com.company.sorts;

import com.company.panels.VisualizerPanel;

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
        int index_len = arr.length - 1;
        int step = 0;
        boolean loop = true;
        while (loop) {
            loop = false;
            for (int i = 0; i < index_len; i++) {
                if (worker.isCancelled()) return;
                step++;
                if (step >= speed) {
                    step = 0;
                    vis.sleep();
                }
                if (arr[i] > arr[i + 1]) {
                    vis.swap(i, i + 1);
                    loop = true;
                }
            }
            index_len--;
        }
    }

}
