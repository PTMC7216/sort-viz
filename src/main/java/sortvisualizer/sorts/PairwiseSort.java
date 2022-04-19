package main.java.sortvisualizer.sorts;

import main.java.sortvisualizer.panels.VisualizerPanel;
import main.java.sortvisualizer.utils.Publisher;

public class PairwiseSort extends IterativeWorker {

    private static PairwiseSort instance = null;

    private PairwiseSort() {}

    public static PairwiseSort getInstance() {
        if (instance == null) {
            instance = new PairwiseSort();
        }
        return instance;
    }

    protected void sort(VisualizerPanel vis, int speed) {
        int[] arr = vis.getArr();
        int len = arr.length;
        int step = 0, updates = 0;

        int a = 1;
        int b, c, d, e;

        while (a < len) {
            b = a;
            c = 0;
            while (b < len) {
                if (worker.isCancelled()) return;
                if (arr[b - a] > arr[b]) {
                    step++;
                    if (step >= speed) {
                        step = 0;
                        vis.sleep();
                    }
                    vis.swap(b - a, b);
                    worker.toPublish(new Publisher(0, updates++));
                }
                b++; c++;
                if (c >= a) {
                    c = 0;
                    b += a;
                }
            }
            a *= 2;
        }

        a /= 4;
        e = 1;
        while (a > 0) {
            d = e;
            while (d > 0) {
                b = (d + 1) * a;
                c = 0;
                while (b < len) {
                    if (worker.isCancelled()) return;
                    if (arr[b - (d * a)] > arr[b]) {
                        step++;
                        if (step >= speed) {
                            step = 0;
                            vis.sleep();
                        }
                        vis.swap(b - (d * a), b);
                        worker.toPublish(new Publisher(0, updates++));
                    }
                    b++; c++;
                    if (c >= a) {
                        c = 0;
                        b += a;
                    }
                }
                d /= 2;
            }
            a /= 2;
            e = (2 * e) + 1;
        }
    }
}
