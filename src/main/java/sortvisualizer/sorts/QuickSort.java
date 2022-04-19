package main.java.sortvisualizer.sorts;

import main.java.sortvisualizer.panels.VisualizerPanel;
import main.java.sortvisualizer.utils.Publisher;

public class QuickSort extends RecursiveWorker {

    private static QuickSort instance = null;
    private int updates;

    private QuickSort() {}

    public static QuickSort getInstance() {
        if (instance == null) {
            instance = new QuickSort();
        }
        return instance;
    }

    protected void sort(VisualizerPanel vis, int[] arr, int left, int right, int speed) {
        updates = 0;
        recurse(vis, arr, left, right, speed);
    }

    // TODO: Improve visualization and pivot selection in partially sorted arrays
    private void recurse(VisualizerPanel vis, int[] arr, int left, int right, int speed) {
        if (worker.isCancelled()) return;
        if (right == -128) {
            right = arr.length - 1;
        }
        if (left < right) {
            int part = partition(vis, arr, left, right, speed);
            recurse(vis, arr, left, part - 1, speed);
            recurse(vis, arr, part + 1, right, speed);
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
                    vis.swap(i, j);
                    updates++;
                    worker.toPublish(new Publisher(0, updates));
                }
            }
        }
        if (arr[i + 1] != arr[right]) {
            vis.sleep();
            vis.swap(i + 1, right);
            updates++;
            worker.toPublish(new Publisher(0, updates));
        }
        return i + 1;
    }

}
