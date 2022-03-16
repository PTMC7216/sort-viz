package com.company.sorts;

public class BubbleSort implements Sort {

    public int[] start(int[] arr) {
        int index_len = arr.length - 1;
        boolean loop = true;
        while (loop) {
            loop = false;
            for (int i = 0; i < index_len; i++) {
                if (arr[i] > arr[i + 1]) {
                    arr[i] =     arr[i] + arr[i + 1];
                    arr[i + 1] = arr[i] - arr[i + 1];
                    arr[i] =     arr[i] - arr[i + 1];
                    loop = true;
                }
            }
            index_len--;
        }
        return arr;
    }

}
