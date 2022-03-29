package com.company.sorts;

import com.company.panels.ControlPanel;
import com.company.panels.VisualizerPanel;

import javax.swing.*;

public class QuickSort extends Sort {

    private static QuickSort instance = null;
    private SwingWorker<Void, Void> worker;

    private QuickSort() {}

    public void start(VisualizerPanel vis, ControlPanel con, int speed) {
        worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                vis.setSorting(true);
                con.sortButton.setText("Stop");
                sort(vis, vis.getArr(), 0, -128, speed);
                return null;
            }
            @Override
            protected void done() {
                super.done();
                vis.resetHighlight();
                vis.setSorting(false);
                con.sortButton.setText("Sort");
                vis.getQueue().poll();
            }
        };
        worker.execute();
    }

    public void stop() {
        if (worker != null) {
            worker.cancel(false);
        }
    }

    private void sort(VisualizerPanel vis, int[] arr, int left, int right, int speed) {
        if (worker.isCancelled()) return;
        if (right == -128) {
            right = arr.length - 1;
        }
        if (left < right) {
            int part = partition(vis, arr, left, right, speed);
            sort(vis, arr, left, part - 1, speed);
            sort(vis, arr, part + 1, right, speed);
        }
    }

    private int partition(VisualizerPanel vis, int[] arr, int left, int right, int speed) {
        int step = 0;
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (worker.isCancelled()) return 0;
            step++;
            if (step >= speed) {
                step = 0;
                vis.sleep();
            }
            if (arr[j] <= arr[right]) {
                i++;
                if (i != j) {
                    vis.swap(arr, i, j);
                }
            }
        }
        if (arr[i + 1] != arr[right]) {
            vis.sleep();
            vis.swap(arr, i + 1, right);
        }
        return i + 1;
    }

    public static QuickSort getInstance() {
        if (instance == null) {
            instance = new QuickSort();
        }
        return instance;
    }

}
