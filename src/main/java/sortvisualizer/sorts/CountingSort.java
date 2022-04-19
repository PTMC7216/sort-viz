package main.java.sortvisualizer.sorts;

import main.java.sortvisualizer.panels.VisualizerPanel;
import main.java.sortvisualizer.utils.Publisher;

import java.util.Arrays;

public class CountingSort extends IterativeWorker {

    private static CountingSort instance = null;

    private CountingSort() {}

    public static CountingSort getInstance() {
        if (instance == null) {
            instance = new CountingSort();
        }
        return instance;
    }

    protected void sort(VisualizerPanel vis, int speed) {
        int[] arr = vis.getArr();
        int[] arrCopy = arr.clone();
        int min = Arrays.stream(arr).min().orElse(0);
        int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);
        int[] count = new int[max - min + 1];
        int[] out = new int[arr.length];
        int step = 0, updates = 0, subUpdates = 0;

        for (int i : arr) {
            if (worker.isCancelled()) return;
            step++;
            if (step >= speed) {
                step = 0;
                vis.sleep();
            }
            count[i - min]++;
            vis.subUpdate(i - min);
            worker.toPublish(new Publisher(1, subUpdates++));
        }

        for (int i = 1; i < count.length; i++) {
            if (worker.isCancelled()) return;
            step++;
            if (step >= speed) {
                step = 0;
                vis.sleep();
            }
            count[i] += count[i - 1];
            vis.subUpdate(i);
            worker.toPublish(new Publisher(1, subUpdates++));
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (worker.isCancelled()) return;
            step++;
            if (step >= speed) {
                step = 0;
                vis.sleep();
            }
            int current = arr[i];
            int arrPos = count[current - min] - 1;
            vis.subUpdate(i);
            worker.toPublish(new Publisher(1, subUpdates++));
            out[arrPos] = current;
            count[current - min]--;
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
