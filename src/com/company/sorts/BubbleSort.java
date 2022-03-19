package com.company.sorts;

import com.company.panels.VisualizerPanel;

import javax.swing.*;

public class BubbleSort extends Sort {

    private static BubbleSort instance = null;
    private SwingWorker<Void, Void> worker;

    private BubbleSort() {}

    public void start(VisualizerPanel vis, int sortSpeed) {
        worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                System.out.printf("Worker started: %s%n", worker);
                vis.setSorting(true);
                sort(vis, sortSpeed);
                return null;
            }
            @Override
            protected void done() {
                super.done();
                vis.setSorting(false);
                vis.getQueue().poll();
                System.out.printf("Worker finished: %s%n", worker);
            }
        };
        worker.execute();
    }

    public void stop() {
        if (worker != null) {
            worker.cancel(false);
        }
    }

    private void sort(VisualizerPanel vis, int sortSpeed) {
        int[] arr = vis.getArr();
        int index_len = arr.length - 1;
        int step = 0;
        boolean loop = true;
        while (loop) {
            loop = false;
            for (int i = 0; i < index_len; i++) {
                if (worker.isCancelled()) return;
                step++;
                if (step == sortSpeed) {
                    step = 0;
                    vis.sleep();
                }
                if (arr[i] > arr[i + 1]) {
                    vis.swap(arr, i, i + 1);
                    loop = true;
                }
            }
            index_len--;
        }
    }

    public static BubbleSort getInstance() {
        if (instance == null) {
            instance = new BubbleSort();
        }
        return instance;
    }

}
