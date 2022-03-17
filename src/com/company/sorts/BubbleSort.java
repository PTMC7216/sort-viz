package com.company.sorts;

public class BubbleSort implements Sort {

    private static BubbleSort instance = null;

    private BubbleSort() {}

    public void start(int[] arr, int sortSpeed) {
        int index_len = arr.length - 1;
        int step = 0;
        boolean loop = true;
        while (loop) {
            loop = false;
            for (int i = 0; i < index_len; i++) {
                step++;
                if (step == sortSpeed) {
                    step = 0;
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (arr[i] > arr[i + 1]) {
                    arr[i] =     arr[i] + arr[i + 1];
                    arr[i + 1] = arr[i] - arr[i + 1];
                    arr[i] =     arr[i] - arr[i + 1];
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
