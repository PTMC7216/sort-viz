package com.company.sorts;

import com.company.panels.VisualizerPanel;

public class MergeSort extends RecursiveWorker {

    private static MergeSort instance = null;

    private MergeSort() {}

    public static MergeSort getInstance() {
        if (instance == null) {
            instance = new MergeSort();
        }
        return instance;
    }

    protected void sort(VisualizerPanel vis, int[] arr, int left, int right, int speed) {
        if (worker.isCancelled()) return;
        if (right == -128) {
            right = arr.length - 1;
        }
        if (left < right) {
            int mid = (left + right) / 2;
            sort(vis, arr, left, mid, speed);
            sort(vis, arr, mid + 1, right, speed);
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
        System.arraycopy(arr, left, leftArr, 0, leftLen);
        System.arraycopy(arr, (mid + 1), rightArr, 0, rightLen);

        while (j < leftLen && k < rightLen) {
            if (worker.isCancelled()) return;
            step++;
            if (step >= speed) {
                step = 0;
                vis.sleep();
            }
            if (leftArr[j] <= rightArr[k]) {
                vis.update(i, leftArr[j]);
                j++;
            } else {
                vis.update(i, rightArr[k]);
                k++;
            }
            i++;
        }

        while (j < leftLen) {
            vis.update(i, leftArr[j]);
            j++;
            i++;
        }

        while (k < rightLen) {
            vis.update(i, rightArr[k]);
            k++;
            i++;
        }
    }
}
