package com.company.sorts;

import com.company.utils.Util;

public class QuickSort implements Sort {

    private static QuickSort instance = null;

    private QuickSort() {}

    public void start(int[] arr, int sortSpeed) {
        sort(arr, 0, -128, sortSpeed);
    }

    private void sort(int[] arr, int left, int right, int sortSpeed) {
        if (right == -128) {
            right = arr.length - 1;
        }
        if (left < right) {
            int part = partition(arr, left, right, sortSpeed);
            sort(arr, left, part - 1, sortSpeed);
            sort(arr, part + 1, right, sortSpeed);
        }
    }

    private int partition(int[] arr, int left, int right, int sortSpeed) {
        int step = 0;
        int i = left - 1;
        for (int j = left; j < right; j++) {
            step++;
            if (step == sortSpeed) {
                step = 0;
                Util.sleep();
            }
            if (arr[j] <= arr[right]) {
                i++;
                if (i != j) {
                    Util.swap(arr, i, j);
                }
            }
        }
        if (arr[i + 1] != arr[right]) {
            Util.sleep();
            Util.swap(arr, i + 1, right);
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
