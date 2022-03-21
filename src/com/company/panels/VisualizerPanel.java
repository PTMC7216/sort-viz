package com.company.panels;

import com.company.sorts.Sort;
import com.company.utils.ColorManager;

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

    private int[] arr = IntStream.rangeClosed(1, 512).toArray();
    private int[] highlight = new int[512];
    private final Queue<Sort> queue = new LinkedList<>();
    private boolean sorting = false;

    public VisualizerPanel() {
        setBackground(Color.BLACK);
        addComponentListener(this);
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

    public boolean isSorting() {
        return this.sorting;
    }

    public void setSorting(boolean bool) {
        this.sorting = bool;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        drawArr(g2D);
    }

    // TODO: Change rect color during swap.
    private void drawArr(Graphics2D g2D) {
        g2D.setPaint(ColorManager.tertiary);

        float rectWidthMax = (float) resX / arr.length;
        float rectHeightMax = (float) resY / arr.length;

        for (int i = 0; i < arr.length; i++) {
            g2D.fillRect(
                    (int)(i * rectWidthMax),
                    resY,
                    (int)(1 + rectWidthMax),
                    (int)(-arr[i] * rectHeightMax));
        }
    }

    public void swap(int[] arr, int i, int j) {
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
        repaint();
    }

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
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
