package com.company.sorts;

import com.company.panels.ControlPanel;
import com.company.panels.VisualizerPanel;

import javax.swing.*;

public abstract class Sort {
    protected SwingWorker<Void, Void> worker;
    public abstract void start(VisualizerPanel vis, ControlPanel con, int sortSpeed);
    public void stop() {
        if (worker != null) {
            worker.cancel(false);
        }
    }
}

abstract class IterativeWorker extends Sort {
    public void start(VisualizerPanel vis, ControlPanel con, int speed) {
        worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                vis.setSorting(true);
                con.sortButton.setText("Stop");
                sort(vis, speed);
                return null;
            }
            @Override
            protected void done() {
                super.done();
                vis.resetHighlight();
                vis.setSorting(false);
                con.sortButton.setText("Sort");
                vis.getQueue().poll();
            }
        };
        worker.execute();
    }
    protected abstract void sort(VisualizerPanel vis, int speed);
}

abstract class RecursiveWorker extends Sort {
    public void start(VisualizerPanel vis, ControlPanel con, int speed) {
        worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                vis.setSorting(true);
                con.sortButton.setText("Stop");
                sort(vis, vis.getArr(), 0, -128, speed);
                return null;
            }
            @Override
            protected void done() {
                super.done();
                vis.resetHighlight();
                vis.setSorting(false);
                con.sortButton.setText("Sort");
                vis.getQueue().poll();
            }
        };
        worker.execute();
    }
    protected abstract void sort(VisualizerPanel vis, int[] arr, int left, int right, int speed);
}