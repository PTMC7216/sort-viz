package com.company.sorts;

public class QuickSort implements Sort {

    private static QuickSort instance = null;

    private QuickSort() {}

    public void start(int[] arr) {
        sort(arr, 0, -1);
    }

    private void sort(int[] arr, int left, int right) {
        if (right == -1) {
            right = arr.length - 1;
        }
        if (left < right) {
            int part = partition(arr, left, right);
            sort(arr, left, part - 1);
            sort(arr, part + 1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= arr[right]) {
                i++;
                if (i != j) {
                    arr[i] = arr[i] + arr[j];
                    arr[j] = arr[i] - arr[j];
                    arr[i] = arr[i] - arr[j];
                }
            }
        }
        if (arr[i + 1] != arr[right]) {
            arr[i + 1] = arr[i + 1] + arr[right];
            arr[right] = arr[i + 1] - arr[right];
            arr[i + 1] = arr[i + 1] - arr[right];
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
