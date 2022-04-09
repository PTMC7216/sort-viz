package com.company.sorts;

import com.company.panels.VisualizerPanel;
import com.company.utils.Publisher;

public class MergeSort extends RecursiveWorker {

    private static MergeSort instance = null;
    private int updates;
    private int subUpdates;

    private MergeSort() {}

    public static MergeSort getInstance() {
        if (instance == null) {
            instance = new MergeSort();
        }
        return instance;
    }

    protected void sort(VisualizerPanel vis, int[] arr, int left, int right, int speed) {
        updates = 0;
        subUpdates = 0;
        recurse(vis, arr, left, right, speed);
    }

    private void recurse(VisualizerPanel vis, int[] arr, int left, int right, int speed) {
        if (worker.isCancelled()) return;
        if (right == -128) {
            right = arr.length - 1;
        }
        if (left < right) {
            int mid = (left + right) / 2;
            recurse(vis, arr, left, mid, speed);
            recurse(vis, arr, mid + 1, right, speed);
            merge(vis, arr, left, mid, right, speed);
        }
    }

    private void merge(VisualizerPanel vis, int[] arr, int left, int mid, int right, int speed) {
        int step = 0;
        int leftLen = mid - left + 1;
        int rightLen = right - mid;
        int i = left, j = 0, k = 0;

        int[] leftArr = new int[leftLen];
        int[] rightArr = new int[rightLen];

        for (int l = 0; l < leftLen; l++) {
            if (worker.isCancelled()) return;
            step++;
            if (step >= speed) {
                step = 0;
                vis.sleep();
            }
            leftArr[l] = arr[left + l];
            vis.subUpdate(left + l);
            worker.toPublish(new Publisher(1, subUpdates++));
        }

        for (int l = 0; l < rightLen; l++) {
            if (worker.isCancelled()) return;
            step++;
            if (step >= speed) {
                step = 0;
                vis.sleep();
            }
            rightArr[l] = arr[(mid + 1) + l];
            vis.subUpdate((mid + 1) + l);
            worker.toPublish(new Publisher(1, subUpdates++));
        }

        while (j < leftLen && k < rightLen) {
            step++;
            if (step >= speed) {
                step = 0;
                vis.sleep();
            }
            if (leftArr[j] <= rightArr[k]) {
                vis.update(i, leftArr[j]);
                worker.toPublish(new Publisher(0, updates++));
                j++;
            } else {
                vis.update(i, rightArr[k]);
                worker.toPublish(new Publisher(0, updates++));
                k++;
            }
            i++;
        }

        while (j < leftLen) {
            vis.update(i, leftArr[j]);
            worker.toPublish(new Publisher(0, updates++));
            j++;
            i++;
        }

        while (k < rightLen) {
            vis.update(i, rightArr[k]);
            worker.toPublish(new Publisher(0, updates++));
            k++;
            i++;
        }
    }
}
