package main.java.sortvisualizer.sorts;

import main.java.sortvisualizer.panels.VisualizerPanel;
import main.java.sortvisualizer.utils.Publisher;

import java.util.Arrays;

public class GravitySort extends IterativeWorker {

    private static GravitySort instance = null;

    private GravitySort() {}

    public static GravitySort getInstance() {
        if (instance == null) {
            instance = new GravitySort();
        }
        return instance;
    }

    protected void sort(VisualizerPanel vis, int speed) {
        int[] arr = vis.getArr();
        int[] arrCopy = arr.clone();
        int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);
        int step = 0, updates = 0, subUpdates = 0;

        int[][] matrix = new int[arr.length][max];
        for(int i = 0; i < arr.length; i++) {
            step++;
            if (step >= speed) {
                step = 0;
                vis.sleep();
            }
            vis.subUpdate(i);
            worker.toPublish(new Publisher(1, subUpdates++));
            for(int j = 0; j < arr[i]; j++) {
                matrix[i][matrix[0].length - j - 1] = 1;
            }
        }

        for(int i = 0; i < matrix[0].length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                if(matrix[j][i] == 1) {
                    int k = j;
                    while(k + 1 < matrix.length && matrix[k][i] == 1) {
                        k++;
                    }
                    if(matrix[k][i] == 0) {
                        matrix[j][i] = 0;
                        matrix[k][i] = 1;
                    }
                }
            }

            int count;
            for (int x = 0; x < matrix.length; x++) {
                count = 0;
                for(int y = 0; y < matrix[0].length; y++) {
                    count += matrix[x][y];
                }
                if (worker.isCancelled()) {
                    vis.setArrCopy(arrCopy);
                    return;
                }
                step++;
                if (step >= speed) {
                    step = 0;
                    vis.sleep();
                }
                vis.update(x, count);
                worker.toPublish(new Publisher(0, updates++));
            }
        }
    }

}
