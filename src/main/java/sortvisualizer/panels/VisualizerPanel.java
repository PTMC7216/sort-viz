package main.java.sortvisualizer.panels;

import main.java.sortvisualizer.sorts.Sort;
import main.java.sortvisualizer.utils.ColorManager;
import main.java.sortvisualizer.utils.Sound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class VisualizerPanel extends JPanel implements ComponentListener {

    private int resX;
    private int resY;

    private int[] arr = IntStream.rangeClosed(1, 2048).toArray();
    private int[] highlight = new int[2048];
    private final Queue<Sort> queue = new LinkedList<>();
    private boolean sorting = false;
    private boolean shuffling = false;

    private final Sound sound;

    public VisualizerPanel() {
        setBackground(ColorManager.QUATERNARY);
        addComponentListener(this);
        sound = new Sound(this);
    }

    public Queue<Sort> getQueue() {
        return this.queue;
    }

    public int[] getArr() {
        return this.arr;
    }

    public void setArr(int arrSize) {
        this.arr = IntStream.rangeClosed(1, arrSize).toArray();
        this.highlight = new int[arrSize];
    }

    public void setArrCopy(int[] copied_arr) {
        this.arr = copied_arr;
    }

    public void setVolume(int volume) {
        sound.setVolume(volume);
    }

    public boolean getSorting() {
        return this.sorting;
    }

    public void setSorting(boolean bool) {
        this.sorting = bool;
    }

    public boolean getShuffling() {
        return this.shuffling;
    }

    public void setShuffling(boolean bool) {
        this.shuffling = bool;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        drawArr(g2D);
    }

    private void drawArr(Graphics2D g2D) {
        g2D.setPaint(ColorManager.TERTIARY);

        float rectWidthMax = (float) resX / arr.length;
        float rectHeightMax = (float) resY / arr.length;

        for (int i = 0; i < arr.length; i++) {

            if (highlight[i] == 1) {
                g2D.setPaint(Color.RED);
            } else {
                g2D.setPaint(ColorManager.TERTIARY);
            }

            g2D.fillRect(
                    (int)(i * rectWidthMax),
                    resY,
                    (int)(1 + rectWidthMax),
                    (int)(-arr[i] * rectHeightMax));

            highlight[i] = 0;
        }
    }

    public boolean isSorted() {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public void swap(int i, int j) {
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
        highlight[i] = 1;
        highlight[j] = 1;
        sound.startNote(arr[i]);
        repaint();
        sound.stopNote(arr[i]);
    }

    public void update(int i, int j) {
        arr[i] = j;
        highlight[i] = 1;
        sound.startNote(arr[i]);
        repaint();
        sound.stopNote(arr[i]);
    }

    public void subUpdate(int i) {
        highlight[i] = 1;
        sound.startNote(arr[i]);
        repaint();
        sound.stopNote(arr[i]);
    }

    public void resetHighlight() {
        for (int i = 0; i < arr.length; i++) {
            highlight[i] = 0;
        }
        repaint();
        sound.stopAllNotes();
    }

    // TODO: Rework sleep and speed controls
    public void sleep() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
        resX = getWidth();
        resY = getHeight();
    }

    @Override
    public void componentMoved(ComponentEvent e) {}

    @Override
    public void componentShown(ComponentEvent e) {}

    @Override
    public void componentHidden(ComponentEvent e) {}
}
