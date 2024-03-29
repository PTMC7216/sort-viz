package main.java.sortvisualizer.sorts;

import main.java.sortvisualizer.panels.ControlPanel;
import main.java.sortvisualizer.panels.VisualizerPanel;
import main.java.sortvisualizer.utils.PublishWorker;
import main.java.sortvisualizer.utils.Publisher;

import java.util.List;

public abstract class Sort {
    protected PublishWorker<Void, Publisher> worker;
    public abstract void start(VisualizerPanel vis, ControlPanel con, int sortSpeed);
    public void stop() {
        if (worker != null) {
            worker.cancel(false);
        }
    }
}

abstract class IterativeWorker extends Sort {
    public void start(VisualizerPanel vis, ControlPanel con, int speed) {
        worker = new PublishWorker<>() {
            @Override
            protected Void doInBackground() {
                vis.setSorting(true);
                con.setSortButtonText("Stop");
                con.setStatus("SORTING");
                con.resetLabelUpdates();
                sort(vis, speed);
                return null;
            }
            @Override
            protected void process(List<Publisher> chunks) {
                for (Publisher p : chunks){
                    if (p.getCategory() == 0) {
                        con.updateArrLabel(p.getData());
                    } else {
                        con.updateSubArrLabel(p.getData());
                    }
                }
            }
            @Override
            protected void done() {
                vis.resetHighlight();
                vis.setSorting(false);
                con.setSortButtonText("Sort");
                con.setStatus("IDLE");
                vis.getQueue().poll();
            }
        };
        worker.execute();
    }
    protected abstract void sort(VisualizerPanel vis, int speed);
}

abstract class RecursiveWorker extends Sort {
    public void start(VisualizerPanel vis, ControlPanel con, int speed) {
        worker = new PublishWorker<>() {
            @Override
            protected Void doInBackground() {
                vis.setSorting(true);
                con.setSortButtonText("Stop");
                con.setStatus("SORTING");
                con.resetLabelUpdates();
                sort(vis, vis.getArr(), 0, -128, speed);
                return null;
            }
            @Override
            protected void process(List<Publisher> chunks) {
                for (Publisher p : chunks){
                    if (p.getCategory() == 0) {
                        con.updateArrLabel(p.getData());
                    } else {
                        con.updateSubArrLabel(p.getData());
                    }
                }
            }
            @Override
            protected void done() {
                vis.resetHighlight();
                vis.setSorting(false);
                con.setSortButtonText("Sort");
                con.setStatus("IDLE");
                vis.getQueue().poll();
            }
        };
        worker.execute();
    }
    protected abstract void sort(VisualizerPanel vis, int[] arr, int left, int right, int speed);
}