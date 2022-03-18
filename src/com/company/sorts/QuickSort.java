package com.company.sorts;

import com.company.panels.VisualizerPanel;

public class QuickSort implements Sort {

    private static QuickSort instance = null;

    private QuickSort() {}

    public void start(VisualizerPanel vis, int sortSpeed) {
        sort(vis, vis.arr, 0, -128, sortSpeed);
    }

    private void sort(VisualizerPanel vis, int[] arr, int left, int right, int sortSpeed) {
        if (right == -128) {
            right = arr.length - 1;
        }
        if (left < right) {
            int part = partition(vis, arr, left, right, sortSpeed);
            sort(vis, arr, left, part - 1, sortSpeed);
            sort(vis, arr, part + 1, right, sortSpeed);
        }
    }

    private int partition(VisualizerPanel vis, int[] arr, int left, int right, int sortSpeed) {
        int step = 0;
        int i = left - 1;
        for (int j = left; j < right; j++) {
            step++;
            if (step == sortSpeed) {
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
