package com.company.sorts;

public class QuickSort {

    public int[] sort(int[] arr) {
        sort(arr, 0, -1);
        return arr;
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

}
