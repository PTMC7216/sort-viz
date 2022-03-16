package com.company.shuffles;

public class DurstenfeldShuffle {

    public int[] start(int[] arr) {
        int right = arr.length - 1;
        while (right > 0) {
            int rand = (int) (Math.random() * right);
            arr[rand] = arr[rand] + arr[right];
            arr[right] = arr[rand] - arr[right];
            arr[rand] = arr[rand] - arr[right];
            right--;
        }
        return arr;
    }

}
