package com.company.sorts;

import com.company.panels.VisualizerPanel;

public class BubbleSort implements Sort {

    private static BubbleSort instance = null;

    private BubbleSort() {}

    public void start(VisualizerPanel vis, int sortSpeed) {
        int[] arr = vis.arr;
        int index_len = arr.length - 1;
        int step = 0;
        boolean loop = true;
        while (loop) {
            loop = false;
            for (int i = 0; i < index_len; i++) {
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
