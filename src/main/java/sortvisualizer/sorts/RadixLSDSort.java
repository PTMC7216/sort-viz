package main.java.sortvisualizer.sorts;

import main.java.sortvisualizer.panels.VisualizerPanel;
import main.java.sortvisualizer.utils.Publisher;

import java.util.Arrays;

public abstract class RadixLSDSort extends IterativeWorker {

    private final int base;
    private int updates;
    private int subUpdates;

    public RadixLSDSort(int base) {
        this.base = base;
    }

    protected void sort(VisualizerPanel vis, int speed) {
        int[] arr = vis.getArr();
        int[] arrCopy = arr.clone();
        int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);
        updates = 0;
        subUpdates = 0;

        for (int exp = 1; max / exp > 0; exp *= base) {
            countingSort(vis, arr, arrCopy, speed, exp);
        }
    }

    protected void countingSort(VisualizerPanel vis, int[] arr, int[] arrCopy, int speed, int exp) {
        int[] count = new int[base];
        int[] out = new int[arr.length];
        int step = 0;

        for (int i : arr) {
            count[(i / exp) % base]++;
            worker.toPublish(new Publisher(1, subUpdates++));
        }

        for (int i = 1; i < base; i++) {
            count[i] += count[i - 1];
            worker.toPublish(new Publisher(1, subUpdates++));
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (worker.isCancelled()) return;
            step++;
            if (step >= speed) {
                step = 0;
                vis.sleep();
            }
            out[count[(arr[i] / exp) % base] - 1] = arr[i];
            count[(arr[i] / exp) % base]--;
            vis.subUpdate(count[(arr[i] / exp) % base]);
            worker.toPublish(new Publisher(1, subUpdates++));
        }

        for (int i = 0; i < arr.length; i++) {
            if (worker.isCancelled()) {
                vis.setArrCopy(arrCopy);
                return;
            }
            step++;
            if (step >= speed) {
                step = 0;
                vis.sleep();
            }
            vis.update(i, out[i]);
            worker.toPublish(new Publisher(0, updates++));
        }
    }
}