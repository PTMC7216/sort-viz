package com.company.shuffles;

import com.company.panels.VisualizerPanel;

public class InstantShuffle {

    private static InstantShuffle instance = null;

    private InstantShuffle() {}

    public static InstantShuffle getInstance() {
        if (instance == null) {
            instance = new InstantShuffle();
        }
        return instance;
    }

    public void start(VisualizerPanel vis) {
        shuffle(vis);
    }

    private void shuffle(VisualizerPanel vis) {
        int[] arr = vis.getArr();
        int right = arr.length - 1;
        while (right > 0) {
            int rand = (int) (Math.random() * right);
            arr[rand] = (arr[rand] + arr[right]) - (arr[right] = arr[rand]);
            right--;
        }
    }

}
