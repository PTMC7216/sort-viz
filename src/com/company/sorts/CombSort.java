package com.company.sorts;

import com.company.panels.VisualizerPanel;
import com.company.utils.Publisher;

public class CombSort extends IterativeWorker {

    private static CombSort instance = null;

    private CombSort() {}

    public static CombSort getInstance() {
        if (instance == null) {
            instance = new CombSort();
        }
        return instance;
    }

    protected void sort(VisualizerPanel vis, int speed) {
        int[] arr = vis.getArr();
        int gap = arr.length;
        float shrink = 1.3f;
        int step = 0;
        int updates = 0;
        boolean loop = true;
        while (loop) {
            gap = (int) (gap / shrink);
            if (gap <= 1) {
                gap = 1;
                loop = false;
            }
            for (int i = 0; (i + gap) < arr.length; i++) {
                if (worker.isCancelled()) return;
                step++;
                if (step >= speed) {
                    step = 0;
                    vis.sleep();
                }
                if (arr[i] > arr[i + gap]) {
                    vis.swap(i, (i + gap));
                    worker.toPublish(new Publisher(0, updates++));
                    loop = true;
                }
            }
        }
    }
}
