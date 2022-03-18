package com.company.shuffles;

import com.company.panels.VisualizerPanel;

public class DurstenfeldShuffle {

    public void start(VisualizerPanel vis) {
        int[] arr = vis.getArr();
        int right = arr.length - 1;
        while (right > 0) {
            int rand = (int) (Math.random() * right);
            arr[rand] = arr[rand] + arr[right];
            arr[right] = arr[rand] - arr[right];
            arr[rand] = arr[rand] - arr[right];
            right--;
        }
        vis.repaint();
    }

}
